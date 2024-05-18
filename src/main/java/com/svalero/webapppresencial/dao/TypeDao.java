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

    @SqlQuery("SELECT * FROM type WHERE id_type = ?")
    @UseRowMapper(TypeMapper.class)
    Type getType (Integer id);

    @SqlUpdate("INSERT INTO type (name, description) VALUES (?,?)")
    Integer addType(String name, String description);

    @SqlUpdate("DELETE FROM type WHERE id_type = ?")
    Integer removeType(Integer idType);

}
