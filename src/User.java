import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User implements Serializable {
    public User(String name, String surname, String dob, boolean gender, String email, String pwd) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.pwd = pwd;
    }

    Scanner console = new Scanner(System.in);
    private String name;
    private String surname;
    private String dob;
    private boolean gender;
    private String email;
    private String pwd;
    List<Loan> loan = new ArrayList<>();
    List<DebitCard> cards = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDob() {
        return dob;
    }


    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean isSex() {
        return gender;
    }

    public void setSex(boolean sex) {
        this.gender = sex;
    }

    public List<Loan> getLoans() {
        return loan;
    }

    public void setLoans(List<Loan> credits) {
        this.loan = credits;
    }

    public List<DebitCard> getCards() {
        return cards;
    }

    public void setCards(List<DebitCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +

                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", credits=" + loan +
                ", cards=" + cards +
                '}';
    }


   // public void checkEmail(){
   //     System.out.println("Put your email and password");
   //     String eml = console.nextLine();
    //    String password = console.nextLine();
    //    if(eml.equals(email) && password.equals(pwd)){
    //        System.out.println("Wrong password or account don't exist");
   //     }
   // }

}
