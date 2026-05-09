// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int maxHoursPerWeek;
    private int PTODays;

    public PartTimeEmployee(String employeeID, String name, String department,
                            double hourlyRate, int maxHoursPerWeek, int PTODays) {
        super(employeeID, name, department);
        this.hourlyRate = hourlyRate;
        this.maxHoursPerWeek = maxHoursPerWeek;
        this.PTODays = PTODays;
    }

    public double getHourlyRate() { return hourlyRate; }
    public int getMaxHoursPerWeek() { return maxHoursPerWeek; }
    public int getPTODays() { return PTODays; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setMaxHoursPerWeek(int maxHoursPerWeek) { this.maxHoursPerWeek = maxHoursPerWeek; }
    public void setPTODays(int PTODays) { this.PTODays = PTODays; }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Type: Part-Time");
        System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
        System.out.println("Max Hours/Week: " + maxHoursPerWeek);
        System.out.println("PTO Days: " + PTODays);
    }

    @Override
    public double calculatePay() {
        return hourlyRate * maxHoursPerWeek * 4;
    }

    @Override
    public String toString() {
        return "[" + getEmployeeID() + "] " + getName() + " - Part-Time | Dept: " + getDepartment()
                + String.format(" | Est. Monthly Pay: $%.2f", calculatePay());
    }
}
