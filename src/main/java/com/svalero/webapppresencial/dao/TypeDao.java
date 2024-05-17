package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.Type;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface TypeDao {

    @SqlQuery("SELECT * FROM type")
    @UseRowMapper(TypeMapper.class)
    List<Type> getAllTypes();

    @SqlQuery("SELECT * FROM type WHERE name = ?")
    @UseRowMapper(TypeMapper.class)
    Type getIdType(String name);

    @SqlUpdate("INSERT INTO type (name, description) VALUES (?,?)")
    int addType(String name, String description);

    @SqlUpdate("DELETE FROM type WHERE id_type = ?")
    int removeType(int idType);
}
