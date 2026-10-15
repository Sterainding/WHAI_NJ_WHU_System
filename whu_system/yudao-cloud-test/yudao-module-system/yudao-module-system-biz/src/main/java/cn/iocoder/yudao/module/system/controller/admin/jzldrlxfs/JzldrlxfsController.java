package cn.iocoder.yudao.module.system.controller.admin.jzldrlxfs;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrlxfs.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrlxfs.JzldrlxfsDO;
import cn.iocoder.yudao.module.system.service.jzldrlxfs.JzldrlxfsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 联系方式数据")
@RestController
@RequestMapping("/system/jzldrlxfs")
@Validated
public class JzldrlxfsController {

    @Resource
    private JzldrlxfsService jzldrlxfsService;

    @PostMapping("/create")
    @Operation(summary = "创建联系方式数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrlxfs:create')")
    public CommonResult<String> createJzldrlxfs(@Valid @RequestBody JzldrlxfsSaveReqVO createReqVO) {
        return success(jzldrlxfsService.createJzldrlxfs(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新联系方式数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrlxfs:update')")
    public CommonResult<Boolean> updateJzldrlxfs(@Valid @RequestBody JzldrlxfsSaveReqVO updateReqVO) {
        jzldrlxfsService.updateJzldrlxfs(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除联系方式数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrlxfs:delete')")
    public CommonResult<Boolean> deleteJzldrlxfs(@RequestParam("id") String id) {
        jzldrlxfsService.deleteJzldrlxfs(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得联系方式数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrlxfs:query')")
    public CommonResult<JzldrlxfsRespVO> getJzldrlxfs(@RequestParam("id") String id) {
        JzldrlxfsDO jzldrlxfs = jzldrlxfsService.getJzldrlxfs(id);
        return success(BeanUtils.toBean(jzldrlxfs, JzldrlxfsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得联系方式数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrlxfs:query')")
    public CommonResult<PageResult<JzldrlxfsRespVO>> getJzldrlxfsPage(@Valid JzldrlxfsPageReqVO pageReqVO) {
        PageResult<JzldrlxfsDO> pageResult = jzldrlxfsService.getJzldrlxfsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrlxfsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出联系方式数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrlxfs:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrlxfsExcel(@Valid JzldrlxfsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrlxfsDO> list = jzldrlxfsService.getJzldrlxfsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "联系方式数据.xls", "数据", JzldrlxfsRespVO.class,
                        BeanUtils.toBean(list, JzldrlxfsRespVO.class));
    }

}