package org.example.calendar;

import java.util.Calendar;

public class TimeZone {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        java.util.TimeZone time_zone = cal.getTimeZone();
        System.out.println("Time Zone: " + time_zone.getDisplayName());
    }
}
