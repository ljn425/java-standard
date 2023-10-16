package standard.ch11.HashSet;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx4 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));

        System.out.println(set);

        Person david = new Person("David", 10);
        Person david2 = new Person("David", 10);
        System.out.println(david.hashCode());
        System.out.println(david2.hashCode());
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Person) {
                Person tmp = (Person) obj;
                return name.equals(tmp.name) && age == tmp.age;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
