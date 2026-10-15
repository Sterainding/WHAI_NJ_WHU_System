package cn.iocoder.yudao.module.system.controller.admin.tmglglgxwl;

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

import cn.iocoder.yudao.module.system.controller.admin.tmglglgxwl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglgxwl.TmglglgxwlDO;
import cn.iocoder.yudao.module.system.service.tmglglgxwl.TmglglgxwlService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 关系网络数据")
@RestController
@RequestMapping("/system/tmglglgxwl")
@Validated
public class TmglglgxwlController {

    @Resource
    private TmglglgxwlService tmglglgxwlService;

    @PostMapping("/create")
    @Operation(summary = "创建关系网络数据")
    @PreAuthorize("@ss.hasPermission('system:tmglglgxwl:create')")
    public CommonResult<String> createTmglglgxwl(@Valid @RequestBody TmglglgxwlSaveReqVO createReqVO) {
        return success(tmglglgxwlService.createTmglglgxwl(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新关系网络数据")
    @PreAuthorize("@ss.hasPermission('system:tmglglgxwl:update')")
    public CommonResult<Boolean> updateTmglglgxwl(@Valid @RequestBody TmglglgxwlSaveReqVO updateReqVO) {
        tmglglgxwlService.updateTmglglgxwl(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除关系网络数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmglglgxwl:delete')")
    public CommonResult<Boolean> deleteTmglglgxwl(@RequestParam("id") String id) {
        tmglglgxwlService.deleteTmglglgxwl(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得关系网络数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmglglgxwl:query')")
    public CommonResult<TmglglgxwlRespVO> getTmglglgxwl(@RequestParam("id") String id) {
        TmglglgxwlDO tmglglgxwl = tmglglgxwlService.getTmglglgxwl(id);
        return success(BeanUtils.toBean(tmglglgxwl, TmglglgxwlRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得关系网络数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmglglgxwl:query')")
    public CommonResult<PageResult<TmglglgxwlRespVO>> getTmglglgxwlPage(@Valid TmglglgxwlPageReqVO pageReqVO) {
        PageResult<TmglglgxwlDO> pageResult = tmglglgxwlService.getTmglglgxwlPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmglglgxwlRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出关系网络数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmglglgxwl:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmglglgxwlExcel(@Valid TmglglgxwlPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmglglgxwlDO> list = tmglglgxwlService.getTmglglgxwlPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "关系网络数据.xls", "数据", TmglglgxwlRespVO.class,
                        BeanUtils.toBean(list, TmglglgxwlRespVO.class));
    }

}