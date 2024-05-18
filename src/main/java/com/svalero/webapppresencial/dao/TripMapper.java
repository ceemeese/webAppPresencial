package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.Destination;
import com.svalero.webapppresencial.domain.Trip;
import com.svalero.webapppresencial.domain.Type;
import com.svalero.webapppresencial.domain.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripMapper implements RowMapper<Trip> {

    @Override
    public Trip map(ResultSet rs, StatementContext ctx) throws SQLException {

        Type type = Database.jdbi.withExtension(TypeDao.class, dao-> dao.getType(rs.getInt("id_type")));
        User user = Database.jdbi.withExtension(UserDao.class, dao-> dao.getUser(rs.getInt("id_user")));
        Destination destination = Database.jdbi.withExtension(DestinationDao.class, dao-> dao.getDestination(rs.getInt("id_destination")));

        return new Trip(rs.getInt("id_trip"),
                rs.getString("name"),
                rs.getString("notes"),
                rs.getDate("start_date"),
                rs.getDate("end_date"),
                type,
                user,
                destination,
                rs.getInt("number_traveller"));

    }
}
