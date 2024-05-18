package com.svalero.webapppresencial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer idUser;
    private String NIF;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String country;
    private String mobile;
}
