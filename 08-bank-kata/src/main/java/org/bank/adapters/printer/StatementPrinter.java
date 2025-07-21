package org.bank.adapters.printer;

import org.bank.domain.model.Transaction;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {
    public static final String HEADER = "DATE|AMOUNT|BALANCE";
    public static final String SEPARATOR = "|";
    private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    private static final DecimalFormat decimalFormatter = new DecimalFormat("0.00", symbols);
    private final Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(HEADER);
        printStatementLines(transactions);
    }

    private void printStatementLines(List<Transaction> transactions) {
        AtomicInteger balance = new AtomicInteger(0);
        transactions
                .stream()
                .map(
                transaction ->
                        statementLine(transaction, balance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction transaction, AtomicInteger balance) {
        return transaction.date() +
                SEPARATOR +
                decimalFormatter.format(transaction.amount()) +
                SEPARATOR +
                decimalFormatter.format(balance.addAndGet(transaction.amount()));
    }
}
