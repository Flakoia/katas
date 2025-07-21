package org.example;

public class Account {

    private TransactionRespository transactionRespository;
    private final StatementPrinter statementPrinter;

    public Account(TransactionRespository transactionRespository, StatementPrinter statementPrinter) {
        this.transactionRespository = transactionRespository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(Integer amount) {
        this.transactionRespository.addDeposit(amount);
    }

    public void withdraw(Integer amount) {
        this.transactionRespository.addWithdrawal(amount);
    }

    public void printStatement() {
        statementPrinter.print(transactionRespository.allTransactions());
    }
}
