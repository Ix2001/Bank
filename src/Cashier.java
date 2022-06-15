import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Cashier {
    public Bank bank;
    Cashier cashier = new Cashier(null);
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public Cashier(Bank bank) {
        this.bank = bank;
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
    private void showLogin() throws IOException {
        System.out.println("Please tell us your email");
        String email = console.readLine();
        System.out.println("Please tell us your password");
        String pwd = console.readLine();
        boolean isLogedIn = bank.doLogin(email, pwd);
        if(isLogedIn == false){
            System.out.println("Incorrect email or password");
        }else {
            showCashierMenu();
        }
    }


    private void showRegister() throws IOException {
        System.out.println("Please tell us your name");
        console.readLine();
        System.out.println("Please tell us your last name");
        console.readLine();
        System.out.println("Please tell us your date of birth");
        console.readLine();
        System.out.println("Please choose your gender");
        System.out.println("1. Male");
        System.out.println("2. Female");
        int choice2 = console.read();
        if(choice2 == 1){

        }
        else if(choice2 ==2 ){

        }else {
            System.out.println("Wrong number");
        }
    }
    public void showCashierMenu(){
        System.out.println("1. Show my info");
        System.out.println("2. Add loan");
        System.out.println("3. Add debit card");
        System.out.println("0.  Exit");
    }


}
