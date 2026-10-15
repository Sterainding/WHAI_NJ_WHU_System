package cn.iocoder.yudao.module.system.controller.admin.jzldrjtqk;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrjtqk.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjtqk.JzldrjtqkDO;
import cn.iocoder.yudao.module.system.service.jzldrjtqk.JzldrjtqkService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 家庭情况数据")
@RestController
@RequestMapping("/system/jzldrjtqk")
@Validated
public class JzldrjtqkController {

    @Resource
    private JzldrjtqkService jzldrjtqkService;

    @PostMapping("/create")
    @Operation(summary = "创建家庭情况数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrjtqk:create')")
    public CommonResult<String> createJzldrjtqk(@Valid @RequestBody JzldrjtqkSaveReqVO createReqVO) {
        return success(jzldrjtqkService.createJzldrjtqk(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新家庭情况数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrjtqk:update')")
    public CommonResult<Boolean> updateJzldrjtqk(@Valid @RequestBody JzldrjtqkSaveReqVO updateReqVO) {
        jzldrjtqkService.updateJzldrjtqk(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除家庭情况数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrjtqk:delete')")
    public CommonResult<Boolean> deleteJzldrjtqk(@RequestParam("id") String id) {
        jzldrjtqkService.deleteJzldrjtqk(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得家庭情况数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrjtqk:query')")
    public CommonResult<JzldrjtqkRespVO> getJzldrjtqk(@RequestParam("id") String id) {
        JzldrjtqkDO jzldrjtqk = jzldrjtqkService.getJzldrjtqk(id);
        return success(BeanUtils.toBean(jzldrjtqk, JzldrjtqkRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得家庭情况数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrjtqk:query')")
    public CommonResult<PageResult<JzldrjtqkRespVO>> getJzldrjtqkPage(@Valid JzldrjtqkPageReqVO pageReqVO) {
        PageResult<JzldrjtqkDO> pageResult = jzldrjtqkService.getJzldrjtqkPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrjtqkRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出家庭情况数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrjtqk:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrjtqkExcel(@Valid JzldrjtqkPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrjtqkDO> list = jzldrjtqkService.getJzldrjtqkPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "家庭情况数据.xls", "数据", JzldrjtqkRespVO.class,
                        BeanUtils.toBean(list, JzldrjtqkRespVO.class));
    }

}