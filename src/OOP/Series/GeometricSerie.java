package OOP.Series;

public class GeometricSerie extends Serie {

    public GeometricSerie(int a1, int jump) {
        super(a1, jump);
    }

    @Override
    public int getElement(int index) {
        return (int) (getA1() * Math.pow(getJump(), index - 1));
    }

    @Override
    public int getSum(int n) {
        if (getJump() == 1) {
            return getA1() * n;
        } else {
            return (int) (getA1() * (1 - Math.pow(getJump(), n)) / (1 - getJump()));
        }
    }

    @Override
    public String toString() {
        return "GeometricSerie{" +
                "a1=" + getA1() +
                ", jump=" + getJump() +
                '}';
    }
}
