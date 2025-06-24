package org.example;

import java.time.LocalTime;

public class TimeProvider {
    private final LocalTime time;

    public TimeProvider() {
        time = LocalTime.now();
    }

    public LocalTime getTime() {
        return time;
    }
}
