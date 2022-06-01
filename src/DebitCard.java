import java.util.Date;

public class DebitCard extends Bank {
    private double avialiableBalance;
    private String CardNumber;
    private Date expireDate = new Date();
    private int cvv;

    public double getAvialiableBalance() {
        return avialiableBalance;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setAvialiableBalance(double avialiableBalance) {
        this.avialiableBalance = avialiableBalance;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public String toString(){
        System.out.println("Card number is: " + CardNumber);
        System.out.println("Avialiable balance is: " + avialiableBalance);
        System.out.println("Expire date is: " + expireDate);
        System.out.println("Cvv is: " + cvv);
        return toString();
    }
}

