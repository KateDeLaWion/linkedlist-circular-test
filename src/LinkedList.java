import java.util.*;

public class LinkedList {
    // head
    static Node head;


    // Linked list Node
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    // Inserts a new Node at front of the list.
    static public void push(int new_data)
    {
        //Allocate the Node & Put in the data
        Node new_node = new Node(new_data);

        //Make next of new Node as head
        new_node.next = head;

        //Move the head to point to new Node
        head = new_node;
    }

    // Return true if there is a loop ele return false
    static boolean detectLoop(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
//             If we have already has this node
//             in hashmap it means their is a cycle
//              (Because you we encountering the
//               node second time).
            if (s.contains(h))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(h);

            h = h.next;
        }

        return false;
    }


    public static void main(String[] args)
    {

//         Example 1 which is circular
        LinkedList llist = new LinkedList();
        llist.push(3);
        llist.push(50);
        llist.push(10);
        llist.push(25);
        /*Create loop for Example 1 */
        llist.head.next.next.next.next = llist.head;


        //Example 2 which is not circular
//        java.util.LinkedList<String> llist = new java.util.LinkedList<>();
//        llist.add(0,"horse");
//        llist.add(1,"pig");
//        llist.add(2,"sheep");


        if (detectLoop(head))
            System.out.println("Loop is found.  This LinkedList is circular");
        else
            System.out.println("No Loop.  This LinkedList is not circular");
    }
}

