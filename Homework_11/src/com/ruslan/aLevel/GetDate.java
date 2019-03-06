package com.ruslan.aLevel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class GetDate {
    LocalDateTime now = LocalDateTime.now();
    Date date = new Date();
    OffsetDateTime ofd = OffsetDateTime.now(ZoneId.systemDefault());
    public void firstExample(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(timeFormatter.format(now));
    }
    public void secondExample(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(timeFormatter.format(now));
    }
    public void thirdExample(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(timeFormatter.format(now));
    }
    public void fourthExample(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ofd.getOffset());
        System.out.println(timeFormatter.format(now));
    }
    public void fifthExample(){
        SimpleDateFormat format = new SimpleDateFormat("hh 'o''clock' a, zzzz");
        System.out.println(format.format(date));
    }
    public void sixthExample(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        System.out.println(format.format(date));
    }
    public void seventhExample(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(timeFormatter.format(now));
    }
}
