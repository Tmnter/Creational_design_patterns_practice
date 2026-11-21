package org.example.airport_Visitor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class EventLogger {
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    private EventLogger() {
    }

    public static void log(String source, String event) {
        String time = LocalTime.now().format(TIME_FMT);
        System.out.println("[" + time + "] [" + source + "] " + event);
    }
}