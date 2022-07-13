import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    public List<User> getUsers() {
        return users;
    }

    public User getAdmin() {
        return admin;
    }

    private List<User> users = new ArrayList<>();

    private User logedInUser = null;
    User admin = new User("admin","admin",new Date(),true,"admin","admin");
    public void admin(){
        users.add(admin);
        serializeUsers(users);
    }

    public User getLogedInUser() {
        return logedInUser;
    }

    Cashier cs = new Cashier(this);
    public void start(){
        deserializeUsers();
        cs.showStartMenu();
    }

    public boolean doLogin(String email, String password){
        for(User user: users){
            if(user.getEmail().equals(email) && user.getPwd().equals(password)){
                logedInUser = user;
                return true;

            }

        }
        return false;
    }
    public void writeCardAdding(DebitCard debitCard){
        logedInUser.getCards().add(debitCard);
        users.add(logedInUser);
        serializeUsers(users);
    }
    public void writeGetLoan(Loan loan){
        logedInUser.getLoans().add(loan);
        users.add(logedInUser);
        serializeUsers(users);
    }

    public void doRegister(User user){
        users.add(user);
        logedInUser = user;
        serializeUsers(users);
    }
    public void serializeUsers(List<User> users)  {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Users.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();

        } catch (FileNotFoundException e) {
            File file = new File("Users.data");
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Cannot create file on disk");;
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file");
        }
    }
    public void deserializeUsers()  {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("Users.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            admin();
        } catch (FileNotFoundException e) {
            File file = new File("Users.data");
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Cannot read file on disk");
            }
        } catch (IOException e) {
            users.add(admin);
            serializeUsers(users);
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
        }

    }
}
