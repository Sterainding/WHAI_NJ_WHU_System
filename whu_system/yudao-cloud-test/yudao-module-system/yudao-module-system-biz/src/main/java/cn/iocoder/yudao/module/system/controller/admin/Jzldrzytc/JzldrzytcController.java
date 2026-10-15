package cn.iocoder.yudao.module.system.controller.admin.Jzldrzytc;

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

import cn.iocoder.yudao.module.system.controller.admin.Jzldrzytc.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.Jzldrzytc.JzldrzytcDO;
import cn.iocoder.yudao.module.system.service.Jzldrzytc.JzldrzytcService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 专业特长数据")
@RestController
@RequestMapping("/system/jzldrzytc")
@Validated
public class JzldrzytcController {

    @Resource
    private JzldrzytcService jzldrzytcService;

    @PostMapping("/create")
    @Operation(summary = "创建专业特长数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrzytc:create')")
    public CommonResult<String> createJzldrzytc(@Valid @RequestBody JzldrzytcSaveReqVO createReqVO) {
        return success(jzldrzytcService.createJzldrzytc(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新专业特长数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrzytc:update')")
    public CommonResult<Boolean> updateJzldrzytc(@Valid @RequestBody JzldrzytcSaveReqVO updateReqVO) {
        jzldrzytcService.updateJzldrzytc(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除专业特长数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrzytc:delete')")
    public CommonResult<Boolean> deleteJzldrzytc(@RequestParam("id") String id) {
        jzldrzytcService.deleteJzldrzytc(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得专业特长数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrzytc:query')")
    public CommonResult<JzldrzytcRespVO> getJzldrzytc(@RequestParam("id") String id) {
        JzldrzytcDO jzldrzytc = jzldrzytcService.getJzldrzytc(id);
        return success(BeanUtils.toBean(jzldrzytc, JzldrzytcRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得专业特长数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrzytc:query')")
    public CommonResult<PageResult<JzldrzytcRespVO>> getJzldrzytcPage(@Valid JzldrzytcPageReqVO pageReqVO) {
        PageResult<JzldrzytcDO> pageResult = jzldrzytcService.getJzldrzytcPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrzytcRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出专业特长数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrzytc:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrzytcExcel(@Valid JzldrzytcPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrzytcDO> list = jzldrzytcService.getJzldrzytcPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "专业特长数据.xls", "数据", JzldrzytcRespVO.class,
                        BeanUtils.toBean(list, JzldrzytcRespVO.class));
    }

}