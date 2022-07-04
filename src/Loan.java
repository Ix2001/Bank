import java.util.Date;

public class Loan extends Bank {
    private Date application;
    private double interest;
    private int month;
    private double monthlyPayments;

    public Loan(Date application, double interest, int month, double monthlyPayments) {
        this.application = application;
        this.interest = interest;
        this.month = month;
        this.monthlyPayments = monthlyPayments;
    }


    public Date getApplication() {
        return application;
    }

    public double getInterest() {
        return interest;
    }

    public int getMonth() {
        return month;
    }

    public double getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setApplication(Date application) {
        this.application = application;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setMonthlyPayments(double monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }
    public String toString(){
        System.out.println("Credite rate is: " + interest);
        System.out.println("Loan terms: " + month);
        System.out.println("Monthly Payments: " + monthlyPayments);
        return toString();
    }
}
