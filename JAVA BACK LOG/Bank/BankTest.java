package Bank;

import Bank.Account.Account;
import Bank.CustomException.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank;
    Account account;

    @BeforeEach
    void setUp() {
        bank = new Bank("Byte Bank");
    }

    @Test
    void bankExists() {
        assertNotNull(bank);
    }

    @Test
    void bankIsCreated_nameIsCorrect() {
        assertEquals("Byte Bank", bank.getName());
    }

    @Test
    void bankIsCreated_withNullName_throwsNullFieldException() {
        assertThrows(NullFieldException.class, () -> new Bank(null));
    }

    @Test
    void bankIsCreated_withEmptyName_throwsEmptyFieldException() {
        assertThrows(EmptyFieldException.class, () -> new Bank(""));
    }

    @Test
    void bankIsCreated_numberOfAccountsIsZero() {
        assertEquals(0, bank.getNumberOfAccounts());
    }


    @Test
    void bankIsEmpty_registerOneCustomer_numberOfAccountsIsOne() {
        bank.registerCustomer("victor", "1234");
        assertEquals(1, bank.getNumberOfAccounts());
    }

    @Test
    void bankIsEmpty_registerTwoCustomers_numberOfAccountsIsTwo() {
        bank.registerCustomer("victor", "1234");
        bank.registerCustomer("john", "5678");
        assertEquals(2, bank.getNumberOfAccounts());
    }

    @Test
    void bankIsEmpty_registerCustomer_accountNumberIsGenerated() {
        account = bank.registerCustomer("victor", "1234");
        assertNotNull(account.getAcctNumber());
        assertEquals(10, account.getAcctNumber().length());
    }

    @Test
    void bankIsEmpty_registerTwoCustomers_accountNumbersAreDifferent() {
        Account first = bank.registerCustomer("victor", "1234");
        Account second = bank.registerCustomer("john", "5678");
        assertNotEquals(first.getAcctNumber(), second.getAcctNumber());
    }

    @Test
    void bankIsEmpty_registerCustomerWithNullName_throwsNullFieldException() {
        assertThrows(NullFieldException.class, () -> bank.registerCustomer(null, "1234"));
    }

    @Test
    void bankIsEmpty_registerCustomerWithNullPin_throwsNullFieldException() {
        assertThrows(NullFieldException.class, () -> bank.registerCustomer("victor", null));
    }

    @Test
    void bankIsEmpty_registerCustomerWithEmptyName_throwsEmptyFieldException() {
        assertThrows(EmptyFieldException.class, () -> bank.registerCustomer("", "1234"));
    }

    @Test
    void bankIsEmpty_registerCustomerWithEmptyPin_throwsEmptyFieldException() {
        assertThrows(EmptyFieldException.class, () -> bank.registerCustomer("victor", ""));
    }


    @Test
    void bankHasOneAccount_depositValidAmount_balanceIncreases() {
        account = bank.registerCustomer("victor", "1234");
        bank.deposit(account.getAcctNumber(), new BigDecimal("1000"));
        assertEquals(new BigDecimal("1000"), bank.checkBalance(account.getAcctNumber(), "1234"));
    }

    @Test
    void bankHasOneAccount_depositNullAmount_throwsNullFieldException() {
        account = bank.registerCustomer("victor", "1234");
        assertThrows(NullFieldException.class, () -> bank.deposit(account.getAcctNumber(), null));
    }

    @Test
    void bankHasOneAccount_depositNegativeAmount_throwsInvalidAmountException() {
        account = bank.registerCustomer("victor", "1234");
        assertThrows(InvalidAmountException.class, () -> bank.deposit(account.getAcctNumber(), new BigDecimal("-100")));
    }

    @Test
    void bankHasOneAccount_depositToInvalidAccount_throwsAccountNotFoundException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(AccountNotFoundException.class, () -> bank.deposit("0000000000", new BigDecimal("1000")));
    }

    @Test
    void bankHasOneAccount_depositNullAccountNumber_throwsNullFieldException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(NullFieldException.class, () -> bank.deposit(null, new BigDecimal("1000")));
    }

    @Test
    void bankHasOneAccount_depositEmptyAccountNumber_throwsEmptyFieldException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(EmptyFieldException.class, () -> bank.deposit("", new BigDecimal("1000")));
    }


    @Test
    void bankHasOneAccount_withdrawValidAmount_balanceDecreases() {
        account = bank.registerCustomer("victor", "1234");
        bank.deposit(account.getAcctNumber(), new BigDecimal("1000"));
        bank.withdraw(account.getAcctNumber(), new BigDecimal("500"), "1234");
        assertEquals(new BigDecimal("500"), bank.checkBalance(account.getAcctNumber(), "1234"));
    }

    @Test
    void bankHasOneAccount_withdrawWithInvalidPin_throwsInvalidPinException() {
        account = bank.registerCustomer("victor", "1234");
        bank.deposit(account.getAcctNumber(), new BigDecimal("1000"));
        assertThrows(InvalidPinException.class, () -> bank.withdraw(account.getAcctNumber(), new BigDecimal("500"), "0000"));
    }

    @Test
    void bankHasOneAccount_withdrawMoreThanBalance_throwsInsufficientFundException() {
        account = bank.registerCustomer("victor", "1234");
        bank.deposit(account.getAcctNumber(), new BigDecimal("500"));
        assertThrows(InsufficientFundException.class, () -> bank.withdraw(account.getAcctNumber(), new BigDecimal("1000"), "1234"));
    }

    @Test
    void bankHasOneAccount_withdrawNullAmount_throwsNullFieldException() {
        account = bank.registerCustomer("victor", "1234");
        assertThrows(NullFieldException.class, () -> bank.withdraw(account.getAcctNumber(), null, "1234"));
    }

    @Test
    void bankHasOneAccount_withdrawNegativeAmount_throwsInvalidAmountException() {
        account = bank.registerCustomer("victor", "1234");
        bank.deposit(account.getAcctNumber(), new BigDecimal("1000"));
        assertThrows(InvalidAmountException.class, () -> bank.withdraw(account.getAcctNumber(), new BigDecimal("-100"), "1234"));
    }

    @Test
    void bankHasOneAccount_withdrawFromInvalidAccount_throwsAccountNotFoundException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(AccountNotFoundException.class, () -> bank.withdraw("0000000000", new BigDecimal("100"), "1234"));
    }

    @Test
    void bankHas2Accounts_transferValidAmount_balancesUpdateCorrectly() {
        Account victor = bank.registerCustomer("victor", "1234");
        Account john = bank.registerCustomer("john", "5678");
        bank.deposit(victor.getAcctNumber(), new BigDecimal("1000"));
        bank.transfer(victor.getAcctNumber(), john.getAcctNumber(), new BigDecimal("500"), "1234");
        assertEquals(new BigDecimal("500"), bank.checkBalance(victor.getAcctNumber(), "1234"));
        assertEquals(new BigDecimal("500"), bank.checkBalance(john.getAcctNumber(), "5678"));
    }

    @Test
    void bankHas2Accounts_transferWithInvalidPin_throwsInvalidPinException() {
        Account victor = bank.registerCustomer("victor", "1234");
        Account john = bank.registerCustomer("john", "5678");
        bank.deposit(victor.getAcctNumber(), new BigDecimal("1000"));
        assertThrows(InvalidPinException.class, () -> bank.transfer(victor.getAcctNumber(), john.getAcctNumber(), new BigDecimal("500"), "0000"));
    }

    @Test
    void bankHas2Accounts_transferMoreThanBalance_throwsInsufficientFundException() {
        Account victor = bank.registerCustomer("victor", "1234");
        Account john = bank.registerCustomer("john", "5678");
        bank.deposit(victor.getAcctNumber(), new BigDecimal("500"));
        assertThrows(InsufficientFundException.class, () -> bank.transfer(victor.getAcctNumber(), john.getAcctNumber(), new BigDecimal("1000"), "1234"));
    }

    @Test
    void bankHas2Accounts_transferToInvalidAccount_throwsAccountNotFoundException() {
        Account victor = bank.registerCustomer("victor", "1234");
        bank.deposit(victor.getAcctNumber(), new BigDecimal("1000"));
        assertThrows(AccountNotFoundException.class, () -> bank.transfer(victor.getAcctNumber(), "0000000000", new BigDecimal("500"), "1234"));
    }

    @Test
    void bankHas2Accounts_transferFromInvalidAccount_throwsAccountNotFoundException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(AccountNotFoundException.class, () -> bank.transfer("0000000000", "0000000001", new BigDecimal("500"), "1234"));
    }


    @Test
    void bankHasOneAccount_checkBalanceWithValidPin_returnsCorrectBalance() {
        account = bank.registerCustomer("victor", "1234");
        bank.deposit(account.getAcctNumber(), new BigDecimal("1000"));
        assertEquals(new BigDecimal("1000"), bank.checkBalance(account.getAcctNumber(), "1234"));
    }

    @Test
    void bankHasOneAccount_checkBalanceWithInvalidPin_throwsInvalidPinException() {
        account = bank.registerCustomer("victor", "1234");
        assertThrows(InvalidPinException.class, () -> bank.checkBalance(account.getAcctNumber(), "0000"));
    }

    @Test
    void bankHasOneAccount_checkBalanceWithInvalidAccount_throwsAccountNotFoundException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(AccountNotFoundException.class, () -> bank.checkBalance("0000000000", "1234"));
    }

    @Test
    void bankHasOneAccount_initialBalanceIsZero() {
        account = bank.registerCustomer("victor", "1234");
        assertEquals(BigDecimal.ZERO, bank.checkBalance(account.getAcctNumber(), "1234"));
    }

    @Test
    void bankHasOneAccount_removeAccount_numberOfAccountsIsZero() {
        account = bank.registerCustomer("victor", "1234");
        bank.removeAccount(account.getAcctNumber(), "1234");
        assertEquals(0, bank.getNumberOfAccounts());
    }

    @Test
    void bankHas2Accounts_removeOneAccount_numberOfAccountsIsOne() {
        Account victor = bank.registerCustomer("victor", "1234");
        bank.registerCustomer("john", "5678");
        bank.removeAccount(victor.getAcctNumber(), "1234");
        assertEquals(1, bank.getNumberOfAccounts());
    }

    @Test
    void bankHasOneAccount_removeAccountWithInvalidPin_throwsInvalidPinException() {
        account = bank.registerCustomer("victor", "1234");
        assertThrows(InvalidPinException.class, () -> bank.removeAccount(account.getAcctNumber(), "0000"));
    }

    @Test
    void bankHasOneAccount_removeInvalidAccount_throwsAccountNotFoundException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(AccountNotFoundException.class, () -> bank.removeAccount("0000000000", "1234"));
    }

    // ==================== findAccount ====================
    @Test
    void bankHasOneAccount_findValidAccount_returnsAccount() {
        account = bank.registerCustomer("victor", "1234");
        assertNotNull(bank.findAccount(account.getAcctNumber()));
    }

    @Test
    void bankHasOneAccount_findAccountWithInvalidNumber_throwsAccountNotFoundException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(AccountNotFoundException.class, () -> bank.findAccount("0000000000"));
    }

    @Test
    void bankIsEmpty_findAccount_throwsAccountNotFoundException() {
        assertThrows(AccountNotFoundException.class, () -> bank.findAccount("0000000000"));
    }

    @Test
    void bankHasOneAccount_findAccountWithNullNumber_throwsNullFieldException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(NullFieldException.class, () -> bank.findAccount(null));
    }

    @Test
    void bankHasOneAccount_findAccountWithEmptyNumber_throwsEmptyFieldException() {
        bank.registerCustomer("victor", "1234");
        assertThrows(EmptyFieldException.class, () -> bank.findAccount(""));
    }
}