package org.example;

public class Account {

    private TransactionRespository transactionRespository;

    public Account(TransactionRespository transactionRespository) {
        this.transactionRespository = transactionRespository;
    }

    public void deposit(Integer amount) {
        this.transactionRespository.addDeposit(amount);
    }

    public void withdraw(Integer amount) {
        this.transactionRespository.addWithdrawal(amount);
    }

    public void printStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
