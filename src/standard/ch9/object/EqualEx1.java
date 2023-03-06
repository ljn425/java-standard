package standard.ch9.object;

public class EqualEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        printValue(v1, v2);

        if (v1.equals(v2))
            System.out.println("v1과 v2는 같습니다.");
        else
            System.out.println("v1과 v2는 다릅니다.");

        v2 = v1;

        printValue(v1, v2);

        if (v1.equals(v2))
            System.out.println("v1과 v2는 같습니다.");
        else
            System.out.println("v1과 v2는 다릅니다.");
    }

    private static void printValue(Value v1, Value v2) {
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
    }


    static class Value {
        int value;

        Value(int value) {
            this.value = value;
        }
    }
}


