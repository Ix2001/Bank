import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    Bank bank0 = new Bank();
    private List<User> userslist;
    public void start(){

    }
    public boolean doLogin(String email, String password){
        return true;
    }
    public void doRegister(User user){

    }
    List<User> users = new ArrayList<>();
    public void serializeUsers(List<User> users) throws IOException {
        FileOutputStream fos = new FileOutputStream("Users.data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();

    }
    public void deserializeUsers() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Users.data");
        ObjectInputStream ois = new ObjectInputStream(fis);
        users = (ArrayList) ois.readObject();
        ois.close();
        fis.close();

    }
}
