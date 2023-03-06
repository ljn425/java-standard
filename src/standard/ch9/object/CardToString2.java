package standard.ch9.object;

public class CardToString2 {

    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card("HEART", 10);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
    }

    static class Card {
        String kind;
        int number;

        public Card() {
            this("SPADE", 1);
        }

        public Card(String kind, int number) {
            this.kind = kind;
            this.number = number;
        }

        @Override
        public String toString() {
            return "kind:"+kind+", number:"+number;
        }
    }
}
