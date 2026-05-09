// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

public class FullTimeEmployee extends Employee {
    private double annualSalary;
    private int PTODays;
    private boolean benefitsEligible;

    public FullTimeEmployee(String employeeID, String name, String department,
                            double annualSalary, int PTODays, boolean benefitsEligible) {
        super(employeeID, name, department);
        this.annualSalary = annualSalary;
        this.PTODays = PTODays;
        this.benefitsEligible = benefitsEligible;
    }

    public double getAnnualSalary() { return annualSalary; }
    public int getPTODays() { return PTODays; }
    public boolean isBenefitsEligible() { return benefitsEligible; }

    public void setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }
    public void setPTODays(int PTODays) { this.PTODays = PTODays; }
    public void setBenefitsEligible(boolean benefitsEligible) { this.benefitsEligible = benefitsEligible; }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Full-Time");
        System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        System.out.println("PTO Days: " + PTODays);
        System.out.println("Benefits Eligible: " + (benefitsEligible ? "Yes" : "No"));
    }

    // Overloaded displayInfo — pass false to hide salary
    public void displayInfo(boolean showSalary) {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Full-Time");
        if (showSalary) {
            System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        }
        System.out.println("PTO Days: " + PTODays);
        System.out.println("Benefits Eligible: " + (benefitsEligible ? "Yes" : "No"));
    }

    @Override
    public double calculatePay() {
        return annualSalary / 12;
    }

    //Overloaded method
    public double calculatePay(int months) {
        return (annualSalary / 12) * months;
    }

    @Override
    public String toString() {
        return "[" + getEmployeeID() + "] " + getName() + " - Full-Time | Dept: " + getDepartment()
                + String.format(" | Monthly Pay: $%.2f", calculatePay());
    }
}
