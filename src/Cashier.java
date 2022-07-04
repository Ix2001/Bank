import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            System.out.println("Cannot read the data");
        }
        if(choice == 1){
            showLogin();
        }else if(choice == 2){
            try {
                showRegister();
            } catch (ParseException e) {
                System.out.println("Error");
            }
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
            System.out.println("Cannot show login");
        }


        boolean isLogedIn = bank.doLogin(email, pwd);
        if(!isLogedIn){
            System.out.println("Incorrect email or password");
        }else {
            showCashierMenu();
        }
    }


    private void showRegister() throws ParseException {
        String email = null;
        String pwd = null;
        String name = null;
        String surname = null;
        String date = null;

        try {
            System.out.println("Please tell us your email");
            email = console.readLine();
            System.out.println("Please tell us your password");
            pwd = console.readLine();
            System.out.println("Please tell us your name");
            name = console.readLine();
            System.out.println("Please tell us your last name");
            surname = console.readLine();
            System.out.println("Please tell us your date of birth by dd/MM/yyyy format");
            date =  console.readLine();

        } catch (IOException e) {
            System.out.println("Cannot read the data");
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
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        User user = new User(name, surname, dob , gender, email, pwd);
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
            System.out.println("Cannot read the data");
        }



    }
    public void readCardAdding() {
        String cardNumber = generateCardNumber();
        double avialiableBalance = 0;
        String expireDate = null;
        //int cvv= 0;
        try {
            System.out.println("Please tell us avialiable balance of your card");
            avialiableBalance = console.read();
            System.out.println("Please tell us expire date of your card in format MM/YYYY");
            expireDate = console.readLine();
            //System.out.println("Write your cvv/cvc");
            //cvv = console.read();
        } catch (IOException e) {
            System.out.println("Cannot read the data");
        }


        Date expDate = null;
        try {
            expDate = new SimpleDateFormat("MM/yyyy").parse(expireDate);
        } catch (ParseException e) {
            System.out.println("Cannot convert string to date");
        }
        int cvv = generateCVV();
        DebitCard debitCard = new DebitCard(avialiableBalance, cardNumber, expDate, cvv);
        bank.writeCardAdding(debitCard);
    }
    public void readGetLoan(){
        System.out.println("Please tell us application date");
        String application = null;
        double interest = 0;
        int month = 0;
        double monthlyPayments = 0;
        try {
            application = console.readLine();
            System.out.println("Please tell us interest rate");
            interest = console.read();
            System.out.println("Please tell us desire loan repayment period");
            month = console.read();
            monthlyPayments = console.read();
            System.out.println("Please tell us desire monthly Payments");
            monthlyPayments = console.read();
        } catch (IOException e) {
            System.out.println("Cannot read the data");;
        }

        Date applicationDate = null;
        try {
            applicationDate = new SimpleDateFormat("dd/MM/yyyy").parse(application);
        } catch (ParseException e) {
            System.out.println("Cannot read the data");;
        }
        Loan loan = new Loan(applicationDate,interest,month,monthlyPayments);
        bank.writeGetLoan(loan);
    }
    public String generateCardNumber(){
        long a = 1000000000000000L; // Начальное значение диапазона - "от"
        long b = 9999999999999999L; // Конечное значение диапазона - "до"

        long cardNumber0 = a + (long) (Math.random() * b);
        String cardNumber = Long.toString(cardNumber0);
        return cardNumber;
    }
    public int generateCVV(){
        int a = 111; // Начальное значение диапазона - "от"
        int b = 999; // Конечное значение диапазона - "до"

        int cvv = a + (int) (Math.random() * b);
        return cvv;
    }
}
