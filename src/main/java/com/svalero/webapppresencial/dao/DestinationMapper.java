package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.Destination;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DestinationMapper implements RowMapper<Destination> {

    @Override
    public Destination map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Destination(rs.getInt("id_destination"),
                rs.getString("city"),
                rs.getString("country"),
                rs.getString("description"));
    }
}
