package SkillBuilders;

import java.util.Scanner;

public class HockeyAppPart2of2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== Hockey Puck Tester - Part 2 ===");

        System.out.print("Enter weight of puck 1 (oz): ");
        double w1 = input.nextDouble();

        System.out.print("Enter weight of puck 2 (oz): ");
        double w2 = input.nextDouble();

        PuckPart2of2 puck1 = new PuckPart2of2(w1);
        PuckPart2of2 puck2 = new PuckPart2of2(w2);

        // Show puck info
        System.out.println("\n--- Puck 1 ---");
        System.out.println(puck1);

        System.out.println("\n--- Puck 2 ---");
        System.out.println(puck2);

        // equals()
        System.out.println("\nUsing equals():");
        if (puck1.equals(puck2))
            System.out.println("The pucks are equal in weight.");
        else
            System.out.println("The pucks are NOT equal.");

        // compareTo()
        System.out.println("\nUsing compareTo():");
        int cmp = puck1.compareTo(puck2);

        if (cmp == 0)
            System.out.println("compareTo: Both pucks have the SAME weight.");
        else if (cmp < 0)
            System.out.println("compareTo: Puck 1 is LIGHTER.");
        else
            System.out.println("compareTo: Puck 1 is HEAVIER.");

        input.close();
    }
}
