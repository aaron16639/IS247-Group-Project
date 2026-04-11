// Aaron Saudager
// aaronsaudager@icloud.com

package HumanResources;
public class Employee   {
    private String name;
    private int salary;
    private int PTODays;

    public Employee(String name, int salary, int PTODays) {
        this.name = name;
        this.salary = salary;
        this.PTODays = PTODays;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getPTODays() {
        return PTODays;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void addPTODays(int days) {
        this.PTODays += days;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Salary: $" + salary + ", PTO Days: " + PTODays);
    }
}
