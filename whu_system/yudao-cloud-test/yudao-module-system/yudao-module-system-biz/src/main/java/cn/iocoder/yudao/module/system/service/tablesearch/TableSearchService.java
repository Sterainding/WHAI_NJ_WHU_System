package cn.iocoder.yudao.module.system.service.tablesearch;

import cn.iocoder.yudao.module.system.controller.admin.tablesearch.*;
import java.util.Map;
import java.util.List;

public interface TableSearchService {

    Map<String, List<Map<String, Object>>> searchColumnInTables(String dbName, String columnName, String searchValue);

}