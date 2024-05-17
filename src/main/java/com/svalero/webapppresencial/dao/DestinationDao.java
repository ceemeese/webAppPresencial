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

    @SqlQuery("SELECT * FROM destination WHERE country = ?")
    @UseRowMapper(DestinationMapper.class)
    Destination getIdDestination(String country);

    @SqlUpdate("INSERT INTO destination (city, country, description) VALUES (?,?,?)")
    int addDestination(String city, String country, String description);

    @SqlUpdate("DELETE FROM destination WHERE id_destination = ?")
    int removeDestination(int idDestination);
}
