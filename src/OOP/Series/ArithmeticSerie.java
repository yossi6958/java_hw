package OOP.Series;

public class ArithmeticSerie extends Serie {

    public ArithmeticSerie(int a1, int jump) {
        super(a1, jump);
    }

    @Override
    public int getElement(int index) {
        return getA1() + (index - 1) * getJump();
    }

    @Override
    public int getSum(int n) {
        return n * (getA1() + this.getElement(n)) / 2;
    }

    @Override
    public String toString() {
        return "ArithmeticSerie{" +
                "a1=" + getA1() +
                ", jump=" + getJump() +
                '}';
    }
}
