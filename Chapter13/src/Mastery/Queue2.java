/*
Program: Queue  Last Date of this Revision: January 14, 2026

Purpose: An application that uses nested for loops to output a table that displays
         numbers in multiples of ten.

Author: Hamza ismael
School: CHHS
Course: Computer Programming 30
*/

package Mastery;

public class Queue2
{
    private int front, rear, maxsize;
    private Object[] data;

    public Queue2(int maxItems)
    {
        maxsize = maxItems;
        data = new Object[maxsize];
        front = rear = -1;
    }

    public boolean isEmpty()
    {
        return front == -1;
    }

    public int size()
    {
        if (isEmpty()) return 0;

        if (rear >= front)
            return rear - front + 1;
        else
            return maxsize - (front - rear - 1);
    }

    public void makeEmpty()
    {
        front = rear = -1;
    }

    public void enqueue(Object item)
    {
        if (isEmpty())
        {
            front = rear = 0;
            data[rear] = item;
        }
        else
        {
            rear = (rear + 1) % maxsize;
            data[rear] = item;
        }
    }

    public Object dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return null;
        }

        Object item = data[front];

        if (front == rear)
        {
            makeEmpty();
        }
        else
        {
            front = (front + 1) % maxsize;
        }
        return item;
    }

    public Object front()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty. No front item.");
            return null;
        }
        return data[front];
    }

    // Helper to see array slot at index
    public Object getAt(int index)
    {
        return data[index];
    }

    // Helper to get capacity
    public int capacity()
    {
        return maxsize;
    }
}

/* Screen Dump
Enter queue capacity: 3

--- Queue Menu ---
1. Enqueue
2. Dequeue
0. Exit
Enter choice: 1
Enter item to enqueue: 3
Enqueued: 3
Queue array: [3, null, null]

--- Queue Menu ---
1. Enqueue
2. Dequeue
0. Exit
Enter choice: 2
Dequeued: 3
Queue array: [3, null, null]

--- Queue Menu ---
1. Enqueue
2. Dequeue
0. Exit
Enter choice: 1
Enter item to enqueue: 2
Enqueued: 2
Queue array: [2, null, null]

--- Queue Menu ---
1. Enqueue
2. Dequeue
0. Exit
Enter choice: 1
Enter item to enqueue: 34
Enqueued: 34
Queue array: [2, 34, null]

--- Queue Menu ---
1. Enqueue
2. Dequeue
0. Exit
Enter choice: 

*/
