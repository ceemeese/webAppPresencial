package com.svalero.webapppresencial.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.svalero.webapppresencial.util.Constants.*;

public class DateUtils {

    private static String format(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String formatUser(Date date) {
        return format(date, USER_DATE_PATTERN);
    }

    public static String formatComplete(Date date) {
        return format(date, COMPLETE_DATE_PATTERN);
    }

    public static Date parse(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        return new Date(dateFormat.parse(date).getTime());
    }
}
