package com.github.codingdebugallday.driver.session.mysql;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.github.codingdebugallday.driver.session.app.service.session.DriverSessionFunction;
import com.github.codingdebugallday.driver.session.domian.entity.TableColumn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * <p>
 * 主程序定义SessionService接口的实现类
 * </p>
 *
 * @author isaac 2020/6/16 17:54
 * @since 1.0
 */
@SuppressWarnings("unused")
@Slf4j
@Component("mysqlDriverSession")
public class MysqlDriverSession implements DriverSessionFunction<DataSource> {

    private MysqlSchemaSession mysqlSchemaSession;
    private MysqlTableSession mysqlTableSession;

    @Override
    public Class<DataSource> getDataSource() {
        return DataSource.class;
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        mysqlSchemaSession = new MysqlSchemaSession(dataSource);
        mysqlTableSession = new MysqlTableSession(dataSource);
    }

    //============================================
    //====================schema==================
    //============================================

    @Override
    public boolean createSchema(String schema) {
        return mysqlSchemaSession.createSchema(schema);
    }

    @Override
    public List<String> schemas() {
        return mysqlSchemaSession.schemas();
    }

    @Override
    public boolean executeStatement(String schema, String sql) {
        return mysqlSchemaSession.executeStatement(schema, sql);
    }

    @Override
    public int[] executeStatement(String schema, List<String> sql) {
        return mysqlSchemaSession.executeStatement(schema, sql);
    }

    @Override
    public List<Map<String, Object>> queryStatement(String schema, String sql) {
        return mysqlSchemaSession.queryStatement(schema, sql);
    }

    @Override
    public List<Map<String, Object>> callProcedure(String schema, String sql, Object... args) {
        return mysqlSchemaSession.callProcedure(schema, sql, args);
    }

    //============================================
    //====================table==================
    //============================================

    @Override
    public List<String> tables(String schema) {
        return mysqlTableSession.tables(schema);
    }

    @Override
    public List<Map<String, Object>> tableStructure(String schema, String table) {
        return mysqlTableSession.tableStructure(schema, table);
    }

    @Override
    public List<Map<String, Object>> tablePk(String schema, String table) {
        return mysqlTableSession.tablePk(schema, table);
    }

    @Override
    public List<Map<String, Object>> tableIndex(String schema, String table) {
        return mysqlTableSession.tableIndex(schema, table);
    }

    @Override
    public List<TableColumn> columns(String schema, String sql) {
        return mysqlTableSession.columns(schema, sql);
    }

    @Override
    public Long count(String schema, String sql) {
        return mysqlTableSession.count(schema, sql);
    }

    @Override
    public boolean exists(String schema, String table) {
        return mysqlTableSession.exists(schema, table);
    }

    @Override
    public List<String> views(String schema) {
        return mysqlTableSession.views(schema);
    }
}
