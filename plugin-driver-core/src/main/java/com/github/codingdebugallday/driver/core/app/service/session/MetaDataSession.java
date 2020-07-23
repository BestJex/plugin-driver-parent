package com.github.codingdebugallday.driver.core.app.service.session;
package com.github.codingdebugallday.driver.session.app.service.session;


import com.github.codingdebugallday.driver.common.infra.exceptions.DriverException;
import com.github.codingdebugallday.driver.session.infra.meta.Column;
import com.github.codingdebugallday.driver.session.infra.meta.Table;

import java.util.List;

import com.github.codingdebugallday.driver.core.domain.entity.MetaDataInfo;

/**
 * <p>
 * 元数据session
 * </p>
 *
 * @author JupiterMouse 2020/07/08
 * @since 1.0.0
 */
public interface MetaDataSession {

    /**
     * 适用RDB
     * 查询列元数据
     *
     * @param schema    schema
     * @param tableName 表名
     * @return List<Column>
     */
    default List<Column> columnMetaData(String schema, String tableName) {
        throw new DriverException("Not Supported");
    }

    /**
     * 适用RDB
     * 表表元数据
     *
     * @param schema    schema
     * @param tableName tableName
     * @return Table
     */
    default Table tableMetaData(String schema, String tableName) {
        throw new DriverException("Not Supported");
    }

}
