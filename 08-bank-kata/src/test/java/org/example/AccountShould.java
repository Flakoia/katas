package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountShould
{
    @Mock
    TransactionRespository transactionRespository;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRespository);
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

}
