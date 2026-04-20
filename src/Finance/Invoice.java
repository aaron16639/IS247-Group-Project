package Finance;

//class to handle invoices and their invoice payments

import java.time.LocalDate;

public abstract class Invoice extends Transaction {
    private String vendor;
    private LocalDate dueDate;
    private boolean paid;

    public Invoice(String transactionId, double amount, LocalDate date, String description,
                   String vendorName, LocalDate dueDate) {
        super(transactionId, amount, date, description);
        this.vendor = vendorName;
        this.dueDate = dueDate;
        this.paid = false;

    }

    public String getVendor() { return vendor; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isPaid() { return paid; }

    public void markAsPaid(boolean paid) { this.paid = true; }

    //still need to write the overrides for process transaction and get details
}
