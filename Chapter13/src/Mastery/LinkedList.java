
/*
Program: linked list    Last Date of this Revision: January 14, 2026

Purpose: An application that uses nested for loops to output a table that displays
         numbers in multiples of ten.

Author: Hamza ismael
School: CHHS
Course: Computer Programming 30
*/

package Mastery;

public class LinkedList
{
    private Node firstNode;

    public LinkedList()
    {
        firstNode = null;
    }

    public void addAtFront(String value)
    {
        Node tempNode = new Node(value);
        tempNode.setNext(firstNode);
        firstNode = tempNode;
    }

    public void addAtEnd(String value)
    {
        Node freshNode = new Node(value);

        if (firstNode == null)
        {
            firstNode = freshNode;
            return;
        }

        Node walker = firstNode;
        while (walker.getNext() != null)
        {
            walker = walker.getNext();
        }
        walker.setNext(freshNode);
    }

    public void remove(String target)
    {
        if (firstNode == null) return;

        if (firstNode.getData().equals(target))
        {
            firstNode = firstNode.getNext();
            return;
        }

        Node beforeTarget = firstNode;
        Node targetNode = firstNode.getNext();

        while (targetNode != null)
        {
            if (targetNode.getData().equals(target))
            {
                beforeTarget.setNext(targetNode.getNext());
                return;
            }
            beforeTarget = targetNode;
            targetNode = targetNode.getNext();
        }
    }

    public int getSize()
    {
        Node iterator = firstNode;
        int total = 0;

        for (; iterator != null; iterator = iterator.getNext())
        {
            total++;
        }
        return total;
    }

    @Override
    public String toString()
    {
        if (firstNode == null)
        {
            return "List is empty.";
        }

        StringBuilder result = new StringBuilder();
        Node printer = firstNode;

        while (printer != null)
        {
            result.append(printer.getData()).append("\n");
            printer = printer.getNext();
        }

        return result.toString();
    }

    public void clear()
    {
        firstNode = null;
    }
}

/* Screen Dump
 *
--- Linked List Menu ---
1. Add at front
2. Add at end
3. Remove item
0. Exit
Enter choice: 1
Enter value to add at front: 345
Added at front: 345
Current list:
345

--- Linked List Menu ---
1. Add at front
2. Add at end
3. Remove item
0. Exit
Enter choice: 1
Enter value to add at front: 4567
Added at front: 4567
Current list:
4567
345

--- Linked List Menu ---
1. Add at front
2. Add at end
3. Remove item
0. Exit
Enter choice: 2
Enter value to add at end: 632424334
Added at end: 632424334
Current list:
4567
345
632424334

--- Linked List Menu ---
1. Add at front
2. Add at end
3. Remove item
0. Exit
Enter choice: 3
Enter value to remove: 345
Removed: 345
Current list:
4567
632424334

--- Linked List Menu ---
1. Add at front
2. Add at end
3. Remove item
0. Exit
Enter choice: 0
Goodbye!

 */

