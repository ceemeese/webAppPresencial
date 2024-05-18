package com.svalero.webapppresencial.domain;

import com.svalero.webapppresencial.dao.Database;
import com.svalero.webapppresencial.dao.DestinationDao;
import com.svalero.webapppresencial.dao.TypeDao;
import com.svalero.webapppresencial.dao.UserDao;
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
    private int numberTraveller;
}
