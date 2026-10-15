package cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrdpbj.JzldrdpbjDO;
import cn.iocoder.yudao.module.system.service.jzldrdpbj.JzldrdpbjService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 党派背景数据")
@RestController
@RequestMapping("/system/jzldrdpbj")
@Validated
public class JzldrdpbjController {

    @Resource
    private JzldrdpbjService jzldrdpbjService;

    @PostMapping("/create")
    @Operation(summary = "创建党派背景数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrdpbj:create')")
    public CommonResult<String> createJzldrdpbj(@Valid @RequestBody JzldrdpbjSaveReqVO createReqVO) {
        return success(jzldrdpbjService.createJzldrdpbj(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新党派背景数据")
    @PreAuthorize("@ss.hasPermission('system:jzldrdpbj:update')")
    public CommonResult<Boolean> updateJzldrdpbj(@Valid @RequestBody JzldrdpbjSaveReqVO updateReqVO) {
        jzldrdpbjService.updateJzldrdpbj(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除党派背景数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrdpbj:delete')")
    public CommonResult<Boolean> deleteJzldrdpbj(@RequestParam("id") String id) {
        jzldrdpbjService.deleteJzldrdpbj(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得党派背景数据")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrdpbj:query')")
    public CommonResult<JzldrdpbjRespVO> getJzldrdpbj(@RequestParam("id") String id) {
        JzldrdpbjDO jzldrdpbj = jzldrdpbjService.getJzldrdpbj(id);
        return success(BeanUtils.toBean(jzldrdpbj, JzldrdpbjRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得党派背景数据分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrdpbj:query')")
    public CommonResult<PageResult<JzldrdpbjRespVO>> getJzldrdpbjPage(@Valid JzldrdpbjPageReqVO pageReqVO) {
        PageResult<JzldrdpbjDO> pageResult = jzldrdpbjService.getJzldrdpbjPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrdpbjRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出党派背景数据 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrdpbj:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrdpbjExcel(@Valid JzldrdpbjPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrdpbjDO> list = jzldrdpbjService.getJzldrdpbjPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "党派背景数据.xls", "数据", JzldrdpbjRespVO.class,
                        BeanUtils.toBean(list, JzldrdpbjRespVO.class));
    }

}