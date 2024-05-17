package com.svalero.webapppresencial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    private Integer idType;
    private String name;
    private String description;

}
