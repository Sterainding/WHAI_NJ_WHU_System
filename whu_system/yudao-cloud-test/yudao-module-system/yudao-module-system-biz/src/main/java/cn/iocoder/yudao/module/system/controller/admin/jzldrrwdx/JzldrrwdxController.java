package cn.iocoder.yudao.module.system.controller.admin.jzldrrwdx;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrrwdx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwdx.JzldrrwdxDO;
import cn.iocoder.yudao.module.system.service.jzldrrwdx.JzldrrwdxService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 人物动向数据")
@RestController
@RequestMapping("/system/jzldrrwdx")
@Validated
public class JzldrrwdxController {

    @Resource
    private JzldrrwdxService jzldrrwdxService;

    @PostMapping("/create")
    @Operation(summary = "创建人物动向数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwdx:create')")
    public CommonResult<String> createJzldrrwdx(@Valid @RequestBody JzldrrwdxSaveReqVO createReqVO) {
        return success(jzldrrwdxService.createJzldrrwdx(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新人物动向数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwdx:update')")
    public CommonResult<Boolean> updateJzldrrwdx(@Valid @RequestBody JzldrrwdxSaveReqVO updateReqVO) {
        jzldrrwdxService.updateJzldrrwdx(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除人物动向数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrrwdx:delete')")
    public CommonResult<Boolean> deleteJzldrrwdx(@RequestParam("id") String id) {
        jzldrrwdxService.deleteJzldrrwdx(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得人物动向数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwdx:query')")
    public CommonResult<JzldrrwdxRespVO> getJzldrrwdx(@RequestParam("id") String id) {
        JzldrrwdxDO jzldrrwdx = jzldrrwdxService.getJzldrrwdx(id);
        return success(BeanUtils.toBean(jzldrrwdx, JzldrrwdxRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得人物动向数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwdx:query')")
    public CommonResult<PageResult<JzldrrwdxRespVO>> getJzldrrwdxPage(@Valid JzldrrwdxPageReqVO pageReqVO) {
        PageResult<JzldrrwdxDO> pageResult = jzldrrwdxService.getJzldrrwdxPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrrwdxRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出人物动向数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwdx:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrrwdxExcel(@Valid JzldrrwdxPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrrwdxDO> list = jzldrrwdxService.getJzldrrwdxPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "人物动向数据.xls", "数据", JzldrrwdxRespVO.class,
                        BeanUtils.toBean(list, JzldrrwdxRespVO.class));
    }

}