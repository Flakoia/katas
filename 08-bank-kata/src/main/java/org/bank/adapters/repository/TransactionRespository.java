package org.bank.adapters.repository;

import org.bank.domain.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRespository {

    private final Clock clock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRespository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(Integer amount) {
        Transaction deposit = createTransaction(amount);
        transactions.add(deposit);
    }

    public void addWithdrawal(Integer amount) {
        Transaction withdraw = createTransaction(-amount);
        transactions.add(withdraw);
    }

    public List<Transaction> allTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    private Transaction createTransaction(int amount) {
        return new Transaction(clock.today(), amount);
    }
}
