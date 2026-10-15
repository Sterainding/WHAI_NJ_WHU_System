package cn.iocoder.yudao.module.system.controller.admin.tablesearch;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.service.tablesearch.TableSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/system/table-search")
public class TableSearchController {

    @Resource
    private TableSearchService tableSearchService;

    @GetMapping("/search")
    @Operation(summary = "跨表字段搜索")
    @Parameter(name = "dbName", description = "数据库名", required = true, example = "whai_demo")
    @Parameter(name = "columnName", description = "字段名", required = true, example = "name")
    @Parameter(name = "searchValue", description = "搜索值", required = true, example = "示例人物")
    @PreAuthorize("@ss.hasPermission('system:table-search:query')")
    public CommonResult<Map<String, List<Map<String, Object>>>> search(
            @RequestParam String dbName,
            @RequestParam String columnName,
            @RequestParam String searchValue) {

        return success(tableSearchService.searchColumnInTables(dbName, columnName, searchValue));
    }
}