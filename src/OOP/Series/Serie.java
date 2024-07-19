package OOP.Series;

public abstract class Serie {
    private int a1;
    private int jump;

    public Serie(int a1, int jump) {
        this.a1 = a1;
        this.jump = jump;
    }

    public abstract int getElement(int index);

    public abstract int getSum(int n);


    @Override
    public String toString() {
        return "Serie{" +
                "a1=" + a1 +
                ", jump=" + jump +
                '}';
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }
}
