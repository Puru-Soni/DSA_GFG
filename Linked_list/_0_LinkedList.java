package Linked_list;

// The problems that programmers face with Array Data Structures and the need of coming up with Linked List as the alternative
/*  0 
    Problem with array:
        Array is sequential data str, stores item in continguous memeory allocation.
        An array is a collection of elements of a similar data type.   
        It has static memory, but it can be solved by dynamic sized array, 
        But there are Operation like insertion, insert in middle (move elements and modify), deletion in array is costly.
        In worst case it is more time consuming, high time complexity O(n).
        Implementation with stack and queue or deqeue is complex in array.
*/
// Example Round robin Scheduling, in queue, Merge sort process.
/* 
    Linked list:
        Linked list is also sequential data str (linear ds).
        Linked list elements can be stored anywhere in the memory or randomly stored, It has Dynamic memory.
        A linked list is a collection of objects known as a node where node consists of two parts, data and address. 
        Implementation with stack and queue or deqeue is very simple in array.
*/

/*  1
    Intro to linked List:
        The idea is to not store items in contiguous location, so insertion, deletion, searching, sorting, etc becomes faster.
        and also efficient operation at the middle also.
        Every node stores reference or pointer of each other.
        No pre-allocation of extra memeory / space, is required.

    Linked lists can be of multiple types: 
        - singly ( store pointer to next node only )
        - doubly ( store pointer of both prev and next node )
        - circular linked list. ( Singly type but, the last node in not null it "point next to head" )
*/

/*  2
    Create Simply Linkded List in java:
        A linked list is a linear data structure that includes a series of connected nodes. 
        Here, each node stores the data and the address of the next node
        And next of last node is always Null, which indicate that nothing after it.

        Items are stored in heap area: it is part of area where we store dynamically allocated objects
        In java, all non-primitive (Linked-List) types are dynamically allocated.      
*/

// Representation of Linked List:

// Class to represent node, a node has a data and refrence to next node.
class Node {
    int data; // datatype can we anything;
    Node next; // it has reference of self type; Linked List is an exmaple of self referential structure;
    Node prev; // !for doubly linked list!

    // Constructor
    Node(int x){
        data = x;
        next = null; // optinal, if we do not initiallize a member it will be a null by default.
    }
}

public class _0_LinkedList {
    public static void main(String[] args) {
        Node head = new Node(10); // Created three objects.
        // Node temp1 = new Node(20);
        // Node temp2 = new Node(30);      
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);                         

// TRAVERSING ON SINGLY LINKED LIST:

/* 
    Traversing a linked list:
        We are given head of list and need traversal of a linked list from head to last node.
        // O(n)
*/
        Node curr = head;
        // using loop:

        // while( curr != null ){
        //     System.out.println(curr.data + " ");
        //     curr = curr.next;
        // }
        
/*
    Traversing a linked list using recursion:
        We need to print the list using recursion method:
        // O(n)
*/
        printList(curr); // recurion
    }
    // Recursive call uses O(n) space, but iterator does not so iterative is better.
    public static void printList(Node head){
        if( head == null ) return;
        for(Node curr = head; curr != null; curr = curr.next)
            System.out.println(curr.data + " ");
    }
}