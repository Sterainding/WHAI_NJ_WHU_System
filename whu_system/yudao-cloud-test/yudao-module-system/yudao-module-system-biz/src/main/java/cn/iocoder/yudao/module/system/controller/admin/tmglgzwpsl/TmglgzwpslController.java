package cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl;

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

import cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglgzwpsl.TmglgzwpslDO;
import cn.iocoder.yudao.module.system.service.tmglgzwpsl.TmglgzwpslService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 购置物品及数量数据")
@RestController
@RequestMapping("/system/tmglgzwpsl")
@Validated
public class TmglgzwpslController {

    @Resource
    private TmglgzwpslService tmglgzwpslService;

    @PostMapping("/create")
    @Operation(summary = "创建购置物品及数量数据")
    @PreAuthorize("@ss.hasPermission('system:tmglgzwpsl:create')")
    public CommonResult<String> createTmglgzwpsl(@Valid @RequestBody TmglgzwpslSaveReqVO createReqVO) {
        return success(tmglgzwpslService.createTmglgzwpsl(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新购置物品及数量数据")
    @PreAuthorize("@ss.hasPermission('system:tmglgzwpsl:update')")
    public CommonResult<Boolean> updateTmglgzwpsl(@Valid @RequestBody TmglgzwpslSaveReqVO updateReqVO) {
        tmglgzwpslService.updateTmglgzwpsl(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除购置物品及数量数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmglgzwpsl:delete')")
    public CommonResult<Boolean> deleteTmglgzwpsl(@RequestParam("id") String id) {
        tmglgzwpslService.deleteTmglgzwpsl(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得购置物品及数量数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmglgzwpsl:query')")
    public CommonResult<TmglgzwpslRespVO> getTmglgzwpsl(@RequestParam("id") String id) {
        TmglgzwpslDO tmglgzwpsl = tmglgzwpslService.getTmglgzwpsl(id);
        return success(BeanUtils.toBean(tmglgzwpsl, TmglgzwpslRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得购置物品及数量数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmglgzwpsl:query')")
    public CommonResult<PageResult<TmglgzwpslRespVO>> getTmglgzwpslPage(@Valid TmglgzwpslPageReqVO pageReqVO) {
        PageResult<TmglgzwpslDO> pageResult = tmglgzwpslService.getTmglgzwpslPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmglgzwpslRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出购置物品及数量数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmglgzwpsl:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmglgzwpslExcel(@Valid TmglgzwpslPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmglgzwpslDO> list = tmglgzwpslService.getTmglgzwpslPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "购置物品及数量数据.xls", "数据", TmglgzwpslRespVO.class,
                        BeanUtils.toBean(list, TmglgzwpslRespVO.class));
    }

}