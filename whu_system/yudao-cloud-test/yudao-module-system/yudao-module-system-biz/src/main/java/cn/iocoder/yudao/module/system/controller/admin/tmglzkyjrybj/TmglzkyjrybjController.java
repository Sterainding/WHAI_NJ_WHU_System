package cn.iocoder.yudao.module.system.controller.admin.tmglzkyjrybj;

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

import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjrybj.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjrybj.TmglzkyjrybjDO;
import cn.iocoder.yudao.module.system.service.tmglzkyjrybj.TmglzkyjrybjService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 智库研究员背景数据")
@RestController
@RequestMapping("/system/tmglzkyjrybj")
@Validated
public class TmglzkyjrybjController {

    @Resource
    private TmglzkyjrybjService tmglzkyjrybjService;

    @PostMapping("/create")
    @Operation(summary = "创建智库研究员背景数据")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjrybj:create')")
    public CommonResult<String> createTmglzkyjrybj(@Valid @RequestBody TmglzkyjrybjSaveReqVO createReqVO) {
        return success(tmglzkyjrybjService.createTmglzkyjrybj(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新智库研究员背景数据")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjrybj:update')")
    public CommonResult<Boolean> updateTmglzkyjrybj(@Valid @RequestBody TmglzkyjrybjSaveReqVO updateReqVO) {
        tmglzkyjrybjService.updateTmglzkyjrybj(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除智库研究员背景数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjrybj:delete')")
    public CommonResult<Boolean> deleteTmglzkyjrybj(@RequestParam("id") String id) {
        tmglzkyjrybjService.deleteTmglzkyjrybj(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得智库研究员背景数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjrybj:query')")
    public CommonResult<TmglzkyjrybjRespVO> getTmglzkyjrybj(@RequestParam("id") String id) {
        TmglzkyjrybjDO tmglzkyjrybj = tmglzkyjrybjService.getTmglzkyjrybj(id);
        return success(BeanUtils.toBean(tmglzkyjrybj, TmglzkyjrybjRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得智库研究员背景数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjrybj:query')")
    public CommonResult<PageResult<TmglzkyjrybjRespVO>> getTmglzkyjrybjPage(@Valid TmglzkyjrybjPageReqVO pageReqVO) {
        PageResult<TmglzkyjrybjDO> pageResult = tmglzkyjrybjService.getTmglzkyjrybjPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmglzkyjrybjRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出智库研究员背景数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjrybj:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmglzkyjrybjExcel(@Valid TmglzkyjrybjPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmglzkyjrybjDO> list = tmglzkyjrybjService.getTmglzkyjrybjPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "智库研究员背景数据.xls", "数据", TmglzkyjrybjRespVO.class,
                        BeanUtils.toBean(list, TmglzkyjrybjRespVO.class));
    }

}