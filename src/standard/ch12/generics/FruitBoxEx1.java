package standard.ch12.generics;


import standard.ch12.generics.fruit.Apple;
import standard.ch12.generics.fruit.Fruit;
import standard.ch12.generics.fruit.Toy;

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox = new Box<>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());

        toyBox.add(new Toy());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("toyBox = " + toyBox);

    }

}

