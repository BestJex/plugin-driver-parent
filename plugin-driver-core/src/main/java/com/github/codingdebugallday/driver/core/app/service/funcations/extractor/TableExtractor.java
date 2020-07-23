package com.github.codingdebugallday.driver.core.app.service.funcations.extractor;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>
 * 表提取器
 * </p>
 *
 * @author JupiterMouse 2020/07/08
 * @since 1.0.0
 */
public interface TableExtractor {

    /**
     * 表提取
     *
     * @param metaData     元数据
     * @param schema       数据库schema
     * @param tablePattern 表匹配
     * @param types        元数据类型
     * @return 结果集
     * @throws SQLException sql异常
     */
    ResultSet extract(DatabaseMetaData metaData, String schema, String tablePattern, String[] types) throws SQLException;

}
