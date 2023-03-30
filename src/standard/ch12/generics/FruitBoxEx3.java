package standard.ch12.generics;

import standard.ch12.generics.fruit.Apple;
import standard.ch12.generics.fruit.Fruit;
import standard.ch12.generics.fruit.Grape;

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println("fruitBox " + Juicer.makeJuice(fruitBox));
        System.out.println("Juicer.makeJuice(appleBox) = " + Juicer.makeJuice(appleBox));

    }
}
