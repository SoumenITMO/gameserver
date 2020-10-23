package com.gameserver.DBConfig;

import org.hibernate.dialect.Dialect;
import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public void SQLDialect() {
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BLOB, "text");
        registerColumnType(Types.REAL, "float");
    }
}
