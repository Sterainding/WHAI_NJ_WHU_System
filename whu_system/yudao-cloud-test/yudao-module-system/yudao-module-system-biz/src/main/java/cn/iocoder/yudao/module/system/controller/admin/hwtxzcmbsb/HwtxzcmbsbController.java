package cn.iocoder.yudao.module.system.controller.admin.hwtxzcmbsb;

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

import cn.iocoder.yudao.module.system.controller.admin.hwtxzcmbsb.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcmbsb.HwtxzcmbsbDO;
import cn.iocoder.yudao.module.system.service.hwtxzcmbsb.HwtxzcmbsbService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Tag(name = "管理后台 - 红外目标识别数据")
@RestController
@RequestMapping("/system/hwtxzcmbsb")
@Validated
public class HwtxzcmbsbController {

    @Resource
    private HwtxzcmbsbService hwtxzcmbsbService;

    @PostMapping("/create")
    @Operation(summary = "创建红外目标识别数据")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcmbsb:create')")
    public CommonResult<String> createHwtxzcmbsb(@Valid @RequestBody HwtxzcmbsbSaveReqVO createReqVO) {
        return success(hwtxzcmbsbService.createHwtxzcmbsb(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新红外目标识别数据")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcmbsb:update')")
    public CommonResult<Boolean> updateHwtxzcmbsb(@Valid @RequestBody HwtxzcmbsbSaveReqVO updateReqVO) {
        hwtxzcmbsbService.updateHwtxzcmbsb(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除红外目标识别数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:hwtxzcmbsb:delete')")
    public CommonResult<Boolean> deleteHwtxzcmbsb(@RequestParam("id") String id) {
        hwtxzcmbsbService.deleteHwtxzcmbsb(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得红外目标识别数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcmbsb:query')")
    public CommonResult<HwtxzcmbsbRespVO> getHwtxzcmbsb(@RequestParam("id") String id) {
        HwtxzcmbsbDO hwtxzcmbsb = hwtxzcmbsbService.getHwtxzcmbsb(id);
        return success(BeanUtils.toBean(hwtxzcmbsb, HwtxzcmbsbRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得红外目标识别数据分页")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcmbsb:query')")
    public CommonResult<PageResult<HwtxzcmbsbRespVO>> getHwtxzcmbsbPage(@Valid HwtxzcmbsbPageReqVO pageReqVO) {
        PageResult<HwtxzcmbsbDO> pageResult = hwtxzcmbsbService.getHwtxzcmbsbPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, HwtxzcmbsbRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出红外目标识别数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:hwtxzcmbsb:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportHwtxzcmbsbExcel(@Valid HwtxzcmbsbPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<HwtxzcmbsbDO> list = hwtxzcmbsbService.getHwtxzcmbsbPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "红外目标识别数据.xls", "数据", HwtxzcmbsbRespVO.class,
                        BeanUtils.toBean(list, HwtxzcmbsbRespVO.class));
    }

}