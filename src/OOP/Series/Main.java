package OOP.Series;

public class Main {
    public static void main(String[] args) {
        ArithmeticSerie arithmeticSerie = new ArithmeticSerie(1, 5);
        GeometricSerie geometricSerie = new GeometricSerie(1, 5);
        System.out.println("Sum a: " + arithmeticSerie.getSum(3));
        System.out.println("At Index: " + arithmeticSerie.getElement(2));
        System.out.println("Sum b: " + geometricSerie.getSum(3));
        System.out.println("At Index: " + geometricSerie.getElement(1));
    }
}
