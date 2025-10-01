package test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

public class TimeClassType {
  public static void main(String[] args) {
    System.out.println(LocalDate.now());
    System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).plusMinutes(40));
    System.out.println(LocalDateTime.now());
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY:MM:dd HH:mm:ss");
    System.out.println(LocalDateTime.now().format(dateTimeFormatter));
    System.out.println(ZonedDateTime.now());
    System.out.println(Year.now());

  }
}

