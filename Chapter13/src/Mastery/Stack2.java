
/*
Program: Simple stack         Last Date of this Revision: January 14, 2026

Purpose: An application that uses a stack and nested for loops to output
         a table that displays numbers in multiples of ten.

Author:  Hamza Ismael
School: CHHS
Course: Computer Programming 30
*/

package Mastery;

public class Stack2
{
    private int top;
    private Object[] data;

    public Stack2(int maxItems)
    {
        top = -1;
        data = new Object[maxItems];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public int size()
    {
        return isEmpty() ? 0 : (top + 1);
    }

    public void makeEmpty()
    {
        top = -1;
    }

    public void push(Object item)
    {
        if (top < data.length - 1)
        {
            data[++top] = item;
        }
        else
        {
            System.out.println("Stack is full. Cannot push.");
        }
    }

    public Object pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty. Nothing to pop.");
            return null;
        }
        return data[top--];
    }

    public Object top()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty. No top item.");
            return null;
        }
        return data[top];
    }

    // NEW: allow tester to see element at a given index
    public Object getAt(int index)
    {
        return data[index];
    }

    // NEW: allow tester to know max capacity
    public int capacity()
    {
        return data.length;
    }
}

/* Screen Dump
Enter stack capacity: 3

--- Stack Menu ---
1. Push
2. Pop
0. Exit
Enter choice: 1
Enter item to push: 345
Pushed: 345
Stack (top → bottom): [345]

--- Stack Menu ---
1. Push
2. Pop
0. Exit
Enter choice: 2
Popped: 345
Stack (top → bottom): []

--- Stack Menu ---
1. Push
2. Pop
0. Exit
Enter choice: 
 */





