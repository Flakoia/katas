package org.bank.adapters.printer;

import org.bank.domain.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {

    @Mock
    private Console console;

    private StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {

        statementPrinter = new StatementPrinter(console);
    }

    @Test
    void always_print_the_header() {
        List<Transaction> NO_TRANSACTION = List.of();
        statementPrinter.print(NO_TRANSACTION);

        verify(console).printLine("DATE|AMOUNT|BALANCE");
    }

    @Test
    void print_transactions_in_reverse_chronological_order() {
        statementPrinter.print(transactionsContaining(
                deposit("19/07/2025", 500),
                withdraw("20/07/2025", 200),
                deposit("21/07/2025", 100)
        ));

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE|AMOUNT|BALANCE");
        inOrder.verify(console).printLine("21/07/2025|100.00|400.00");
        inOrder.verify(console).printLine("20/07/2025|-200.00|300.00");
        inOrder.verify(console).printLine("19/07/2025|500.00|500.00");
    }

    private List<Transaction> transactionsContaining(Transaction... transaction) {
        return List.of(transaction);
    }

    private Transaction withdraw(String date, Integer amount) {
        return new Transaction(date, -amount);
    }

    private Transaction deposit(String date, Integer amount) {
        return new Transaction(date, amount);
    }
}