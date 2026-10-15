package cn.iocoder.yudao.module.system.controller.admin.jzldrsjzh;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrsjzh.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrsjzh.jzldrsjzhDO;
import cn.iocoder.yudao.module.system.service.jzldrsjzh.jzldrsjzhService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 社交账号数据")
@RestController
@RequestMapping("/system/jzldrsjzh")
@Validated
public class jzldrsjzhController {

    @Resource
    private jzldrsjzhService jzldrsjzhService;

    @PostMapping("/create")
    @Operation(summary = "创建社交账号数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrsjzh:create')")
    public CommonResult<String> createjzldrsjzh(@Valid @RequestBody jzldrsjzhSaveReqVO createReqVO) {
        return success(jzldrsjzhService.createjzldrsjzh(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新社交账号数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrsjzh:update')")
    public CommonResult<Boolean> updatejzldrsjzh(@Valid @RequestBody jzldrsjzhSaveReqVO updateReqVO) {
        jzldrsjzhService.updatejzldrsjzh(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除社交账号数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrsjzh:delete')")
    public CommonResult<Boolean> deletejzldrsjzh(@RequestParam("id") String id) {
        jzldrsjzhService.deletejzldrsjzh(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得社交账号数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrsjzh:query')")
    public CommonResult<jzldrsjzhRespVO> getjzldrsjzh(@RequestParam("id") String id) {
        jzldrsjzhDO jzldrsjzh = jzldrsjzhService.getjzldrsjzh(id);
        return success(BeanUtils.toBean(jzldrsjzh, jzldrsjzhRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得社交账号数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrsjzh:query')")
    public CommonResult<PageResult<jzldrsjzhRespVO>> getjzldrsjzhPage(@Valid jzldrsjzhPageReqVO pageReqVO) {
        PageResult<jzldrsjzhDO> pageResult = jzldrsjzhService.getjzldrsjzhPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, jzldrsjzhRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出社交账号数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrsjzh:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportjzldrsjzhExcel(@Valid jzldrsjzhPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<jzldrsjzhDO> list = jzldrsjzhService.getjzldrsjzhPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "社交账号数据.xls", "数据", jzldrsjzhRespVO.class,
                        BeanUtils.toBean(list, jzldrsjzhRespVO.class));
    }

}