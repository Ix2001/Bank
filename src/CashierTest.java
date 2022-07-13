import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    Bank bank = new Bank();
    Cashier cashier = new Cashier(bank);
    @Test
    void testGenerateCardNumber() {

        assertEquals(16,cashier.generateCardNumber().length());
    }

    @Test
    void testGenerateCVV() {
        assertEquals(3,String.valueOf(cashier.generateCVV()).length());
    }
}