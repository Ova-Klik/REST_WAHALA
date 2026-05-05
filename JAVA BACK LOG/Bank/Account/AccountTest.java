package Bank.Account;

import CustomException.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;
    final String CORRECT_PIN = "1234";
    final String INCORRECT_PIN = "0111";

    @BeforeEach
    void setUp() {
        account = new Account("Victor", CORRECT_PIN);

    }

    @Test
    void testAccountIsEmptyAtCreation() {
        assertNotNull(account);
    }

    @Test
    void testAccountBalanceIsZeroAtCreation() {

        assertEquals(BigDecimal.ZERO, account.getBalance(CORRECT_PIN));
    }

    @Test
    void testDepositZero_BalanceRemainsUnchanged() {
        account.deposit(BigDecimal.valueOf(900));
        account.deposit(BigDecimal.ZERO);
        assertEquals(BigDecimal.valueOf(900), account.getBalance(CORRECT_PIN));

    }

    @Test
    void testAccountDeposits5_000_AccountBalanceIs5_000() {

        BigDecimal amount = BigDecimal.valueOf(5000);
        assertEquals(BigDecimal.ZERO, account.getBalance(CORRECT_PIN));
        account.deposit(amount);
        assertEquals(amount, account.getBalance(CORRECT_PIN));
    }

    @Test
    void testDepositNull_ThrowsException() {
        assertThrows(NullFieldException.class, () -> account.deposit(null));
    }

    @Test
    void testDepositNegativeAmount_ThrowsException() {

        assertEquals(BigDecimal.ZERO, account.getBalance(CORRECT_PIN));
        assertThrows(InvalidAmountException.class, () -> account.deposit(BigDecimal.valueOf(-5000)));
    }

    @Test
    void testDeposit5_000_withdraw_5_000WithCorrectPin_AccountBalanceIsZero() {

        account.deposit(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), account.getBalance(CORRECT_PIN));
        account.withdraw(BigDecimal.valueOf(5000), CORRECT_PIN);
        assertEquals(BigDecimal.ZERO, account.getBalance(CORRECT_PIN));
    }


    @Test
    void testDeposit5_000_withdraw7_000WithCorrectPin_throwsException() {

        account.deposit(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), account.getBalance(CORRECT_PIN));
        assertThrows(InsufficientFundException.class, ()->account.withdraw(BigDecimal.valueOf(7000), CORRECT_PIN));

    }

    @Test
    void testGetBalance_withIncorrectPin_ThrowsException() {
        assertThrows(InvalidPinException.class, () -> account.getBalance(INCORRECT_PIN));
    }

    @Test
    void testAccountCreatedWithNullInPinField_ThrowsException() {

        assertThrows(NullFieldException.class, () -> account = new Account("Victor", null));
    }

    @Test
    void testAccountCreatedWithNullINNameField_ThrowsException() {

        assertThrows(NullFieldException.class, () -> account = new Account(null, CORRECT_PIN));
    }

    @Test
    void testAccountCreatedWithEmptyPin_ThrowsException() {

        assertThrows(EmptyFieldException.class, () -> account = new Account("Victor", ""));
    }

    @Test
    void testWithdraw5_000_withIncorrectPinThrowsException() {

        account.deposit(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), account.getBalance(CORRECT_PIN));
        assertThrows(InvalidPinException.class, () -> account.withdraw(BigDecimal.valueOf(5_000), INCORRECT_PIN));
    }
}



