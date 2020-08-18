package com.prestige.algorithm;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

/**
 * Created by prest on 6/6/2019.
 */
public class Test {

    public String stripHtmlTags(String html) {

       String newHtml =  html.replace("<h1>","");
       newHtml = newHtml.replace("</h1>","");
       newHtml = newHtml.replace("<p>","");
       newHtml = newHtml.replace("</p>","");

       return newHtml;

    }

    public static String findDay(int month, int day, int year) {

        LocalDate localDate = LocalDate.of(year, month, day);
        String[] days = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        String dayOfWeek = days[localDate.getDayOfWeek().getValue() - 1];

        return dayOfWeek;
    }

    public static void format(double amount){

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String us = nf.format(amount);
        nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = nf.format(amount);
        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = nf.format(amount);
        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = nf.format(amount);

        System.out.println(String.format("US: %S \nIndia: %s \nChina: %s \nFrance: %s", us, india, china, france));

    }

    private static void gmtDate(){

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("GMT"));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        System.out.println("Date : " + localDateTime.toString());
    }

    public static void main(String[] args) {

//        Test t = new Test();
//        System.out.println(t.stripHtmlTags("<h1>Hello World!</h1> <p>something</p>"));
//
//        Test.format(12324.134);

        Test.gmtDate();

    }
}
