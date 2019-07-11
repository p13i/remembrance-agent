package io.p13i.ra.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final String YEAR_FORMAT = "yyyy";
    public static final String MONTH_FORMAT = "MM";
    public static final String DAY_FORMAT = "dd";
    public static final String DAY_OF_WEEK_FORMAT = "EEE";
    public static final String HOUR_FORMAT = "HH";
    public static final String MINUTE_FORMAT = "mm";
    public static final String SECOND_FORMAT = "ss";

    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";


    public static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date now() {
        return Calendar.getInstance().getTime();
    }

    public static String nowAs(String pattern) {
        return formatDate(now(), pattern);
    }

    public static String timestamp() {
        return nowAs(TIMESTAMP_FORMAT);
    }

    public static String timestampOf(Date date) {
        return formatDate(date, TIMESTAMP_FORMAT);
    }
}
