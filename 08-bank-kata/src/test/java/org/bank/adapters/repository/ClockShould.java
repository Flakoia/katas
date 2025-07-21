package org.bank.adapters.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClockShould {
    private Clock clock;

    @BeforeEach
    void setUp() {
        clock = new TestableClock("dd/MM/yyyy");
    }

    @Test
    void should_return_today_AsString_date() {
        assertEquals("20/07/2025", clock.todayAsString());
    }

    private class TestableClock extends Clock {

        public TestableClock(String dateFormat) {
            super(dateFormat);
        }

        @Override
        public LocalDate today() {
            return LocalDate.of(2025, 07, 20);
        }
    }
}