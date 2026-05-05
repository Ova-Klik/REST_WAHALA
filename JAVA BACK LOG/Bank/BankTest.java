package Bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class BankTest {

    @Test
    void testBankIsCreated(){
        Bank bank = new Bank("Zenith");
        assertNotNull(bank);
    }

    @Test
    void testBankIsCreatedWithName(){
        Bank bank = new Bank("Zenith");
    }

}