package cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd;

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

import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxryhd.TmgltmdxryhdDO;
import cn.iocoder.yudao.module.system.service.tmgltmdxryhd.TmgltmdxryhdService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 人员活动数据")
@RestController
@RequestMapping("/system/tmgltmdxryhd")
@Validated
public class TmgltmdxryhdController {

    @Resource
    private TmgltmdxryhdService tmgltmdxryhdService;

    @PostMapping("/create")
    @Operation(summary = "创建人员活动数据")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxryhd:create')")
    public CommonResult<String> createTmgltmdxryhd(@Valid @RequestBody TmgltmdxryhdSaveReqVO createReqVO) {
        return success(tmgltmdxryhdService.createTmgltmdxryhd(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新人员活动数据")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxryhd:update')")
    public CommonResult<Boolean> updateTmgltmdxryhd(@Valid @RequestBody TmgltmdxryhdSaveReqVO updateReqVO) {
        tmgltmdxryhdService.updateTmgltmdxryhd(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除人员活动数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxryhd:delete')")
    public CommonResult<Boolean> deleteTmgltmdxryhd(@RequestParam("id") String id) {
        tmgltmdxryhdService.deleteTmgltmdxryhd(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得人员活动数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxryhd:query')")
    public CommonResult<TmgltmdxryhdRespVO> getTmgltmdxryhd(@RequestParam("id") String id) {
        TmgltmdxryhdDO tmgltmdxryhd = tmgltmdxryhdService.getTmgltmdxryhd(id);
        return success(BeanUtils.toBean(tmgltmdxryhd, TmgltmdxryhdRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得人员活动数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxryhd:query')")
    public CommonResult<PageResult<TmgltmdxryhdRespVO>> getTmgltmdxryhdPage(@Valid TmgltmdxryhdPageReqVO pageReqVO) {
        PageResult<TmgltmdxryhdDO> pageResult = tmgltmdxryhdService.getTmgltmdxryhdPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmgltmdxryhdRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出人员活动数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxryhd:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmgltmdxryhdExcel(@Valid TmgltmdxryhdPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmgltmdxryhdDO> list = tmgltmdxryhdService.getTmgltmdxryhdPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "人员活动数据.xls", "数据", TmgltmdxryhdRespVO.class,
                        BeanUtils.toBean(list, TmgltmdxryhdRespVO.class));
    }

}