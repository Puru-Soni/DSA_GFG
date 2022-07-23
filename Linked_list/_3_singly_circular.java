package Linked_list;

// CIRCULAR LINKED LIST:
/* 
    With a modification, of circular nature,
    next of last node is not null it is rather head of linked list.
    It can be a singly circular or a doubly circular linked list.

    PROS:
        We can traverse the whole linked list form any node.
        Implementation of algo like round robin is possible.
        We can insert in the start and end just by maintaing one tail reference point.

    CONS:
        Implemetation of operation becomes complex
*/

public class _3_singly_circular {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head;

// SINGLY CIRCULAR LINKED LIST:

    // TRAVERSING CIRCULAR LINKED LIST:
        printList(head);

        System.out.println("--------------------");
    // INSERT IN BEGIN:
        // head = insertbegin(head, 40); // O(n)
        head = insertbeginEff(head, 5);  // O(1)
        printList(head);

        System.out.println("--------------------");
    //INSERT at the END:
        // head = insertinEnd(head, 40); // O(n)
        head = insertinEndEff(head, 40); // O(1)
        printList(head);

        System.out.println("--------------------");
    // DELETE IN BEGIN:
        // head = delbegin(head); // O(n)
        head = delbeginEff(head); // O(1)
        printList(head);

        System.out.println("--------------------");
    // DELETE AT END:
        head = delend(head); // O(n)
        printList(head);

        System.out.println("--------------------");
    // DELETE kth node of a circular linked list where k is less than or equal to the number of nodes in the list:
        head = deleteAtK(head, 2);
        printList(head);
    }

    static void printList(Node head){
        if( head == null ) return;
        
        // System.out.println(head.data + " ");
        // for(Node r = head.next; r != head; r = r.next)
        //     System.out.println(r.data + " ");

        Node curr = head;
        do{
            System.out.println(curr.data + " ");
            curr = curr.next;
        }while( curr != head );
    }

    // INSERT IN BEGIN:
    // NAVIE APPROACH:
    static Node insertbegin(Node head, int x){
        Node temp = new Node(x);
        if( head == null ){
            temp.next = temp;
        }else{
            temp.next = head;
            Node curr = head;
            while( curr.next != head ){
                curr = curr.next;
            }curr.next = temp;
        }return temp;
    }

    // INSERT IN BEGIN:
    // EFFICIENT APPROACH:
    // We insert new node after head -> temp, and change the data of both.
    static Node insertbeginEff(Node head, int x){
        Node temp = new Node(x);
        if(head == null ){
            temp.next = temp;
            return temp;
        }else{
            //add after head 
            temp.next = head.next;
            head.next = temp;
            //swap data
            int val = head.data;
            head.data = temp.data;
            temp.data = val;
            return head;
        }
    }

    //INSERT IN END
    // NAIVE APP:
    static Node insertinEnd(Node head, int x){
        Node temp = new Node(x);
        if(head == null ){
            temp.next = temp;
            return temp;
        }else{
            Node curr = head;
            while( curr.next != head ){
                curr = curr.next;
            }curr.next = temp;
            temp.next = head;
            return head;
        }
    }

    // EFFICIENT APP:
    static Node insertinEndEff(Node head, int x){
        Node temp = new Node(x);
        if(head == null ){
            temp.next = temp;
            return temp;
        }else{
            temp.next = head.next;
            head.next = temp;
            int val = head.data;
            head.data = temp.data;
            temp.data = val;
            return temp;
        }
    }

    // DELETE AT START
    static Node delbegin(Node head ){
        if( head == null || head.next == head ) return null;
        Node curr = head;
        while ( curr.next != head ){
            curr = curr.next;
        }curr.next = head.next;
        return curr.next;
    }

    static Node delbeginEff(Node head){
        if( head == null || head.next == head ) return null;

        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    // DELETE AT END:
    static Node delend(Node head ){
        if( head == null || head.next == head ) return null;
        Node curr = head;
        while ( curr.next.next != head ){
            curr = curr.next;
        }curr.next = head;
        return head;
    }

    // DELETE AT Kth INDEX:
    static Node deleteAtK(Node head, int k){
        if(head == null ) return null;
        if( k == 1) return delbeginEff(head);
        Node curr = head;
        for(int i = 1; curr.next != head && i < k-1; i++ ){
            curr = curr.next;   
        }curr.next = curr.next.next;
        return head;
    }
}
