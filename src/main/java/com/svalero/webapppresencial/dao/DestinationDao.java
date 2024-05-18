package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.Destination;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface DestinationDao {

    @SqlQuery("SELECT * FROM destination")
    @UseRowMapper(DestinationMapper.class)
    List<Destination> getAllDestinations();

    @SqlQuery("SELECT * FROM destination WHERE id_destination = ?")
    @UseRowMapper(DestinationMapper.class)
    Destination getDestination(Integer id);

    @SqlUpdate("INSERT INTO destination (city, country, description) VALUES (?,?,?)")
    Integer addDestination(String city, String country, String description);

    @SqlUpdate("UPDATE destination SET city = ?, country = ?, description = ? WHERE id_destination = ?")
    int updateDestination(String city, String country, String description, int id_destination);

    @SqlUpdate("DELETE FROM destination WHERE id_destination = ?")
    Integer removeDestination(Integer idDestination);
}
