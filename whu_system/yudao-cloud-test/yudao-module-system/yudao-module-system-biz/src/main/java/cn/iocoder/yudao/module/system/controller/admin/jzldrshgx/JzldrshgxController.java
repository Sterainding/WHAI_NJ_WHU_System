package cn.iocoder.yudao.module.system.controller.admin.jzldrshgx;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrshgx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrshgx.JzldrshgxDO;
import cn.iocoder.yudao.module.system.service.jzldrshgx.JzldrshgxService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 社会关系数据")
@RestController
@RequestMapping("/system/jzldrshgx")
@Validated
public class JzldrshgxController {

    @Resource
    private JzldrshgxService jzldrshgxService;

    @PostMapping("/create")
    @Operation(summary = "创建社会关系数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrshgx:create')")
    public CommonResult<String> createJzldrshgx(@Valid @RequestBody JzldrshgxSaveReqVO createReqVO) {
        return success(jzldrshgxService.createJzldrshgx(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新社会关系数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrshgx:update')")
    public CommonResult<Boolean> updateJzldrshgx(@Valid @RequestBody JzldrshgxSaveReqVO updateReqVO) {
        jzldrshgxService.updateJzldrshgx(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除社会关系数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrshgx:delete')")
    public CommonResult<Boolean> deleteJzldrshgx(@RequestParam("id") String id) {
        jzldrshgxService.deleteJzldrshgx(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得社会关系数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrshgx:query')")
    public CommonResult<JzldrshgxRespVO> getJzldrshgx(@RequestParam("id") String id) {
        JzldrshgxDO jzldrshgx = jzldrshgxService.getJzldrshgx(id);
        return success(BeanUtils.toBean(jzldrshgx, JzldrshgxRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得社会关系数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrshgx:query')")
    public CommonResult<PageResult<JzldrshgxRespVO>> getJzldrshgxPage(@Valid JzldrshgxPageReqVO pageReqVO) {
        PageResult<JzldrshgxDO> pageResult = jzldrshgxService.getJzldrshgxPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrshgxRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出社会关系数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrshgx:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrshgxExcel(@Valid JzldrshgxPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrshgxDO> list = jzldrshgxService.getJzldrshgxPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "社会关系数据.xls", "数据", JzldrshgxRespVO.class,
                        BeanUtils.toBean(list, JzldrshgxRespVO.class));
    }

}