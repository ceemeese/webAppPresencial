package com.svalero.webapppresencial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {

    private Integer idDestination;
    private String city;
    private String country;
    private String description;
}
