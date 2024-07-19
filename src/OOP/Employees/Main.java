package OOP.Employees;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Yossi", 1000, 25000);
        Secretary secretary = new Secretary("Nati", 1200, 23000, 130);
        System.out.println(programmer);
        System.out.println(secretary);
        programmer.setSalary(programmer.getSalary() + programmer.calcBonus());
        secretary.setSalary(secretary.getSalary() + secretary.calcBonus());
        System.out.println(programmer);
        System.out.println(secretary);
    }
}
