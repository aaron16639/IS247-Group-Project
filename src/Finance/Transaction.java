package Finance;

import java.time.LocalDate;

/**
 * Abstract base class for all financial transactions in the ERP system.
 * All transaction types (Invoice, Payroll, CustomerPayment) extend this class.
 */
public abstract class Transaction {

    private String transactionId;
    private double amount;
    private LocalDate date;
    private String description;

    /**
     * @param transactionId  unique identifier
     * @param amount         monetary value
     * @param date           date created
     * @param description    brief description
     */
    public Transaction(String transactionId, double amount, LocalDate date, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setDescription(String description) { this.description = description; }

    /** @return formatted string with ID, amount, date, and description */
    public String getDetails() {
        return "ID: " + transactionId + " | Amount: $" + amount + " | Date: " + date + " | " + description;
    }

    /** Processes this transaction. Each subclass defines its own logic. */
    public abstract void processTransaction();
}