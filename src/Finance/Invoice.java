package Finance;

//class to handle invoices and their invoice payments

import java.time.LocalDate;

public class Invoice extends Transaction {
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

    @Override
    public void processTransaction() {
        if (isPaid()) {
            System.out.println("Invoice " + getTransactionId() + " has already been paid.");
        } else if (LocalDate.now().isAfter(dueDate)) {
            System.out.println("WARNING: Invoice " + getTransactionId() + " from " + vendor + " is OVERDUE!");
        } else {
            System.out.println("Invoice " + getTransactionId() + " from " + vendor + " is due on " + dueDate + ". Amount: $" + getAmount());
        }
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Vendor: " + vendor + " | Due: " + dueDate + " | Paid: " + isPaid();
    }

}
