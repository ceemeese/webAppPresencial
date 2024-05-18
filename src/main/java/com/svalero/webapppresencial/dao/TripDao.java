package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.Trip;
import com.svalero.webapppresencial.domain.User;
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
    Trip getTrip(Integer id);

    @SqlUpdate("INSERT INTO trip (name, notes, id_type, id_destination, number_traveller) VALUES (?,?,?,?,?)")
    Integer addTrip(String name, String notes, Integer id_type, Integer id_user, Integer id_destination, Integer number_traveller);

    @SqlUpdate("DELETE FROM trip WHERE id_trip = ?")
    Integer removeTrip(Integer idTrip);

    @SqlUpdate("UPDATE trip SET name = ?, notes = ?, id_type = ?, id_destination = ?, number_traveller = ? WHERE id_trip = ?")
    int updateTrip(String name, String notes, Integer id_type, Integer id_user, Integer id_destination, Integer number_traveller, int id_trip);
}
