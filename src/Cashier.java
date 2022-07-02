import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Cashier {
    public Bank bank;

    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public Cashier(Bank bank) {
        this.bank = bank;
    }

    public void showStartMenu() {

        System.out.println("Select one: ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        int choice = 0;
        try {
            choice = console.read();
        } catch (IOException e) {
            System.out.println("Cannot read the data");;
        }
        if(choice == 1){
            showLogin();
        }else if(choice == 2){
            showRegister();
        }else if(choice == 0){
            System.exit(0);
        }
    }
    private void showLogin() {
        System.out.println("Please tell us your email");
        String email = null;
        String pwd = null;
        try {
            email = console.readLine();
            System.out.println("Please tell us your password");
            pwd = console.readLine();
        } catch (IOException e) {

        }


        boolean isLogedIn = bank.doLogin(email, pwd);
        if(!isLogedIn){
            System.out.println("Incorrect email or password");
        }else {
            showCashierMenu();
        }
    }


    private void showRegister() {
        System.out.println("Please tell us your email");
        String email = null;
        String pwd = null;
        String name = null;
        String surname = null;
        String date = null;
        try {
            email = console.readLine();
            System.out.println("Please tell us your password");
            pwd = console.readLine();
            System.out.println("Please tell us your name");
            name = console.readLine();
            System.out.println("Please tell us your last name");
            surname = console.readLine();
            System.out.println("Please tell us your date of birth");
            date =  console.readLine();
        } catch (IOException e) {
            System.out.println("Cannot read the data");;
        }

        System.out.println("Please choose your gender");
        System.out.println("1. Male");
        System.out.println("2. Female");
        int choice2 = 0;
        try {
            choice2 = console.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean gender = true;
        if(choice2 == 1){
            gender = true;
        }
        else if(choice2 ==2 ){
            gender = false;
        }else {
            System.out.println("Wrong number");
        }
        User user = new User(name, surname, date , gender, email, pwd);
        bank.doRegister(user);

    }
    public void showCashierMenu() {
        System.out.println("1. Show my info");
        System.out.println("2. Add loan");
        System.out.println("3. Add debit card");
        System.out.println("0.  Exit");
        int choice = 0;
        try {
            choice = console.read();
            if(choice == 2){
                this.readGetLoan();
            }else if(choice == 3){
                this.readCardAdding();
            }
        } catch (IOException e) {
            System.out.println("Cannot read the data");;
        }



    }
    public void readCardAdding() throws IOException {
        long a = 1000000000000000L; // Начальное значение диапазона - "от"
        long b = 9999999999999999L; // Конечное значение диапазона - "до"

        long cardNumber = a + (long) (Math.random() * b);
        //System.out.println("Please generate card number");
        //long cardNumber = console.read();
        System.out.println("Please tell us avialiable balance of your card");
        double avialiableBalance = console.read();
        System.out.println("Please tell us expire date of your card");
        String expireDate = console.readLine();
        //System.out.println("Write your cvv/cvc");
        //int cvv = console.read();
        int a1 = 000; // Начальное значение диапазона - "от"
        int b1 = 999; // Конечное значение диапазона - "до"

        int cvv = a1 + (int) (Math.random() * b1);
        DebitCard debitCard = new DebitCard(avialiableBalance, cardNumber, expireDate, cvv);
        bank.writeCardAdding(debitCard);
    }
    public void readGetLoan() throws IOException {
        System.out.println("Please tell us application date");
        String application = console.readLine();
        System.out.println("Please tell us interest rate");
        double interest = console.read();
        System.out.println("Please tell us desire loan repayment period");
        int month = console.read();
        System.out.println("Please tell us desire monthly Payments");
        double monthlyPayments = console.read();
        Loan loan = new Loan(application,interest,month,monthlyPayments);
        bank.writeGetLoan(loan);
    }
}
