package Activities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
    @Test
    void notEnoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(8);

        // Assertion for exception
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10),
                "Withdrawal Amount must be less than the Available Balance amount");
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(100);

        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(100));
    }


}
