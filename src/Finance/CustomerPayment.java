package Finance;

import java.time.LocalDate;

/**
 * Represents an inbound payment received from a customer.
 * Connects the Finance module to the CRM module via customerId,
 * which corresponds to Customer.getCustomerID() in the CRM package.
 */
public class CustomerPayment extends Transaction {

    private String customerId;

    /**
     * @param transactionId  unique identifier
     * @param amount         amount received from the customer
     * @param date           date payment was received
     * @param customerId     corresponds to Customer.getCustomerID() in CRM module
     */
    public CustomerPayment(String transactionId, double amount, LocalDate date, String customerId) {
        super(transactionId, amount, date, "Payment received from customer " + customerId);
        this.customerId = customerId;
    }

    public String getCustomerId() { return customerId; }

    /** Prints a confirmation of the amount received, customer ID, and date. */
    @Override
    public void processTransaction() {
        System.out.println("Payment received from customer " + customerId +
                " | Amount: $" + getAmount() + " | Date: " + getDate());
    }

    /** @return detailed string including customer ID */
    @Override
    public String getDetails() {
        return super.getDetails() + " | Customer ID: " + customerId;
    }
}