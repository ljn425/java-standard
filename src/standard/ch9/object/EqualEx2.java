package standard.ch9.object;

public class EqualEx2 {

    public static void main(String[] args) {
        Person p1 = new Person(15L);
        Person p2 = new Person(15L);

        if (p1 == p2) {
            System.out.println("p1과 p2는 같은 사람입니다.");
        } else {
            System.out.println("p1과 p2는 다른 사람입니다.");
        }

        if (p1.equals(p2)) {
            System.out.println("p1과 p2는 같은 사람입니다.");
        } else {
            System.out.println("p1과 p2는 다른 사람입니다.");
        }


    }

    static class Person {
        long id;

        public Person(long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj != null && obj instanceof Person) {
                return id == ((Person) obj).id;
            } else {
                return false;
            }
        }

    }
}
