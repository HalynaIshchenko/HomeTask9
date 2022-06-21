package part2;

import java.time.*;
import java.util.Date;

/*
Створити методи які дозволять конвертувати дату з
Date --> LocalDate.
Date --> LocalTime,
Date --> LocalDateTime

 */
public class DateConvertorUtil {

    public static void main(String[] args) {
        Date date = new Date();

        // Date --> LocalDate.
        System.out.printf("LocalDate: %s \n", convertDateToLocalDate(date).toString());

        // Date --> LocalTime,
        System.out.printf("LocalTime: %s \n", convertDateToLocalTime(date));

        // Date --> LocalDateTime
        System.out.printf("LocalDateTime: %s \n", convertDateToLocalDateTime(date));
    }

    private static LocalTime convertDateToLocalTime(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return convertDateToLocalDateTime(date)
                .toLocalDate();
    }

    private static ZonedDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault());
    }

}
