package cn.iocoder.yudao.module.system.controller.admin.jzldrrwbd;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrrwbd.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwbd.JzldrrwbdDO;
import cn.iocoder.yudao.module.system.service.jzldrrwbd.JzldrrwbdService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 人物报道数据")
@RestController
@RequestMapping("/system/jzldrrwbd")
@Validated
public class JzldrrwbdController {

    @Resource
    private JzldrrwbdService jzldrrwbdService;

    @PostMapping("/create")
    @Operation(summary = "创建人物报道数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwbd:create')")
    public CommonResult<String> createJzldrrwbd(@Valid @RequestBody JzldrrwbdSaveReqVO createReqVO) {
        return success(jzldrrwbdService.createJzldrrwbd(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新人物报道数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwbd:update')")
    public CommonResult<Boolean> updateJzldrrwbd(@Valid @RequestBody JzldrrwbdSaveReqVO updateReqVO) {
        jzldrrwbdService.updateJzldrrwbd(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除人物报道数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrrwbd:delete')")
    public CommonResult<Boolean> deleteJzldrrwbd(@RequestParam("id") String id) {
        jzldrrwbdService.deleteJzldrrwbd(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得人物报道数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwbd:query')")
    public CommonResult<JzldrrwbdRespVO> getJzldrrwbd(@RequestParam("id") String id) {
        JzldrrwbdDO jzldrrwbd = jzldrrwbdService.getJzldrrwbd(id);
        return success(BeanUtils.toBean(jzldrrwbd, JzldrrwbdRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得人物报道数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwbd:query')")
    public CommonResult<PageResult<JzldrrwbdRespVO>> getJzldrrwbdPage(@Valid JzldrrwbdPageReqVO pageReqVO) {
        PageResult<JzldrrwbdDO> pageResult = jzldrrwbdService.getJzldrrwbdPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrrwbdRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出人物报道数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwbd:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrrwbdExcel(@Valid JzldrrwbdPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrrwbdDO> list = jzldrrwbdService.getJzldrrwbdPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "人物报道数据.xls", "数据", JzldrrwbdRespVO.class,
                        BeanUtils.toBean(list, JzldrrwbdRespVO.class));
    }

}