package SkillBuilders;

public class RectangleApp {

    public static void main(String[] args) {

        System.out.println("=== TEST 1: Constructors ===");
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4, 5);
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("\n=== TEST 2: Area Formula ===");
        Rectangle.displayAreaFormula();

        System.out.println("\n=== TEST 3: equals() ===");
        Rectangle r3 = new Rectangle(4, 5);
        System.out.println("r2 equals r3? " + r2.equals(r3));   // true

        System.out.println("\n=== TEST 4: Comparable<Rectangle> (length/width) ===");
        Rectangle a = new Rectangle(3, 7);
        Rectangle b = new Rectangle(4, 2);
        System.out.println("Compare a to b: " + a.compareTo(b)); // -1 (3 < 4)

        System.out.println("\n=== TEST 5: ComparableArea ===");
        Rectangle x = new Rectangle(4, 4);  // area 16
        Rectangle y = new Rectangle(8, 2);  // area 16
        System.out.println("Compare areas x to y: " + x.compareToArea(y)); // 0

        Rectangle z = new Rectangle(2, 3);  // area 6
        System.out.println("Compare areas z to x: " + z.compareToArea(x)); // -1
    }
}
