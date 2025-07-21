package org.bank.domain;

import org.bank.adapters.printer.StatementPrinter;
import org.bank.domain.model.Transaction;
import org.bank.adapters.repository.TransactionRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountShould
{
    @Mock
    TransactionRespository transactionRespository;
    @Mock
    StatementPrinter statementPrinter;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRespository, statementPrinter);
    }

    @Test
    void store_a_deposit_transaction() {
        account.deposit(100);
        verify(transactionRespository).addDeposit(100);
    }

    @Test
    void store_a_withdrawal_transaction() {
        account.withdraw(100);
        verify(transactionRespository).addWithdrawal(100);
    }

    @Test
    void print_a_statement()
    {
        List<Transaction> transactions = asList(new Transaction(null, null));
        given(transactionRespository.allTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
