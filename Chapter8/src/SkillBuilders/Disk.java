package SkillBuilders;

public class Disk {

    private double thickness;   // in inches
    private double diameter;    // in inches

    public Disk(double thickness, double diameter) {
        this.thickness = thickness;
        this.diameter = diameter;
    }

    public double getThickness() {
        return thickness;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Disk)) return false;
        Disk other = (Disk) obj;
        return thickness == other.thickness &&
               diameter == other.diameter;
    }

    @Override
    public String toString() {
        return "Disk: thickness = " + thickness + " in, diameter = " + diameter + " in";
    }
}