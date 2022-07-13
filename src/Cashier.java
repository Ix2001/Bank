import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        System.out.println("0. Exit");
        System.out.println("9. back to authorization menu");
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
            this.showMyInfo();
            System.out.println("Please push 1 to get menu");
            int choice1 = scanner.nextInt();
            if(choice1 == 1){
                showCashierMenu();
            }
        }else if(choice == 0){
            System.exit(0);
        }
        else if(choice == 4){
            adminMenu();
        }
        else if(choice == 9){
            showStartMenu();
        }
    }
    public void adminMenu(){
        System.out.println("Please choose the option");
        System.out.println("1. Show all register user");
        System.out.println("2. Sort users by loan");
        System.out.println("3. Sort and group users by card");
        System.out.println("0. Back to menu");
        int choicesort = scanner.nextInt();
        if(choicesort ==3){
            this.showStatitsicGroupingCard();
            adminMenu();
        } else if (choicesort == 2) {
            this.showStatitsicLoans();
            adminMenu();
        } else if (choicesort == 1) {
            this.showAllusers();
            adminMenu();
        } else if (choicesort == 0) {
            showCashierMenu();
        }
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
        long a = 1000000000000000L;
        long b = 8999999999999999L;

        long cardNumber0 = a + (long) (Math.random() * b);
        String cardNumber = Long.toString(cardNumber0);
        return cardNumber;
    }
    public int generateCVV(){
        int a = 100; // Начальное значение диапазона - "от"
        int b = 899; // Конечное значение диапазона - "до"

        int cvv = a + (int) (Math.random() * b);
        return cvv;
    }
    public void showMyInfo(){
        System.out.println(bank.getLogedInUser());
    }
    public void showStatitsicLoans(){
        List<User> sorted =  bank.getUsers().stream()
                .sorted((user, user2) -> Integer.compare(user2.getLoans().size(), user.getLoans().size()))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

    }
    public void showStatitsicGroupingCard(){
        bank.getUsers().stream()
                .collect(Collectors.groupingBy(user -> user.getCards().size()))
                .forEach((cards,users)-> System.out.println(cards + ": " + users));

    }
    public void showAllusers(){
        for(User user: bank.getUsers()){
            System.out.println(user.toString());
        }
    }


}
