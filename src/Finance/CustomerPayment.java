package Finance;

import java.time.LocalDate;

public class CustomerPayment extends Transaction {

    private String customerId;

    public CustomerPayment(String transactionId, double amount, LocalDate date, String customerId) {
        super(transactionId, amount, date, "Payment received from customer " + customerId);
        this.customerId = customerId;
    }

    public String getCustomerId() { return customerId; }

    @Override
    public void processTransaction() {
        System.out.println("Payment received from customer " + customerId +
                " | Amount: $" + getAmount() + " | Date: " + getDate());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Customer ID: " + customerId;
    }
}