# Bank Kata Project Guidelines

This document provides guidelines for developing and maintaining the Bank Kata project.

## Build/Configuration Instructions

### Prerequisites
- Java 21 or higher
- Maven 3.8 or higher

### Building the Project
The project uses Maven as its build system. Here are the common commands:

```bash
# Clean and compile the project
mvn clean compile

# Run all tests
mvn test

# Package the project
mvn package

# Clean, compile, test, and package in one command
mvn clean install
```

### Project Structure
The project follows a hexagonal architecture pattern:

- **Domain Layer**: Contains the core business logic
  - `org.bank.domain.Account`: Main entry point for the application
  - `org.bank.domain.model.Transaction`: Value object representing a transaction

- **Adapters Layer**: Contains adapters for external dependencies
  - Repository:
    - `org.bank.adapters.repository.TransactionRespository`: Stores transactions in memory
    - `org.bank.adapters.repository.Clock`: Provides the current date
  - Printer:
    - `org.bank.adapters.printer.StatementPrinter`: Formats and prints statements
    - `org.bank.adapters.printer.Console`: Wrapper around System.out.println

## Testing Information

### Running Tests
To run all tests:
```bash
mvn test
```

To run a specific test class:
```bash
mvn test -Dtest=ClassName
```

For example:
```bash
mvn test -Dtest=AccountShould
```

To run a specific test method:
```bash
mvn test -Dtest=ClassName#methodName
```

For example:
```bash
mvn test -Dtest=AccountShould#store_a_deposit_transaction
```

### Test Structure
The project uses JUnit 5 with Mockito for testing. Tests follow these patterns:

1. **Naming Convention**: Test classes are named with the pattern `[ClassUnderTest]Should`, and test methods describe what the class should do.

2. **Test Organization**: Tests follow the Given-When-Then pattern:
   - Given: Set up the test environment
   - When: Execute the method under test
   - Then: Verify the expected outcome

3. **Test Types**:
   - **Unit Tests**: Test a single class in isolation by mocking its dependencies
   - **Integration Tests**: Test the interaction between multiple components

### Adding New Tests
When adding new tests, follow these guidelines:

1. **Create a Test Class**: Create a new test class in the same package as the class under test, with the naming pattern `[ClassUnderTest]Should`.

2. **Use Mockito for Mocking**: Use Mockito to mock dependencies and isolate the class under test.

3. **Test Edge Cases**: Include tests for edge cases and error conditions.

4. **Example**: Here's an example of a simple test for the Console class:

```java
package org.bank.adapters.printer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleShould {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void print_line_to_console() {
        // Given
        Console console = new Console();
        String line = "Test line";
        
        // When
        console.printLine(line);
        
        // Then
        assertEquals(line + System.lineSeparator(), outContent.toString());
    }
}
```

## Additional Development Information

### Code Style
The project follows these code style guidelines:

1. **Naming Conventions**:
   - Classes: PascalCase
   - Methods and variables: camelCase
   - Constants: UPPER_SNAKE_CASE

2. **Method Naming**:
   - Test methods use snake_case to improve readability
   - Production methods use camelCase

3. **Immutability**:
   - Value objects (like Transaction) are immutable
   - Use final fields and avoid setters

### Architecture Guidelines
The project follows a hexagonal architecture pattern with these principles:

1. **Dependency Inversion**: The domain layer doesn't depend on adapters; adapters depend on the domain.

2. **Single Responsibility**: Each class has a single responsibility:
   - Account: Orchestrates the application flow
   - TransactionRepository: Stores transactions
   - StatementPrinter: Formats and prints statements
   - Clock: Provides the current date
   - Console: Handles console output

3. **Testability**: The architecture is designed for testability:
   - Dependencies are injected through constructors
   - Interfaces are used to isolate dependencies
   - Time-dependent code is isolated in the Clock class

### Testing Time-Dependent Code
The project demonstrates two approaches for testing time-dependent code:

1. **Mocking**: The Clock class is mocked in most tests to provide a fixed date.

2. **Subclassing**: The ClockShould test uses a test-specific subclass to override the time-dependent method.

### Extending the Application
To extend the application:

1. **Adding New Features**:
   - Add new methods to the appropriate classes
   - Follow the existing architecture patterns
   - Add tests for the new features

2. **Changing the Repository**:
   - Create a new implementation of the repository
   - Inject it into the Account class

3. **Changing the Statement Format**:
   - Modify the StatementPrinter class
   - Update the tests to reflect the new format