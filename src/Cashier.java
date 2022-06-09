import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Cashier {
    private Bank bankCashier;
    Cashier cashier = new Cashier(null);
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public Cashier(Bank bankCashier) {
        this.bankCashier = bankCashier;
    }

    public void showStartMenu() throws IOException {
        System.out.println("Select one: ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        int choice = console.read();
        if(choice == 1){
            cashier.showLogin();
        }else if(choice == 2){
            cashier.showRegister();
        }else if(choice == 0){
            System.exit(0);
        }
    }
    private void showLogin(){

    }
    private void showRegister(){
    }
    public void showCashierMenu(){
        System.out.println("1. Show my info");
        System.out.println("2. Add loan");
        System.out.println("3. Add debit card");
        System.out.println("0.  Exit");
    }
}
