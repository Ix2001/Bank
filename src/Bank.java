import java.io.IOException;

public class Bank {
    Bank bank = new Bank();
    Cashier cashier = new Cashier(bank);
    public void start() throws IOException {
        cashier.showStartMenu();
    }
    public boolean doLogin(String email, String password){
        return true;
    }
    public void doRegister(User user){

    }
}
