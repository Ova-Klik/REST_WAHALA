package Bank.Account;

import Bank.CustomException.*;
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
        // ✅ Account now requires acctNumber — pass a dummy one in tests
        account = new Account("Victor", "0850000017", CORRECT_PIN);
    }

    @Test
    void testAccountIsNotNullAtCreation() {
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
    void testDeposit5_000_withdraw5_000WithCorrectPin_AccountBalanceIsZero() {
        account.deposit(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), account.getBalance(CORRECT_PIN));
        account.withdraw(BigDecimal.valueOf(5000), CORRECT_PIN);
        assertEquals(BigDecimal.ZERO, account.getBalance(CORRECT_PIN));
    }

    @Test
    void testDeposit5_000_withdraw7_000WithCorrectPin_throwsException() {
        account.deposit(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), account.getBalance(CORRECT_PIN));
        assertThrows(InsufficientFundException.class, () -> account.withdraw(BigDecimal.valueOf(7000), CORRECT_PIN));
    }

    @Test
    void testGetBalance_withIncorrectPin_ThrowsException() {
        assertThrows(InvalidPinException.class, () -> account.getBalance(INCORRECT_PIN));
    }

    @Test
    void testAccountCreatedWithNullPin_ThrowsException() {
        assertThrows(NullFieldException.class, () -> new Account("Victor", "0850000017", null));
    }

    @Test
    void testAccountCreatedWithNullName_ThrowsException() {
        assertThrows(NullFieldException.class, () -> new Account(null, "0850000017", CORRECT_PIN));
    }

    @Test
    void testAccountCreatedWithNullAcctNumber_ThrowsException() {
        assertThrows(NullFieldException.class, () -> new Account("Victor", null, CORRECT_PIN));
    }

    @Test
    void testAccountCreatedWithEmptyPin_ThrowsException() {
        assertThrows(EmptyFieldException.class, () -> new Account("Victor", "0850000017", ""));
    }

    @Test
    void testAccountCreatedWithEmptyName_ThrowsException() {
        assertThrows(EmptyFieldException.class, () -> new Account("", "0850000017", CORRECT_PIN));
    }

    @Test
    void testWithdraw5_000_withIncorrectPin_ThrowsException() {
        account.deposit(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), account.getBalance(CORRECT_PIN));
        assertThrows(InvalidPinException.class, () -> account.withdraw(BigDecimal.valueOf(5_000), INCORRECT_PIN));
    }

    @Test
    void testWithdrawNull_ThrowsException() {
        account.deposit(BigDecimal.valueOf(5000));
        assertThrows(NullFieldException.class, () -> account.withdraw(null, CORRECT_PIN));
    }

    @Test
    void testWithdrawNegativeAmount_ThrowsException() {
        account.deposit(BigDecimal.valueOf(5000));
        assertThrows(InvalidAmountException.class, () -> account.withdraw(BigDecimal.valueOf(-100), CORRECT_PIN));
    }

    @Test
    void testGetAcctNumber_returnsCorrectAccountNumber() {
        assertEquals("0850000017", account.getAcctNumber());
    }

    @Test
    void testGetName_returnsCorrectName() {
        assertEquals("Victor", account.getName());
    }
}