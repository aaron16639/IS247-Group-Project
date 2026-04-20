package Finance;

import java.time.LocalDate;

public abstract class Transaction {

    private String transactionId;
    private double amount;
    private LocalDate date;
    private String description;

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

    public String getDetails() {
        return "ID: " + transactionId + " | Amount: $" + amount + " | Date: " + date + " | " + description;
    }

    public abstract void processTransaction();
}