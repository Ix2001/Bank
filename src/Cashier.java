import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cashier {
    Scanner scanner = new Scanner(System.in);

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
            choice = Integer.parseInt(console.readLine());
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
            showStartMenu();
        }
        showCashierMenu();
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
            bank.getLogedInUser();
        } catch (IOException e) {
            System.out.println("Cannot read the data");
        }

        System.out.println("Please choose your gender male or female");
        System.out.println("1. Male");
        System.out.println("2. Female");

        Scanner scanner = new Scanner(System.in);
        boolean gender = true;
        int choice2 = scanner.nextInt();
        if(choice2 == 1){
            gender = true;
        }else if(choice2 == 2){
            gender = false;
        }else {
            System.out.println("Wrong number");
        }

//        int choice2;
//        try {
//            choice2 = console.read();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        boolean gender = true;
//        if(choice2 == 1){
//            gender = true;
//        }
//        else if(choice2 ==2 ){
//            gender = false;
//        }else {
//            System.out.println("Wrong number");
//        }
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        User user = new User(name, surname, dob , gender, email, pwd);
        bank.doRegister(user);
        showCashierMenu();
    }
    public void showCashierMenu() {
        System.out.println("1. Show my info");
        System.out.println("2. Add loan");
        System.out.println("3. Add debit card");
        if(bank.getLogedInUser().getEmail().equals(bank.getAdmin().getEmail()) || bank.getLogedInUser().getPwd().equals(bank.getAdmin().getPwd())){
            System.out.println("4. Show statistic");
        }
        System.out.println("0.  Exit");
        int choice = scanner.nextInt();
        if(choice == 2){
            this.readGetLoan();
            showCashierMenu();
        }else if(choice == 3){
            try {
                this.readCardAdding();
                showCashierMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(choice == 1){
            bank.showMyInfo();
            System.out.println("Please push 1 to get menu");
            int choice1 = scanner.nextInt();
            if(choice1 == 1){
                showCashierMenu();
            }
        }else if(choice == 0){
            System.exit(0);
        }
//        try {
//            Integer.parseInt(console.readLine());
//            if(choice == 2){
//                this.readGetLoan();
//            }else if(choice == 3){
//                this.readCardAdding();
//            }
//        } catch (IOException e) {
//            System.out.println("Cannot read the data");
//        }



    }
    public void readCardAdding() throws IOException {
        String cardNumber = generateCardNumber();
        double avialiableBalance = 0;
        String expireDate = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner console = new Scanner(System.in);

            System.out.println("Please tell us avialiable balance of your card");
            avialiableBalance = console.nextDouble();
            System.out.println("Please tell us expire date of your card in format MM/YYYY");
            expireDate = bufferedReader.readLine();
            //System.out.println("Write your cvv/cvc");
            //cvv = console.read();
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
        Scanner console = new Scanner(System.in);
        System.out.println("Please tell us application date dd/MM/yyyy");
        String application = console.nextLine();
        System.out.println("Please tell us interest rate");
        int interest = console.nextInt();
        System.out.println("Please tell us desire loan repayment period");
        int month = console.nextInt();
        System.out.println("Please tell us desire monthly Payments");
        int monthlyPayments = console.nextInt();
            /*application = console.nextLine();
            System.out.println("Please tell us interest rate");
            interest = console.nextDouble();
            System.out.println("Please tell us desire loan repayment period");
            month = console.nextInt();
            monthlyPayments = console.nextDouble();
            System.out.println("Please tell us desire monthly Payments");
            monthlyPayments = console.nextDouble();;*/
        Date applicationDate = null;
        try {
            applicationDate = new SimpleDateFormat("dd/MM/yyyy").parse(application);
        } catch (ParseException e) {
            System.out.println("Cannot read the data");;
        }
        Loan loan = new Loan(applicationDate,interest,month,monthlyPayments);
        bank.writeGetLoan(loan);
        System.out.println("Your loan was approved");
    }
    public String generateCardNumber(){
        long a = 1000000000000000L; // Начальное значение диапазона - "от"
        long b = 9999999999999999L; // Конечное значение диапазона - "до"

        long cardNumber0 = a + (long) (Math.random() * b);
        String cardNumber = Long.toString(cardNumber0);
        return cardNumber;
    }
    public int generateCVV(){
        int a = 100; // Начальное значение диапазона - "от"
        int b = 999; // Конечное значение диапазона - "до"

        int cvv = a + (int) (Math.random() * b);
        return cvv;
    }

}
