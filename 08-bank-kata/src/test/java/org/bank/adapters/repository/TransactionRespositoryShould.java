package org.bank.adapters.repository;

import org.bank.adapters.printer.StatementPrinter;
import org.bank.domain.Account;
import org.bank.domain.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TransactionRespositoryShould {

    public static final String TODAY = "21/07/2025";
    private TransactionRespository transactionRepository;
    private Account account;
    @Mock
    private Clock clock;

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRespository(clock);
        StatementPrinter statementPrinter = new StatementPrinter();
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    void create_and_store_a_deposit() {
        given(clock.today()).willReturn(TODAY);
        account.deposit(200);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertEquals(1, transactions.size());
        assertEquals(transaction(TODAY, 200), transactions.getFirst());
    }

    private Transaction transaction(String date, Integer amount) {
        return new Transaction(date, amount);
    }
}