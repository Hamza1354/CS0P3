package SkillBuilders;

public class Rectangle implements Comparable<Rectangle>, ComparableArea {

    private double length;
    private double width;

    // -----------------------------
    // Overloaded Constructors
    // -----------------------------
    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // -----------------------------
    // Getters and Setters
    // -----------------------------
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // -----------------------------
    // Area & Perimeter
    // -----------------------------
    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    // -----------------------------
    // Class Method
    // -----------------------------
    public static void displayAreaFormula() {
        System.out.println("Area = length × width");
    }

    // -----------------------------
    // equals() Override
    // -----------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return this.length == other.length && this.width == other.width;
        }
        return false;
    }

    // -----------------------------
    // toString() Override
    // -----------------------------
    @Override
    public String toString() {
        return "Rectangle [Length=" + length +
               ", Width=" + width +
               ", Area=" + getArea() +
               ", Perimeter=" + getPerimeter() + "]";
    }

    // -----------------------------
    // Comparable<Rectangle>
    // Compare by length, then width
    // -----------------------------
    @Override
    public int compareTo(Rectangle other) {
        if (this.length > other.length) return 1;
        if (this.length < other.length) return -1;

        // length equal → compare width
        return Double.compare(this.width, other.width);
    }

    // -----------------------------
    // ComparableArea
    // Compare by area
    // -----------------------------
    @Override
    public int compareToArea(Rectangle other) {
        double thisArea = this.getArea();
        double thatArea = other.getArea();

        if (thisArea == thatArea) return 0;
        if (thisArea < thatArea) return -1;
        return 1;
    }
}