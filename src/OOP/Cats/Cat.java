package OOP.Cats;

public class Cat {
    private String name;
    private Integer len;

    public Cat(String name, Integer len, String color) {
        this.name = name;
        this.len = len;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + this.name + '\'' +
                ", len=" + this.len +
                ", color='" + this.color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;


}
