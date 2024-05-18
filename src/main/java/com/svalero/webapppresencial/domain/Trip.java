package com.svalero.webapppresencial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    private Integer idTrip;
    private String name;
    private String notes;
    private Date startDate;
    private Date endDate;
    private Type idType;
    private User idUser;
    private Destination idDestination;
    private Integer numberTraveller;

}
