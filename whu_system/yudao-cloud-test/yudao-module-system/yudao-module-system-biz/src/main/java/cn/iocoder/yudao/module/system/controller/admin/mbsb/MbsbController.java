package cn.iocoder.yudao.module.system.controller.admin.mbsb;

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

import cn.iocoder.yudao.module.system.controller.admin.mbsb.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.mbsb.MbsbDO;
import cn.iocoder.yudao.module.system.service.mbsb.MbsbService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Tag(name = "管理后台 - 红外目标识别数据")
@RestController
@RequestMapping("/system/mbsb")
@Validated
public class MbsbController {

    @Resource
    private MbsbService mbsbService;

    @PostMapping("/create")
    @Operation(summary = "创建红外目标识别数据")
    @PreAuthorize("@ss.hasPermission('system:mbsb:create')")
    public CommonResult<String> createMbsb(@Valid @RequestBody MbsbSaveReqVO createReqVO) {
        return success(mbsbService.createMbsb(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新红外目标识别数据")
    @PreAuthorize("@ss.hasPermission('system:mbsb:update')")
    public CommonResult<Boolean> updateMbsb(@Valid @RequestBody MbsbSaveReqVO updateReqVO) {
        mbsbService.updateMbsb(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除红外目标识别数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:mbsb:delete')")
    public CommonResult<Boolean> deleteMbsb(@RequestParam("id") String id) {
        mbsbService.deleteMbsb(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得红外目标识别数据")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:mbsb:query')")
    public CommonResult<MbsbRespVO> getMbsb(@RequestParam("id") String id) {
        MbsbDO mbsb = mbsbService.getMbsb(id);
        return success(BeanUtils.toBean(mbsb, MbsbRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得红外目标识别数据分页")
    @PreAuthorize("@ss.hasPermission('system:mbsb:query')")
    public CommonResult<PageResult<MbsbRespVO>> getMbsbPage(@Valid MbsbPageReqVO pageReqVO) {
        PageResult<MbsbDO> pageResult = mbsbService.getMbsbPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MbsbRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出红外目标识别数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:mbsb:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportMbsbExcel(@Valid MbsbPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MbsbDO> list = mbsbService.getMbsbPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "红外目标识别数据.xls", "数据", MbsbRespVO.class,
                        BeanUtils.toBean(list, MbsbRespVO.class));
    }

}