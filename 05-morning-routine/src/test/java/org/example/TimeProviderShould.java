package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;


class TimeProviderShould {
    @Test
    public void returnActualTime() {
        TimeProvider timeProvider = new TimeProvider();
        Assertions.assertEquals(timeProvider.getTime().getHour(), LocalTime.now().getHour());
        Assertions.assertEquals(timeProvider.getTime().getMinute(), LocalTime.now().getMinute());
    }
}
