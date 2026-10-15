package cn.iocoder.yudao.module.system.controller.admin.tmgltmfwys;

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

import cn.iocoder.yudao.module.system.controller.admin.tmgltmfwys.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmfwys.TmgltmfwysDO;
import cn.iocoder.yudao.module.system.service.tmgltmfwys.TmgltmfwysService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 台美防务预算数据")
@RestController
@RequestMapping("/system/tmgltmfwys")
@Validated
public class TmgltmfwysController {

    @Resource
    private TmgltmfwysService tmgltmfwysService;

    @PostMapping("/create")
    @Operation(summary = "创建台美防务预算数据")
    @PreAuthorize("@ss.hasPermission('system:tmgltmfwys:create')")
    public CommonResult<String> createTmgltmfwys(@Valid @RequestBody TmgltmfwysSaveReqVO createReqVO) {
        return success(tmgltmfwysService.createTmgltmfwys(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新台美防务预算数据")
    @PreAuthorize("@ss.hasPermission('system:tmgltmfwys:update')")
    public CommonResult<Boolean> updateTmgltmfwys(@Valid @RequestBody TmgltmfwysSaveReqVO updateReqVO) {
        tmgltmfwysService.updateTmgltmfwys(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除台美防务预算数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmgltmfwys:delete')")
    public CommonResult<Boolean> deleteTmgltmfwys(@RequestParam("id") String id) {
        tmgltmfwysService.deleteTmgltmfwys(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得台美防务预算数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmgltmfwys:query')")
    public CommonResult<TmgltmfwysRespVO> getTmgltmfwys(@RequestParam("id") String id) {
        TmgltmfwysDO tmgltmfwys = tmgltmfwysService.getTmgltmfwys(id);
        return success(BeanUtils.toBean(tmgltmfwys, TmgltmfwysRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得台美防务预算数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmgltmfwys:query')")
    public CommonResult<PageResult<TmgltmfwysRespVO>> getTmgltmfwysPage(@Valid TmgltmfwysPageReqVO pageReqVO) {
        PageResult<TmgltmfwysDO> pageResult = tmgltmfwysService.getTmgltmfwysPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmgltmfwysRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出台美防务预算数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmgltmfwys:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmgltmfwysExcel(@Valid TmgltmfwysPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmgltmfwysDO> list = tmgltmfwysService.getTmgltmfwysPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "台美防务预算数据.xls", "数据", TmgltmfwysRespVO.class,
                        BeanUtils.toBean(list, TmgltmfwysRespVO.class));
    }

}