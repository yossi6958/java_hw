package OOP.Cats;

public class StreetCat extends Cat {
    private Integer numOfFights;

    public StreetCat(String name, Integer len, String color, Integer numOfFights) {
        super(name, len, color);
        this.numOfFights = numOfFights;
    }

    @Override
    public String toString() {
        return "StreetCat{" +
                "name='" + getName() + '\'' +
                ", len=" + getLen() +
                ", color='" + getColor() + '\'' +
                ", numOfFights=" + numOfFights +
                '}';
    }

    public Integer getNumOfFights() {
        return numOfFights;
    }

    public void setNumOfFights(Integer numOfFights) {
        this.numOfFights = numOfFights;
    }
}
