package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.Type;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeMapper implements RowMapper<Type> {

    @Override
    public Type map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Type(rs.getInt("id_type"),
                rs.getString("name"),
                rs.getString("description"));
    }
}
