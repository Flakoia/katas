package org.example;

public class Account {
    private final TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(Integer amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(Integer amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void printStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
