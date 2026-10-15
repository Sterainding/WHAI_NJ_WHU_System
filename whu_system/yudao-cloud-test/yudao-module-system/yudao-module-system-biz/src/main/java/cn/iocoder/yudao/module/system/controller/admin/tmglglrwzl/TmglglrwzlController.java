package cn.iocoder.yudao.module.system.controller.admin.tmglglrwzl;

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

import cn.iocoder.yudao.module.system.controller.admin.tmglglrwzl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglrwzl.TmglglrwzlDO;
import cn.iocoder.yudao.module.system.service.tmglglrwzl.TmglglrwzlService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 人员资料数据")
@RestController
@RequestMapping("/system/tmglglrwzl")
@Validated
public class TmglglrwzlController {

    @Resource
    private TmglglrwzlService tmglglrwzlService;

    @PostMapping("/create")
    @Operation(summary = "创建人员资料数据")
    @PreAuthorize("@ss.hasPermission('system:tmglglrwzl:create')")
    public CommonResult<String> createTmglglrwzl(@Valid @RequestBody TmglglrwzlSaveReqVO createReqVO) {
        return success(tmglglrwzlService.createTmglglrwzl(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新人员资料数据")
    @PreAuthorize("@ss.hasPermission('system:tmglglrwzl:update')")
    public CommonResult<Boolean> updateTmglglrwzl(@Valid @RequestBody TmglglrwzlSaveReqVO updateReqVO) {
        tmglglrwzlService.updateTmglglrwzl(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除人员资料数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmglglrwzl:delete')")
    public CommonResult<Boolean> deleteTmglglrwzl(@RequestParam("id") String id) {
        tmglglrwzlService.deleteTmglglrwzl(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得人员资料数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmglglrwzl:query')")
    public CommonResult<TmglglrwzlRespVO> getTmglglrwzl(@RequestParam("id") String id) {
        TmglglrwzlDO tmglglrwzl = tmglglrwzlService.getTmglglrwzl(id);
        return success(BeanUtils.toBean(tmglglrwzl, TmglglrwzlRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得人员资料数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmglglrwzl:query')")
    public CommonResult<PageResult<TmglglrwzlRespVO>> getTmglglrwzlPage(@Valid TmglglrwzlPageReqVO pageReqVO) {
        PageResult<TmglglrwzlDO> pageResult = tmglglrwzlService.getTmglglrwzlPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmglglrwzlRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出人员资料数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmglglrwzl:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmglglrwzlExcel(@Valid TmglglrwzlPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmglglrwzlDO> list = tmglglrwzlService.getTmglglrwzlPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "人员资料数据.xls", "数据", TmglglrwzlRespVO.class,
                        BeanUtils.toBean(list, TmglglrwzlRespVO.class));
    }

}