package cn.iocoder.yudao.module.system.controller.admin.tablesearch;

import cn.iocoder.yudao.module.system.service.tablesearch.TableSearchService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

@RestController
@RequestMapping("/system/test/table-search")
public class TableSearchTestController {

    @Resource
    private TableSearchService tableSearchService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @Operation(summary = "测试表搜索功能")
    @GetMapping("/test")
    public Map<String, Object> testSearch(
            @RequestParam(defaultValue = "whai_demo") String dbName,
            @RequestParam(defaultValue = "name") String columnName,
            @RequestParam(defaultValue = "示例人物") String searchValue) {

        // 执行搜索
        Map<String, List<Map<String, Object>>> result =
                tableSearchService.searchColumnInTables(dbName, columnName, searchValue);

        // 打印到控制台
        System.out.println("===== 表搜索测试结果 =====");
        result.forEach((table, rows) -> {
            System.out.println("\n表名: " + table);
            rows.forEach(row -> {
                row.forEach((key, value) -> System.out.println("  " + key + ": " + value));
                System.out.println("  ------");
            });
        });
        System.out.println("=======================");

        // 返回结果（可选）
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", "测试执行成功");
        response.put("data", result);
        return response;
    }
}

