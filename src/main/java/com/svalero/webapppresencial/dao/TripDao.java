package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.Trip;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.Date;
import java.util.List;

public interface TripDao {

    @SqlQuery("SELECT * FROM trip")
    @UseRowMapper(TripMapper.class)
    List<Trip> getAllTrips();

    @SqlQuery("SELECT * FROM trip WHERE id_trip = ?")
    @UseRowMapper(TripMapper.class)
    Trip getTrip(String idTrip);

    @SqlUpdate("INSERT INTO trip (name, surname, email, address, country, mobile) VALUES (?,?,?,?,?,?)")
    Integer addTrip(String name, String notes, Date start_date, Date end_date, Integer id_type, Integer id_user, Integer id_destination);

    @SqlUpdate("DELETE FROM trip WHERE id_trip = ?")
    Integer removeTrip(Integer idTrip);
}
