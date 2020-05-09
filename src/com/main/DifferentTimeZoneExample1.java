package com.main;


import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DifferentTimeZoneExample1 {

    public static void main(String[] args) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("LocalDateTime : " + format.format(ldt));

        //UTC+8
        ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Asia/Calcutta"));
       System.out.println(klDateTime);

        //UTC+9 and flight duration = 7 hours
        ZonedDateTime japanDateTime = klDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(7);
        System.out.println("Arrive : " + format.format(japanDateTime));

        System.out.println("\n---Detail---");
        System.out.println("Depart : " + klDateTime);
        System.out.println("Arrive : " + japanDateTime);

    }

}