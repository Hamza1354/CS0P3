package Mastery;

import java.util.Scanner;

public class Stack2Tester
{
    // Helper method to show current stack array from top to bottom
    public static void showStack(Stack2 s)
    {
        System.out.print("Stack (top → bottom): [");

        // print only the used part of the array, from top down
        for (int i = s.size() - 1; i >= 0; i--)
        {
            System.out.print(s.getAt(i));
            if (i > 0)
            {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter stack capacity: ");
        int capacity = in.nextInt();
        in.nextLine(); // clear newline

        Stack2 s1 = new Stack2(capacity);

        int choice;
        do
        {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine(); // clear newline

            switch (choice)
            {
                case 1: // Push
                    if (s1.size() == capacity)
                    {
                        System.out.println("Stack is full. Cannot push.");
                    }
                    else
                    {
                        System.out.print("Enter item to push: ");
                        String item = in.nextLine();
                        s1.push(item);
                        System.out.println("Pushed: " + item);
                    }
                    // show array after push
                    showStack(s1);
                    break;

                case 2: // Pop
                    if (s1.isEmpty())
                    {
                        System.out.println("Stack is empty. Nothing to pop.");
                    }
                    else
                    {
                        Object popped = s1.pop();
                        System.out.println("Popped: " + popped);
                    }
                    // show array after pop
                    showStack(s1);
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
