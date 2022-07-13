import java.io.Serializable;
import java.util.Date;

public class Loan implements Serializable {
    private Date application;
    private int interest;
    private int month;
    private int monthlyPayments;

    public Loan(Date application, int interest, int month, int monthlyPayments) {
        this.application = application;
        this.interest = interest;
        this.month = month;
        this.monthlyPayments = monthlyPayments;
    }


    public Date getApplication() {
        return application;
    }

    public int getInterest() {
        return interest;
    }

    public int getMonth() {
        return month;
    }

    public int getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setApplication(Date application) {
        this.application = application;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setMonthlyPayments(int monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "application=" + application +
                ", interest=" + interest +
                ", month=" + month +
                ", monthlyPayments=" + monthlyPayments +
                '}';
    }
}
