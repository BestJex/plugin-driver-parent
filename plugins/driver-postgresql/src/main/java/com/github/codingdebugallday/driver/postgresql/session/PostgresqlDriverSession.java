package com.github.codingdebugallday.driver.postgresql.session;

import com.github.codingdebugallday.driver.core.app.service.session.rdbms.AbstractRdbmsDriverSession;

import javax.sql.DataSource;

/**
 * <p>
 * description
 * </p>
 *
 * @author JupiterMouse 2020/07/10
 * @since 1.0.0
 */
public class PostgresqlDriverSession extends AbstractRdbmsDriverSession {

    public PostgresqlDriverSession(DataSource dataSource) {
        super(dataSource);
    }

}