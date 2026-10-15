package cn.iocoder.yudao.module.system.controller.admin.jzldryjl;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldryjl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldryjl.JzldryjlDO;
import cn.iocoder.yudao.module.system.service.jzldryjl.JzldryjlService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 教育经历数据")
@RestController
@RequestMapping("/system/jzldryjl")
@Validated
public class JzldryjlController {

    @Resource
    private JzldryjlService jzldryjlService;

    @PostMapping("/create")
    @Operation(summary = "创建教育经历数据")
    @PreAuthorize("@ss.hasPermission('system:jzldryjl:create')")
    public CommonResult<String> createJzldryjl(@Valid @RequestBody JzldryjlSaveReqVO createReqVO) {
        return success(jzldryjlService.createJzldryjl(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新教育经历数据")
    @PreAuthorize("@ss.hasPermission('system:jzldryjl:update')")
    public CommonResult<Boolean> updateJzldryjl(@Valid @RequestBody JzldryjlSaveReqVO updateReqVO) {
        jzldryjlService.updateJzldryjl(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除教育经历数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldryjl:delete')")
    public CommonResult<Boolean> deleteJzldryjl(@RequestParam("id") String id) {
        jzldryjlService.deleteJzldryjl(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得教育经历数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldryjl:query')")
    public CommonResult<JzldryjlRespVO> getJzldryjl(@RequestParam("id") String id) {
        JzldryjlDO jzldryjl = jzldryjlService.getJzldryjl(id);
        return success(BeanUtils.toBean(jzldryjl, JzldryjlRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得教育经历数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldryjl:query')")
    public CommonResult<PageResult<JzldryjlRespVO>> getJzldryjlPage(@Valid JzldryjlPageReqVO pageReqVO) {
        PageResult<JzldryjlDO> pageResult = jzldryjlService.getJzldryjlPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldryjlRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出教育经历数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldryjl:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldryjlExcel(@Valid JzldryjlPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldryjlDO> list = jzldryjlService.getJzldryjlPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "教育经历数据.xls", "数据", JzldryjlRespVO.class,
                        BeanUtils.toBean(list, JzldryjlRespVO.class));
    }

}