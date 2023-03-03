package standard.ch12.enums;

enum Direction {
    EAST,
    SOUTH,
    WEST,
    NORTH
}

public class EnumEx1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Direction.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1==d2 ?" + (d1==d2));
        System.out.println("d1==d3 ?" + (d1==d3));
        System.out.println("d1.equals(d3) ?" + d1.equals(d3));

//        System.out.println("d2 > d3 ? " + (d1 > d3)); // enum 에서 부등호(>, < 등) 사용시 에러
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

        switch (d1) {
            case EAST: // Direction.EAST 라고 쓸 수 없다.
                System.out.println("The direction is EAST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH.");
                break;
            case WEST:
                System.out.println("The direction is WEST.");
                break;
            case NORTH:
                System.out.println("The direction is NORTH.");
                break;
            default:
                System.out.println("Invalid direction.");
                break;
        }

        Direction[] directions = Direction.values();

        for (Direction direction : directions) {
            System.out.printf("%s=%d%n", direction.name(), direction.ordinal());
        }

    }
}
