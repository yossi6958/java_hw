package OOP.Employees;

public class Secretary extends Employee {
    private int wordsPerMinute;

    public Secretary(String name, Integer serial, Integer salary, Integer wordsPerMinute) {
        super(name, serial, salary);
        this.wordsPerMinute = wordsPerMinute;
    }

    public int getWordsPerMinute() {
        return wordsPerMinute;
    }

    public void setWordsPerMinute(int wordsPerMinute) {
        this.wordsPerMinute = wordsPerMinute;
    }

    @Override
    public double calcBonus() {
        return 500;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "name='" + getName() + '\'' +
                ", serial=" + getSerial() +
                ", salary=" + getSalary() +
                ", wordsPerMinute=" + wordsPerMinute +
                '}';
    }
}
