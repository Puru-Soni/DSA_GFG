package Linked_list;

// INTRODUCTION:
/* 
    In doubly linked list, we have reference of next node as well as reference of previous node, together.
    Hence previous of first node is null. 
    Next of last node is null.
*/

// SINGLY vs DOUBLY LINKED LIST:
/* 
    PROS:
        Traversed in both the drections.
        We can Insert/delete a given node in O(1) time.
        Insert/Delete from both the end is O(1) time.

    CONS:
        Extra space for prev.
        Code becomes more complex.
*/
class Node {
    int data; // datatype can we anything;
    Node next; // it has reference of self type; Linked List is an exmaple of self referential structure;
    Node prev; // !for doubly linked list!

    Node(int x){
        data = x;
    }
}

// Main class:
public class _2_doubly {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        //head ref
        head.next = temp1;
        //temp1 ref
        temp1.prev = head;
        temp1.next = temp2;
        //temp2 ref
        temp2.prev = temp1;
        
     
//  INSERT a new node at the beginning:
        head = insertAtBegin(head, 0);
        printList(head);

        System.out.println("-----------");
// INSERT a new node at the End:
        head = insertAtEnd(head, 40);
        printList(head);
    
        System.out.println("-----------");
// REVERSE A DOUBLTY LINKED LIST:
        head = reversList(head);
        printList(head);

        System.out.println("-----------");
// DELETE head of the Doubly linked list: theta(n)
        head = delHead(head);
        printList(head);

        System.out.println("-----------");
// DELETE the last node of list: theta(n)
        head = delLast(head);
        printList(head);

        System.err.println("-----------");
    }

// Print function:
    static void printList(Node head){
        Node curr = head;
        while( curr != null ){
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }

//Insert at begin:
    static Node insertAtBegin(Node head, int x){
        Node temp = new Node(0);
        if(head == null ) return temp;
        temp.next = head;
        head.prev = temp;
        return temp;
    }

//Insert at the End:
    static Node insertAtEnd(Node head, int x){
        Node temp = new Node(x);
        if( head == null) return temp;

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

// Reverse a doubly linked list:
    static Node reversList(Node head){
        if(head == null || head.next == null ) return head;
        Node curr = head;
        Node temp = null;
        while( curr != null ){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }return temp.prev; 
    }

// DELETE HEAD NODE:
    static Node delHead(Node head){
        if( head == null || head.next == null ) return null;
        
        head.next.prev = null;
        return head.next;
    }

// DELETE LAST NODE:
    static Node delLast(Node head){
        if( head == null || head.next == null ) return null;
        Node curr = head.next;
        while(curr.next != null ){
            curr = curr.next;
        }curr.prev.next = null;
        return head;
    }
}
