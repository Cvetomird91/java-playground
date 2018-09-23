import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.Month;

import java.net.SocketException;

//basic examples of the Java 8 date/time API

public class Timing extends MyClass {
    public static void main(String[] args) throws DateTimeException {

        LocalDate nowDate = LocalDate.now();             //2018-09-21
        LocalTime nowTime = LocalTime.now();             //11:27:30.209966
        //Java works with nano seconds as the smallest time period it can be specified to
        //an object which can represent time
        LocalDateTime nowDateTime = LocalDateTime.now(); //2018-09-21T11:27:30.209915

        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        LocalTime time1 = LocalTime.of(22, 00, 13, 1000001);

        //we cannot omit the parameters representing time here. We need to atleast specify the hours
        //in LocalDateTime objects
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        //a LocalDateTime can be constructed from a LocalDate and LocalTime object
        LocalDateTime fromObjects = LocalDateTime.of(date1, time1);

        //Both Period and Date objects have private constructors. They cannot be chained because of this.
        //Only the last method takes effect when methods are chained on Duration/Period object
        Period period = Period.ofDays(5);
        date1 = date1.plus(period);

        Duration d = Duration.ofMinutes(100);
        time1 = time1.minus(d);

        System.out.println(date1.format(DateTimeFormatter.ISO_LOCAL_DATE));             //2015-01-25
        System.out.println(time1.format(DateTimeFormatter.ISO_LOCAL_TIME));             //20:20:13.001000001
        System.out.println(fromObjects.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));  //2015-01-20T22:00:13.001000001
        System.out.println(fromObjects.format(DateTimeFormatter.ISO_TIME));             //22:00:13.001000001
        System.out.println(fromObjects.format(DateTimeFormatter.ISO_DATE));             //2015-01-20
        
        //we can init a DateTimeFormatter reference(shortDateTime) to pass it to the format methods
        //in the LocalDate, LocalDateTime and LocalDateTime classes
        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(nowDateTime.format(shortDateTime));
//        System.out.println(date1.format(shortDateTime));
//        System.out.println(time1.format(shortDateTime));

        //DateTimeFormatter also has a format method which can accept date/time objects
        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter longF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);      //supports time zones and needs to be uzed with a ZonedDateTime
        DateTimeFormatter fullF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);      //supports time zones and needs to be uzed with a ZonedDateTime

        System.out.println(shortF.format(nowDateTime));
        System.out.println(mediumF.format(nowDateTime));
        System.out.println(longF.format(nowDateTime));        //throws DateTimeException at runtime because LocalDateTime doesn't support time zones
        System.out.println(fullF.format(nowDateTime));        //throws DateTimeException at runtime because LocalDateTime doesn't support time zones
        
        
        //We can create our own custom date/time formats
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(nowDateTime.format(customFormat)); // September 21, 2018, 12:12

        /*
            M represents the month. The more M s you have, the more verbose the Java output.
            For example, M outputs 1, MM outputs 01, MMM outputs Jan, and MMMM outputs January.
            MMMM
            d represents the date in the month. As with month, the more d s you have, the more
            verbose the Java output. dd means to include the leading zero for a single-digit month.
            dd
            ,
            Use , if you want to output a comma (this also appears after the year).
            yyyy
            y represents the year. yy outputs a two-digit year and yyyy outputs a four-digit year.
            hh h represents the hour. Use hh to include the leading zero if you’re outputting a single-
            digit hour.
            :
            mm
            Use : if you want to output a colon.
            m represents the minute.
         */

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDate date3 = LocalDate.parse("01 02 2015", f);
        LocalTime time3 = LocalTime.parse("11:22:33");
        DateTimeFormatter outF = DateTimeFormatter.ofPattern("MM dd yyyy");
        System.out.println(date3); //2015-01-02
        System.out.println(time3); //11:22:33
        System.out.println(date3.format(outF)); // 01 02 2015
        
        System.out.println(date3.plus(Period.ofDays(5)).format(f)); // 01 07 2015


    }
}
