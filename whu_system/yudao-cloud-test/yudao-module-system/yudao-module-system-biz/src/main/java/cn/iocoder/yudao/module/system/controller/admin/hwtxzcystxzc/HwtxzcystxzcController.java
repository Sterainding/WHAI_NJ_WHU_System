package cn.iocoder.yudao.module.system.controller.admin.hwtxzcystxzc;

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

import cn.iocoder.yudao.module.system.controller.admin.hwtxzcystxzc.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcystxzc.HwtxzcystxzcDO;
import cn.iocoder.yudao.module.system.service.hwtxzcystxzc.HwtxzcystxzcService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Tag(name = "管理后台 - 红外原始图像侦察数据")
@RestController
@RequestMapping("/system/hwtxzcystxzc")
@Validated
public class HwtxzcystxzcController {

    @Resource
    private HwtxzcystxzcService hwtxzcystxzcService;

    @PostMapping("/create")
    @Operation(summary = "创建红外原始图像侦察数据")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcystxzc:create')")
    public CommonResult<String> createHwtxzcystxzc(@Valid @RequestBody HwtxzcystxzcSaveReqVO createReqVO) {
        return success(hwtxzcystxzcService.createHwtxzcystxzc(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新红外原始图像侦察数据")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcystxzc:update')")
    public CommonResult<Boolean> updateHwtxzcystxzc(@Valid @RequestBody HwtxzcystxzcSaveReqVO updateReqVO) {
        hwtxzcystxzcService.updateHwtxzcystxzc(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除红外原始图像侦察数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:hwtxzcystxzc:delete')")
    public CommonResult<Boolean> deleteHwtxzcystxzc(@RequestParam("id") String id) {
        hwtxzcystxzcService.deleteHwtxzcystxzc(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得红外原始图像侦察数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcystxzc:query')")
    public CommonResult<HwtxzcystxzcRespVO> getHwtxzcystxzc(@RequestParam("id") String id) {
        HwtxzcystxzcDO hwtxzcystxzc = hwtxzcystxzcService.getHwtxzcystxzc(id);
        return success(BeanUtils.toBean(hwtxzcystxzc, HwtxzcystxzcRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得红外原始图像侦察数据分页")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcystxzc:query')")
    public CommonResult<PageResult<HwtxzcystxzcRespVO>> getHwtxzcystxzcPage(@Valid HwtxzcystxzcPageReqVO pageReqVO) {
        PageResult<HwtxzcystxzcDO> pageResult = hwtxzcystxzcService.getHwtxzcystxzcPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, HwtxzcystxzcRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出红外原始图像侦察数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcystxzc:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportHwtxzcystxzcExcel(@Valid HwtxzcystxzcPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<HwtxzcystxzcDO> list = hwtxzcystxzcService.getHwtxzcystxzcPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "红外原始图像侦察数据.xls", "数据", HwtxzcystxzcRespVO.class,
                        BeanUtils.toBean(list, HwtxzcystxzcRespVO.class));
    }

}