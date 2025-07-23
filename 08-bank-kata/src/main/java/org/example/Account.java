package org.example;

public class Account {
    private final TransactionRepository transactionRepository;
    private final AccountPrinter accountPrinter;

    public Account(TransactionRepository transactionRepository, AccountPrinter accountPrinter) {
        this.transactionRepository = transactionRepository;
        this.accountPrinter = accountPrinter;
    }

    public void deposit(Integer amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(Integer amount) {
        transactionRepository.addWithdrawal(amount);
    }

    public void printStatement() {
        accountPrinter.print(transactionRepository.allTransactions());
    }
}
