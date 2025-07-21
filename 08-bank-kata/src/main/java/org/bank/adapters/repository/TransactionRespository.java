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
        transactions.add(new Transaction(clock.today(), amount));
    }

    public void addWithdrawal(Integer amount) {
        transactions.add(new Transaction(clock.today(), -amount));
    }

    public List<Transaction> allTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
