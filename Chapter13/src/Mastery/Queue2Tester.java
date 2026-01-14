package Mastery;

import java.util.Scanner;

public class Queue2Tester
{
    // Show the whole array, from index 0 to maxsize - 1
    public static void showArray(Queue2 q)
    {
        int cap = q.capacity();
        System.out.print("Queue array: [");
        for (int i = 0; i < cap; i++)
        {
            System.out.print(q.getAt(i));
            if (i < cap - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter queue capacity: ");
        int cap = in.nextInt();
        in.nextLine(); // clear newline

        Queue2 q2 = new Queue2(cap);

        int choice;
        do
        {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine(); // clear newline

            switch (choice)
            {
                case 1: // Enqueue
                    if (q2.size() == cap)
                    {
                        System.out.println("Queue is full. Cannot enqueue.");
                    }
                    else
                    {
                        System.out.print("Enter item to enqueue: ");
                        String item = in.nextLine();
                        q2.enqueue(item);
                        System.out.println("Enqueued: " + item);
                    }
                    showArray(q2);
                    break;

                case 2: // Dequeue
                    if (q2.isEmpty())
                    {
                        System.out.println("Queue is empty. Nothing to dequeue.");
                    }
                    else
                    {
                        Object removed = q2.dequeue();
                        System.out.println("Dequeued: " + removed);
                    }
                    showArray(q2);
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
