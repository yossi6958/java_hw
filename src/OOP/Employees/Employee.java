package OOP.Employees;

public class Employee {
    private String name;
    private int serial;
    private double salary;

    public Employee(String name, Integer serial, Integer salary) {
        if (serial < 1000) {
            System.out.println("Invalid Serial!");
            return;
        }
        this.name = name;
        this.serial = serial;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", serial=" + serial +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calcBonus() {
        return 0;
    }
}
