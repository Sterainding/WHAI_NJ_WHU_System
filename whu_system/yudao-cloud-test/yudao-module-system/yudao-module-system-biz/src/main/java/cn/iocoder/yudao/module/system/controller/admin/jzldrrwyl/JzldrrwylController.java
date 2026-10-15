package cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl;

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

import cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwyl.JzldrrwylDO;
import cn.iocoder.yudao.module.system.service.jzldrrwyl.JzldrrwylService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Tag(name = "管理后台 - 人物言论")
@RestController
@RequestMapping("/system/jzldrrwyl")
@Validated
public class JzldrrwylController {

    @Resource
    private JzldrrwylService jzldrrwylService;

    @PostMapping("/create")
    @Operation(summary = "创建人物言论")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwyl:create')")
    public CommonResult<String> createJzldrrwyl(@Valid @RequestBody JzldrrwylSaveReqVO createReqVO) {
        return success(jzldrrwylService.createJzldrrwyl(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新人物言论")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwyl:update')")
    public CommonResult<Boolean> updateJzldrrwyl(@Valid @RequestBody JzldrrwylSaveReqVO updateReqVO) {
        jzldrrwylService.updateJzldrrwyl(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除人物言论")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:jzldrrwyl:delete')")
    public CommonResult<Boolean> deleteJzldrrwyl(@RequestParam("id") String id) {
        jzldrrwylService.deleteJzldrrwyl(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得人物言论")
    @Parameter(name = "id", description = "编号", required = true, example = "demo")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwyl:query')")
    public CommonResult<JzldrrwylRespVO> getJzldrrwyl(@RequestParam("id") String id) {
        JzldrrwylDO jzldrrwyl = jzldrrwylService.getJzldrrwyl(id);
        return success(BeanUtils.toBean(jzldrrwyl, JzldrrwylRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得人物言论分页")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwyl:query')")
    public CommonResult<PageResult<JzldrrwylRespVO>> getJzldrrwylPage(@Valid JzldrrwylPageReqVO pageReqVO) {
        PageResult<JzldrrwylDO> pageResult = jzldrrwylService.getJzldrrwylPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, JzldrrwylRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出人物言论 Excel")
    @PreAuthorize("@ss.hasPermission('system:jzldrrwyl:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJzldrrwylExcel(@Valid JzldrrwylPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JzldrrwylDO> list = jzldrrwylService.getJzldrrwylPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "人物言论.xls", "数据", JzldrrwylRespVO.class,
                        BeanUtils.toBean(list, JzldrrwylRespVO.class));
    }

}