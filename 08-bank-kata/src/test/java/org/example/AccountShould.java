package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountShould {
    private final List<Transaction> EMPTY_TRANSACTIONS = new ArrayList<>();
    @Mock
    private TransactionRepository transactionRepository;
    private Account account;
    @Mock
    private AccountPrinter accountPrinter;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRepository, accountPrinter);
    }

    @Test
    void store_a_deposit_transaction() {
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    void store_a_withdrawal_transaction() {
        account.withdraw(100);
        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    void print_a_statement() {
        when(transactionRepository.allTransactions()).thenReturn(EMPTY_TRANSACTIONS);
        account.printStatement();

        verify(accountPrinter).print(EMPTY_TRANSACTIONS);
    }
}