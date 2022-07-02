import java.util.Date;

public class DebitCard {
    private double avialiableBalance;
    private long CardNumber;
    private String expireDate;
    private int cvv;

    public DebitCard(double avialiableBalance, long cardNumber, String expireDate, int cvv) {
        this.avialiableBalance = avialiableBalance;
        CardNumber = cardNumber;
        this.expireDate = expireDate;
        this.cvv = cvv;
    }

    public double getAvialiableBalance() {
        return avialiableBalance;
    }

    public long getCardNumber() {
        return CardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setAvialiableBalance(double avialiableBalance) {
        this.avialiableBalance = avialiableBalance;
    }

    public void setCardNumber(long cardNumber) {
        CardNumber = cardNumber;
    }

    public void setExpireDate(String expireDate) {
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

