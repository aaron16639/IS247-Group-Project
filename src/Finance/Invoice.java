package Finance;

import java.time.LocalDate;

/**
 * Represents a vendor invoice in the ERP finance system.
 * Tracks money owed to external vendors. When processed, reports
 * whether the invoice is paid, overdue, or still pending.
 */
public class Invoice extends Transaction {

    private String vendor;
    private LocalDate dueDate;
    private boolean paid;

    /**
     * @param transactionId  unique identifier
     * @param amount         amount owed to the vendor
     * @param date           date the invoice was created
     * @param description    brief description
     * @param vendorName     name of the vendor to be paid
     * @param dueDate        date by which payment must be made
     */
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

    /** @param paid the paid status to set */
    public void markAsPaid(boolean paid) { this.paid = true; }

    /** Checks payment status and prints whether invoice is paid, overdue, or pending. */
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

    /** @return detailed string including vendor, due date, and paid status */
    @Override
    public String getDetails() {
        return super.getDetails() + " | Vendor: " + vendor + " | Due: " + dueDate + " | Paid: " + isPaid();
    }
}