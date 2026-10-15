package cn.iocoder.yudao.module.system.controller.admin.tmgltmdxjs;

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

import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxjs.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxjs.TmgltmdxjsDO;
import cn.iocoder.yudao.module.system.service.tmgltmdxjs.TmgltmdxjsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 军售数据")
@RestController
@RequestMapping("/system/tmgltmdxjs")
@Validated
public class TmgltmdxjsController {

    @Resource
    private TmgltmdxjsService tmgltmdxjsService;

    @PostMapping("/create")
    @Operation(summary = "创建军售数据")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxjs:create')")
    public CommonResult<String> createTmgltmdxjs(@Valid @RequestBody TmgltmdxjsSaveReqVO createReqVO) {
        return success(tmgltmdxjsService.createTmgltmdxjs(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新军售数据")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxjs:update')")
    public CommonResult<Boolean> updateTmgltmdxjs(@Valid @RequestBody TmgltmdxjsSaveReqVO updateReqVO) {
        tmgltmdxjsService.updateTmgltmdxjs(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除军售数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxjs:delete')")
    public CommonResult<Boolean> deleteTmgltmdxjs(@RequestParam("id") String id) {
        tmgltmdxjsService.deleteTmgltmdxjs(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得军售数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxjs:query')")
    public CommonResult<TmgltmdxjsRespVO> getTmgltmdxjs(@RequestParam("id") String id) {
        TmgltmdxjsDO tmgltmdxjs = tmgltmdxjsService.getTmgltmdxjs(id);
        return success(BeanUtils.toBean(tmgltmdxjs, TmgltmdxjsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得军售数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxjs:query')")
    public CommonResult<PageResult<TmgltmdxjsRespVO>> getTmgltmdxjsPage(@Valid TmgltmdxjsPageReqVO pageReqVO) {
        PageResult<TmgltmdxjsDO> pageResult = tmgltmdxjsService.getTmgltmdxjsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmgltmdxjsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出军售数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmgltmdxjs:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmgltmdxjsExcel(@Valid TmgltmdxjsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmgltmdxjsDO> list = tmgltmdxjsService.getTmgltmdxjsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "军售数据.xls", "数据", TmgltmdxjsRespVO.class,
                        BeanUtils.toBean(list, TmgltmdxjsRespVO.class));
    }

}