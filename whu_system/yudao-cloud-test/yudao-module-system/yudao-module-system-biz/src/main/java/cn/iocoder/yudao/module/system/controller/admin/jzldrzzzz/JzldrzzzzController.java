package cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzzzz.JzldrzzzzDO;
import cn.iocoder.yudao.module.system.service.jzldrzzzz.JzldrzzzzService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 政治主张数据")
@RestController
@RequestMapping("/system/jzldrzzzz")
@Validated
public class JzldrzzzzController {

    @Resource
    private JzldrzzzzService jzldrzzzzService;

    @PostMapping("/create")
    @Operation(summary = "创建政治主张数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrzzzz:create')")
    public CommonResult<String> createJzldrzzzz(@Valid @RequestBody JzldrzzzzSaveReqVO createReqVO) {
        return success(jzldrzzzzService.createJzldrzzzz(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新政治主张数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrzzzz:update')")
    public CommonResult<Boolean> updateJzldrzzzz(@Valid @RequestBody JzldrzzzzSaveReqVO updateReqVO) {
        jzldrzzzzService.updateJzldrzzzz(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除政治主张数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrzzzz:delete')")
    public CommonResult<Boolean> deleteJzldrzzzz(@RequestParam("id") String id) {
        jzldrzzzzService.deleteJzldrzzzz(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得政治主张数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrzzzz:query')")
    public CommonResult<JzldrzzzzRespVO> getJzldrzzzz(@RequestParam("id") String id) {
        JzldrzzzzDO jzldrzzzz = jzldrzzzzService.getJzldrzzzz(id);
        return success(BeanUtils.toBean(jzldrzzzz, JzldrzzzzRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得政治主张数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrzzzz:query')")
    public CommonResult<PageResult<JzldrzzzzRespVO>> getJzldrzzzzPage(@Valid JzldrzzzzPageReqVO pageReqVO) {
        PageResult<JzldrzzzzDO> pageResult = jzldrzzzzService.getJzldrzzzzPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrzzzzRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出政治主张数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrzzzz:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrzzzzExcel(@Valid JzldrzzzzPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrzzzzDO> list = jzldrzzzzService.getJzldrzzzzPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "政治主张数据.xls", "数据", JzldrzzzzRespVO.class,
                        BeanUtils.toBean(list, JzldrzzzzRespVO.class));
    }

}