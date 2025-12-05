package SkillBuilders;

import java.util.Scanner;

public class HockeyApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== Hockey Puck Tester ===");
        System.out.print("Enter weight of puck 1 (oz): ");
        double w1 = input.nextDouble();

        System.out.print("Enter weight of puck 2 (oz): ");
        double w2 = input.nextDouble();

        // Create pucks
        PuckPart1of2 puck1 = new PuckPart1of2(w1);
        PuckPart1of2 puck2 = new PuckPart1of2(w2);

        // Display puck info
        System.out.println("\n--- Puck 1 Information ---");
        System.out.println(puck1.toString());

        System.out.println("\n--- Puck 2 Information ---");
        System.out.println(puck2.toString());

        // Test equality
        System.out.println("\n--- Comparison ---");
        if (puck1.equals(puck2))
            System.out.println("The pucks are equal.");
        else
            System.out.println("The pucks are NOT equal.");

        System.out.println("\nDivision of Puck 1: " + puck1.getDivision());
        System.out.println("Division of Puck 2: " + puck2.getDivision());

        input.close();
    }
}