package tiempo;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // Date d = new Date();

        // Calendar c = Calendar.getInstance();
        // c.set(2022, 11, 30);

        // LocalDateTime ldt = LocalDateTime.of(2022, Month.DECEMBER, 25, 0, 0);
        ZonedDateTime zdt = ZonedDateTime.now();

        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));

        LocalDate ldt = null;
        ldt = LocalDate.from(DateTimeFormatter.ofPattern("d-M-yyyy").parse("7-5-1977"));
        System.out.println(ldt);
        System.out.println(ldt.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
    }
}