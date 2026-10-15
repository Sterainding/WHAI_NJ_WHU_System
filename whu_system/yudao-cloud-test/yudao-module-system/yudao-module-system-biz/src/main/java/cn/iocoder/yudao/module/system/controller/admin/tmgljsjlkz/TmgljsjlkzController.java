package cn.iocoder.yudao.module.system.controller.admin.tmgljsjlkz;

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

import cn.iocoder.yudao.module.system.controller.admin.tmgljsjlkz.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgljsjlkz.TmgljsjlkzDO;
import cn.iocoder.yudao.module.system.service.tmgljsjlkz.TmgljsjlkzService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 军事交流项目和开支数据")
@RestController
@RequestMapping("/system/tmgljsjlkz")
@Validated
public class TmgljsjlkzController {

    @Resource
    private TmgljsjlkzService tmgljsjlkzService;

    @PostMapping("/create")
    @Operation(summary = "创建军事交流项目和开支数据")
    @PreAuthorize("@ss.hasPermission('system:tmgljsjlkz:create')")
    public CommonResult<String> createTmgljsjlkz(@Valid @RequestBody TmgljsjlkzSaveReqVO createReqVO) {
        return success(tmgljsjlkzService.createTmgljsjlkz(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新军事交流项目和开支数据")
    @PreAuthorize("@ss.hasPermission('system:tmgljsjlkz:update')")
    public CommonResult<Boolean> updateTmgljsjlkz(@Valid @RequestBody TmgljsjlkzSaveReqVO updateReqVO) {
        tmgljsjlkzService.updateTmgljsjlkz(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除军事交流项目和开支数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:tmgljsjlkz:delete')")
    public CommonResult<Boolean> deleteTmgljsjlkz(@RequestParam("id") String id) {
        tmgljsjlkzService.deleteTmgljsjlkz(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得军事交流项目和开支数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:tmgljsjlkz:query')")
    public CommonResult<TmgljsjlkzRespVO> getTmgljsjlkz(@RequestParam("id") String id) {
        TmgljsjlkzDO tmgljsjlkz = tmgljsjlkzService.getTmgljsjlkz(id);
        return success(BeanUtils.toBean(tmgljsjlkz, TmgljsjlkzRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得军事交流项目和开支数据分页")
    @PreAuthorize("@ss.hasPermission('system:tmgljsjlkz:query')")
    public CommonResult<PageResult<TmgljsjlkzRespVO>> getTmgljsjlkzPage(@Valid TmgljsjlkzPageReqVO pageReqVO) {
        PageResult<TmgljsjlkzDO> pageResult = tmgljsjlkzService.getTmgljsjlkzPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TmgljsjlkzRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出军事交流项目和开支数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:tmgljsjlkz:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTmgljsjlkzExcel(@Valid TmgljsjlkzPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TmgljsjlkzDO> list = tmgljsjlkzService.getTmgljsjlkzPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "军事交流项目和开支数据.xls", "数据", TmgljsjlkzRespVO.class,
                        BeanUtils.toBean(list, TmgljsjlkzRespVO.class));
    }

}