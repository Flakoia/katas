Learn and practice the double loop of TDD
Test application from outside, identifying side effects

### Problem description - Bank kata

Create a simple bank application with the following features:

- Deposit into Account
- Withdraw from an Account
- Print a bank statement to the console

## Acceptance criteria

1. Statement should have transactions in the following format:
~~~ 
DATE        | AMOUNT | BALANCE  
10/04/2024  | 500.00 | 1400.00  
02/04/2024  |-100.00 |  900.00  
01/04/2024  |1000.00 | 1000.00
~~~ 

2. Statement should be printed in the Console
3. Transactions should be stored in a in memory repository
4. Code design should allow modification of both print statement and repository

## Starting point and constraints
1. Start with a class the following structure:

~~~ 
public class Account {

    public void deposit(int amount);

    public void withdraw(int amount);

    public void printStatement();
}
~~~ 

2. You are not allowed to add any other public method to this class.
3. Use Strings and Integers for dates and amounts (keep it simple)
4. Don’t worry about spacing in the statement printed on the console

## Hints
1. Where should the transactions be stored, and how can they be accessed to generate the statement?
2. How can we print without knowing either the data source or the output format in advance?
3. How can the Account object orchestrate the overall logic while delegating work to other classes so that those classes don’t depend on Account itself?
4. Which objects need to know the date, the amount, and the balance?
5. How can we enable testing without relying on external systems?

## How to
1. Acceptance criteria
2. Add a repository
3. Add a printer
4. Store in repository
5. Withdraw in Repository
6. Create clock
7. Statement printline
8. Console, Reverse order