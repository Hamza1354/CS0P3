package SkillBuilders;

public class PuckPart2of2 extends Disk implements Comparable<PuckPart2of2> {

    private double weight;   // ounces
    private boolean standard;
    private boolean youth;

    /**
     * Constructor
     */
    public PuckPart2of2(double weight) {
        // Puck dimensions: 1" thick, 3" diameter
        super(1.0, 3.0);
        this.weight = weight;

        // Determine division based on weight
        if (weight >= 5.0 && weight <= 5.5) {
            standard = true;
            youth = false;
        } else if (weight >= 4.0 && weight <= 4.5) {
            youth = true;
            standard = false;
        } else {
            standard = false;
            youth = false;
        }
    }

    public double getWeight() {
        return weight;
    }

    public String getDivision() {
        if (standard) return "Standard";
        if (youth) return "Youth";
        return "Not Regulation Weight";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PuckPart2of2) {
            PuckPart2of2 other = (PuckPart2of2) obj;
            return this.weight == other.weight;
        }
        return false;
    }

    @Override
    public int compareTo(PuckPart2of2 other) {
        // compare based on weight
        if (this.weight < other.weight) return -1;
        if (this.weight > other.weight) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Puck: weight = " + weight + " oz, division = " + getDivision() +
               ", thickness = " + getThickness() + " in, diameter = " + getDiameter() + " in";
    }
}
