import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    Bank bank = new Bank();
    Cashier cashier = new Cashier(bank);
    @Test
    void testGenerateCardNumber() {

        cashier.generateCardNumber();
        assertEquals("1234567891234567",cashier.generateCardNumber());
    }

    @Test
    void testGenerateCVV() {
        assertEquals(100,cashier.generateCVV());
    }
}