package cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrzjl.JzldrrzjlDO;
import cn.iocoder.yudao.module.system.service.jzldrrzjl.JzldrrzjlService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 任职经历数据")
@RestController
@RequestMapping("/system/jzldrrzjl")
@Validated
public class JzldrrzjlController {

    @Resource
    private JzldrrzjlService jzldrrzjlService;

    @PostMapping("/create")
    @Operation(summary = "创建任职经历数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrrzjl:create')")
    public CommonResult<String> createJzldrrzjl(@Valid @RequestBody JzldrrzjlSaveReqVO createReqVO) {
        return success(jzldrrzjlService.createJzldrrzjl(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新任职经历数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrrzjl:update')")
    public CommonResult<Boolean> updateJzldrrzjl(@Valid @RequestBody JzldrrzjlSaveReqVO updateReqVO) {
        jzldrrzjlService.updateJzldrrzjl(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除任职经历数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrrzjl:delete')")
    public CommonResult<Boolean> deleteJzldrrzjl(@RequestParam("id") String id) {
        jzldrrzjlService.deleteJzldrrzjl(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得任职经历数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrrzjl:query')")
    public CommonResult<JzldrrzjlRespVO> getJzldrrzjl(@RequestParam("id") String id) {
        JzldrrzjlDO jzldrrzjl = jzldrrzjlService.getJzldrrzjl(id);
        return success(BeanUtils.toBean(jzldrrzjl, JzldrrzjlRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得任职经历数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrrzjl:query')")
    public CommonResult<PageResult<JzldrrzjlRespVO>> getJzldrrzjlPage(@Valid JzldrrzjlPageReqVO pageReqVO) {
        PageResult<JzldrrzjlDO> pageResult = jzldrrzjlService.getJzldrrzjlPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrrzjlRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出任职经历数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrrzjl:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrrzjlExcel(@Valid JzldrrzjlPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrrzjlDO> list = jzldrrzjlService.getJzldrrzjlPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "任职经历数据.xls", "数据", JzldrrzjlRespVO.class,
                        BeanUtils.toBean(list, JzldrrzjlRespVO.class));
    }

}