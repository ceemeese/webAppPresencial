package com.svalero.webapppresencial.dao;

import com.svalero.webapppresencial.domain.User;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.Date;
import java.util.List;

public interface UserDao {

    @SqlQuery("SELECT * FROM user")
    @UseRowMapper(UserMapper.class)
    List<User> getAllUsers();

    @SqlQuery("SELECT * FROM user WHERE id_user = ?")
    @UseRowMapper(UserMapper.class)
    User getUser(Integer id);

    @SqlUpdate("INSERT INTO user (NIF, name, surname, email, address, country, mobile) VALUES (?,?,?,?,?,?,?)")
    Integer addUser(String NIF, String name, String surname, String email, String address, String country, String mobile);

    @SqlUpdate("DELETE FROM user WHERE id_user = ?")
    Integer removeUser(Integer idUser);
}
