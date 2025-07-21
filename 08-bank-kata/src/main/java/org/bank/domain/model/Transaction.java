package org.bank.domain.model;

import java.util.Objects;

public class Transaction {

    private final String date;
    private final Integer amount;

    public Transaction(String date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(date, that.date) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
