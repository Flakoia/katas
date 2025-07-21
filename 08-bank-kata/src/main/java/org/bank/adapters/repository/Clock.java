package org.bank.adapters.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    protected DateTimeFormatter formater;

    public Clock() {
        formater = DateTimeFormatter.ofPattern(DD_MM_YYYY);
    }

    public Clock(String dateFormat) {
        formater = DateTimeFormatter.ofPattern(dateFormat);
    }

    public LocalDate today() {
        return LocalDate.now();
    }

    public String todayAsString() {
        return today().format(formater);
    }
}
