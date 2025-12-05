package SkillBuilders;

public class PuckPart1of2 extends Disk {

    private double weight;   // ounces
    private boolean standard;
    private boolean youth;

    public PuckPart1of2(double weight) {
        super(1.0, 3.0);   // official hockey puck dimensions

        this.weight = weight;

        // Determine division based on weight
        if (weight >= 5.0 && weight <= 5.5) {
            standard = true;
            youth = false;
        } 
        else if (weight >= 4.0 && weight <= 4.5) {
            youth = true;
            standard = false;
        }
        else {
            // Not official weight ranges
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
        return "Unknown";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        if (!(obj instanceof PuckPart1of2)) return false;

        PuckPart1of2 other = (PuckPart1of2) obj;

        return this.weight == other.weight &&
               this.standard == other.standard &&
               this.youth == other.youth;
    }

    @Override
    public String toString() {
        return "Puck: weight = " + weight + " oz, division = " + getDivision() +
               ", thickness = " + getThickness() + " in, diameter = " + getDiameter() + " in";
    }
}