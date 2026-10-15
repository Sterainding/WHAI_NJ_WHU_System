package cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrwdxw.JzldrwdxwDO;
import cn.iocoder.yudao.module.system.service.jzldrwdxw.JzldrwdxwService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 污点新闻数据")
@RestController
@RequestMapping("/system/jzldrwdxw")
@Validated
public class JzldrwdxwController {

    @Resource
    private JzldrwdxwService jzldrwdxwService;

    @PostMapping("/create")
    @Operation(summary = "创建污点新闻数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrwdxw:create')")
    public CommonResult<String> createJzldrwdxw(@Valid @RequestBody JzldrwdxwSaveReqVO createReqVO) {
        return success(jzldrwdxwService.createJzldrwdxw(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新污点新闻数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrwdxw:update')")
    public CommonResult<Boolean> updateJzldrwdxw(@Valid @RequestBody JzldrwdxwSaveReqVO updateReqVO) {
        jzldrwdxwService.updateJzldrwdxw(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除污点新闻数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrwdxw:delete')")
    public CommonResult<Boolean> deleteJzldrwdxw(@RequestParam("id") String id) {
        jzldrwdxwService.deleteJzldrwdxw(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得污点新闻数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrwdxw:query')")
    public CommonResult<JzldrwdxwRespVO> getJzldrwdxw(@RequestParam("id") String id) {
        JzldrwdxwDO jzldrwdxw = jzldrwdxwService.getJzldrwdxw(id);
        return success(BeanUtils.toBean(jzldrwdxw, JzldrwdxwRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得污点新闻数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrwdxw:query')")
    public CommonResult<PageResult<JzldrwdxwRespVO>> getJzldrwdxwPage(@Valid JzldrwdxwPageReqVO pageReqVO) {
        PageResult<JzldrwdxwDO> pageResult = jzldrwdxwService.getJzldrwdxwPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrwdxwRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出污点新闻数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrwdxw:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrwdxwExcel(@Valid JzldrwdxwPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrwdxwDO> list = jzldrwdxwService.getJzldrwdxwPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "污点新闻数据.xls", "数据", JzldrwdxwRespVO.class,
                        BeanUtils.toBean(list, JzldrwdxwRespVO.class));
    }

}