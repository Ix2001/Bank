import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<User> users = new ArrayList<>();
    List<Loan> loans = new ArrayList<>();
    List<DebitCard> debitCards = new ArrayList<>();
    Cashier cs = new Cashier(this);
    public void start(){
        deserializeUsers();
    }

    public boolean doLogin(String email, String password){
        for(User i : users){
            if()
        }
    }
    public void writeCardAdding(DebitCard debitCard){
        debitCards.add(debitCard);
        serializeUsers(users);
    }
    public void writeGetLoan(Loan loan){
        loans.add(loan);
        serializeUsers(users);
    }

    public void doRegister(User user){
        users.add(user);
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
        } catch (FileNotFoundException e) {
            File file = new File("Users.data");
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Cannot read file on disk");;
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file");;
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
        }


    }
}
