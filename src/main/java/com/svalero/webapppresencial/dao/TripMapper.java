package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new User(rs.getInt("id_trip"),
                rs.getString("name"),
                rs.getString("notes"),
                rs.getString("start_date"),
                rs.getString("end_date"),
                rs.getString("id_type"),
                rs.getString("id_user"),
                rs.getString("id_destination"));
    }
}
