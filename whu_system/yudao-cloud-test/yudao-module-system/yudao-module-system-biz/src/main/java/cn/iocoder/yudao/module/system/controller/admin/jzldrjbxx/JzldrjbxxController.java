package cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjbxx.JzldrjbxxDO;
import cn.iocoder.yudao.module.system.service.jzldrjbxx.JzldrjbxxService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 基本信息数据")
@RestController
@RequestMapping("/system/jzldrjbxx")
@Validated

public class JzldrjbxxController {

    @Resource
    private JzldrjbxxService jzldrjbxxService;

    @PostMapping("/create")
    @Operation(summary = "创建基本信息数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrjbxx:create')")
    public CommonResult<String> createJzldrjbxx(@Valid @RequestBody JzldrjbxxSaveReqVO createReqVO) {
        return success(jzldrjbxxService.createJzldrjbxx(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基本信息数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrjbxx:update')")
    public CommonResult<Boolean> updateJzldrjbxx(@Valid @RequestBody JzldrjbxxSaveReqVO updateReqVO) {
        jzldrjbxxService.updateJzldrjbxx(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基本信息数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrjbxx:delete')")
    public CommonResult<Boolean> deleteJzldrjbxx(@RequestParam("id") String id) {
        jzldrjbxxService.deleteJzldrjbxx(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基本信息数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrjbxx:query')")
    public CommonResult<JzldrjbxxRespVO> getJzldrjbxx(@RequestParam("id") String id) {
        JzldrjbxxDO jzldrjbxx = jzldrjbxxService.getJzldrjbxx(id);
        return success(BeanUtils.toBean(jzldrjbxx, JzldrjbxxRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基本信息数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrjbxx:query')")
    public CommonResult<PageResult<JzldrjbxxRespVO>> getJzldrjbxxPage(@Valid JzldrjbxxPageReqVO pageReqVO) {
        PageResult<JzldrjbxxDO> pageResult = jzldrjbxxService.getJzldrjbxxPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrjbxxRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基本信息数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrjbxx:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrjbxxExcel(@Valid JzldrjbxxPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrjbxxDO> list = jzldrjbxxService.getJzldrjbxxPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基本信息数据.xls", "数据", JzldrjbxxRespVO.class,
                        BeanUtils.toBean(list, JzldrjbxxRespVO.class));
    }

}