package OOP.Cats;

public class SiamiCat extends Cat {
    private String food;

    public SiamiCat(String name, Integer len, String color, String food) {
        super(name, len, color);
        this.food = food;
    }

    @Override
    public String toString() {
        return "SiamiCat{" +
                "name='" + getName() + '\'' +
                ", len=" + getLen() +
                ", color='" + getColor() + '\'' +
                ", food='" + food + '\'' +
                '}';
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
