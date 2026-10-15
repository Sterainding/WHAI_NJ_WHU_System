package cn.iocoder.yudao.module.system.controller.admin.tmglzkyjbg;

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

import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjbg.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjbg.TmglzkyjbgDO;
import cn.iocoder.yudao.module.system.service.tmglzkyjbg.TmglzkyjbgService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 智库研究报告数据")
@RestController
@RequestMapping("/system/tmglzkyjbg")
@Validated

public class TmglzkyjbgController {

    @Resource
    private TmglzkyjbgService tmglzkyjbgService;

    @PostMapping("/create")
    @Operation(summary = "创建智库研究报告数据")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjbg:create')")
    public CommonResult<String> createTmglzkyjbg(@Valid @RequestBody TmglzkyjbgSaveReqVO createReqVO) {
        return success(tmglzkyjbgService.createTmglzkyjbg(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新智库研究报告数据")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjbg:update')")
    public CommonResult<Boolean> updateTmglzkyjbg(@Valid @RequestBody TmglzkyjbgSaveReqVO updateReqVO) {
        tmglzkyjbgService.updateTmglzkyjbg(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除智库研究报告数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjbg:delete')")
    public CommonResult<Boolean> deleteTmglzkyjbg(@RequestParam("id") String id) {
        tmglzkyjbgService.deleteTmglzkyjbg(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得智库研究报告数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjbg:query')")
    public CommonResult<TmglzkyjbgRespVO> getTmglzkyjbg(@RequestParam("id") String id) {
        TmglzkyjbgDO tmglzkyjbg = tmglzkyjbgService.getTmglzkyjbg(id);
        return success(BeanUtils.toBean(tmglzkyjbg, TmglzkyjbgRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得智库研究报告数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjbg:query')")
    public CommonResult<PageResult<TmglzkyjbgRespVO>> getTmglzkyjbgPage(@Valid TmglzkyjbgPageReqVO pageReqVO) {
        PageResult<TmglzkyjbgDO> pageResult = tmglzkyjbgService.getTmglzkyjbgPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmglzkyjbgRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出智库研究报告数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmglzkyjbg:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmglzkyjbgExcel(@Valid TmglzkyjbgPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmglzkyjbgDO> list = tmglzkyjbgService.getTmglzkyjbgPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "智库研究报告数据.xls", "数据", TmglzkyjbgRespVO.class,
                        BeanUtils.toBean(list, TmglzkyjbgRespVO.class));
    }

}