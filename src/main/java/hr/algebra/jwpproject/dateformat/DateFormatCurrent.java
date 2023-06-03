package hr.algebra.jwpproject.dateformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatCurrent {
    public static String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).toString();
    }

}
