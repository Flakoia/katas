package org.bank.domain;

import org.bank.adapters.printer.StatementPrinter;
import org.bank.adapters.repository.TransactionRespository;

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
