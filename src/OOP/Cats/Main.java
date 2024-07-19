package OOP.Cats;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Josh", 15, "Green");
        StreetCat streetCat = new StreetCat("Rubi", 5, "Orange", 13);
        SiamiCat siamiCat = new SiamiCat("Garfield", 150, "Black", "Cheese");
        System.out.println(cat);
        System.out.println(streetCat);
        System.out.println(siamiCat);

    }
}
