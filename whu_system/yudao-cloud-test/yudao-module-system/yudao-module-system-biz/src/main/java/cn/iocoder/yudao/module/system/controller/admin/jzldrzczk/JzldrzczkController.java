package cn.iocoder.yudao.module.system.controller.admin.jzldrzczk;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.system.controller.admin.jzldrzczk.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzczk.JzldrzczkDO;
import cn.iocoder.yudao.module.system.service.jzldrzczk.JzldrzczkService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 资产状况数据")
@RestController
@RequestMapping("/system/jzldrzczk")
@Validated
public class JzldrzczkController {

    @Resource
    private JzldrzczkService jzldrzczkService;

    @PostMapping("/create")
    @Operation(summary = "创建资产状况数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrzczk:create')")
    public CommonResult<String> createJzldrzczk(@Valid @RequestBody JzldrzczkSaveReqVO createReqVO) {
        return success(jzldrzczkService.createJzldrzczk(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新资产状况数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrzczk:update')")
    public CommonResult<Boolean> updateJzldrzczk(@Valid @RequestBody JzldrzczkSaveReqVO updateReqVO) {
        jzldrzczkService.updateJzldrzczk(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除资产状况数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrzczk:delete')")
    public CommonResult<Boolean> deleteJzldrzczk(@RequestParam("id") String id) {
        jzldrzczkService.deleteJzldrzczk(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得资产状况数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrzczk:query')")
    public CommonResult<JzldrzczkRespVO> getJzldrzczk(@RequestParam("id") String id) {
        JzldrzczkDO jzldrzczk = jzldrzczkService.getJzldrzczk(id);
        return success(BeanUtils.toBean(jzldrzczk, JzldrzczkRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得资产状况数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrzczk:query')")
    public CommonResult<PageResult<JzldrzczkRespVO>> getJzldrzczkPage(@Valid JzldrzczkPageReqVO pageReqVO) {
        PageResult<JzldrzczkDO> pageResult = jzldrzczkService.getJzldrzczkPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrzczkRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出资产状况数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrzczk:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrzczkExcel(@Valid JzldrzczkPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrzczkDO> list = jzldrzczkService.getJzldrzczkPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "资产状况数据.xls", "数据", JzldrzczkRespVO.class,
                        BeanUtils.toBean(list, JzldrzczkRespVO.class));
    }

}