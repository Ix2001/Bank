import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private Date dob = new Date();
    private boolean man = true;
    private boolean female = false;
    private String email;
    private String pwd;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public void setFemale(boolean female) {
        this.female = female;
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

    public Date getDob() {
        return dob;
    }

    public boolean isMan() {
        return man;
    }

    public boolean isFemale() {
        return female;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String toString() {
        System.out.println("First name:" + name);
        System.out.println("Last name: " + surname);
        System.out.println("Birth date: " + dob);
        return toString();
    }
    List<Loan> credits = new ArrayList<>();
    List<DebitCard> cards = new ArrayList<>();


}
