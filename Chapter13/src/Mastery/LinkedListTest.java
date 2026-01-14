package Mastery;

import java.util.Scanner;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int choice;
        do
        {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Add at front");
            System.out.println("2. Add at end");
            System.out.println("3. Remove item");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            while (!in.hasNextInt())
            {
                System.out.print("Please enter a number: ");
                in.next();
            }
            choice = in.nextInt();
            in.nextLine(); // clear newline

            switch (choice)
            {
                case 1: // Add at front
                    System.out.print("Enter value to add at front: ");
                    String frontValue = in.nextLine();
                    list.addAtFront(frontValue);
                    System.out.println("Added at front: " + frontValue);
                    System.out.println("Current list:");
                    System.out.print(list); // shows process
                    break;

                case 2: // Add at end
                    System.out.print("Enter value to add at end: ");
                    String endValue = in.nextLine();
                    list.addAtEnd(endValue);
                    System.out.println("Added at end: " + endValue);
                    System.out.println("Current list:");
                    System.out.print(list); // shows process
                    break;

                case 3: // Remove item
                    System.out.print("Enter value to remove: ");
                    String target = in.nextLine();
                    int before = list.getSize();
                    list.remove(target);
                    int after = list.getSize();
                    if (before == after)
                    {
                        System.out.println("Value not found in list.");
                    }
                    else
                    {
                        System.out.println("Removed: " + target);
                    }
                    System.out.println("Current list:");
                    System.out.print(list); // shows process
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }

        } while (choice != 0);

        in.close();
    }
}
