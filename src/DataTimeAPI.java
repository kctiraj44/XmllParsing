import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

public class DataTimeAPI {
    public static void main(String[] args) {


        Date date = new Date();
        System.out.println("Current date : "+date);
        System.out.println("Current date: "+date.getTime());

        LocalDate localDate = LocalDate.now();
        System.out.println("Current date : "+localDate);

        LocalDate localDate1 = LocalDate.of(1997, Month.AUGUST,7);
        System.out.println("Current date : "+localDate1);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);




    }
}
