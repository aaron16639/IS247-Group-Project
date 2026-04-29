package Finance;

import java.time.LocalDate;

public class Payroll extends Transaction {

    private String employeeId;
    private double hoursWorked;
    private double hourlyRate;
    private static final double TAX = 0.20;

    public Payroll(String transactionId, LocalDate date, String employeeId,
                   double hoursWorked, double hourlyRate) {
        super(transactionId, hoursWorked * hourlyRate, date, "Payroll for employee " + employeeId);
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public String getEmployeeId() { return employeeId; }
    public double getHoursWorked() { return hoursWorked; }
    public double getHourlyRate() { return hourlyRate; }
    public double getNetPay() { return getAmount() * (1 - TAX); }

    @Override
    public void processTransaction() {
        System.out.println("Processing payroll for employee " + employeeId);
        System.out.printf("  Gross Pay : $%.2f (%s hrs @ $%.2f/hr)%n", getAmount(), hoursWorked, hourlyRate);
        System.out.printf("  Tax (%.0f%%): -$%.2f%n", TAX * 100, getAmount() * TAX);
        System.out.printf("  Net Pay   : $%.2f%n", getNetPay());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Employee: " + employeeId +
                " | Hours: " + hoursWorked + " | Rate: $" + hourlyRate +
                " | Net: $" + String.format("%.2f", getNetPay());
    }
}