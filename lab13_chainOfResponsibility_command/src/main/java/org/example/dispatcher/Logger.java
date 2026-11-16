package org.example.dispatcher;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void log(String source, String message) {
        String time = LocalTime.now().format(TIME_FORMATTER);
        System.out.printf("[%s] [%s] %s%n", time, source, message);
    }
}