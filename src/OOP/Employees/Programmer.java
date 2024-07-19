package OOP.Employees;

public class Programmer extends Employee {
    public Programmer(String name, Integer serial, Integer salary) {
        super(name, serial, salary);
    }

    @Override
    public double calcBonus() {
        return getSalary() * 1.5;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + getName() + '\'' +
                ", serial=" + getSerial() +
                ", salary=" + getSalary()+
                '}';
    }
}
