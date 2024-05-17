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

    @SqlQuery("SELECT * FROM user WHERE email = ?")
    @UseRowMapper(UserMapper.class)
    User getNIF(String email);

    @SqlUpdate("INSERT INTO user (NIF, name, surname, email, address, country, mobile) VALUES (?,?,?,?,?,?,?)")
    int addUser(String NIF, String name, String surname, String email, String address, String country, String mobile);

    @SqlUpdate("DELETE FROM user WHERE id_user = ?")
    int removeUser(int id_user);
}
