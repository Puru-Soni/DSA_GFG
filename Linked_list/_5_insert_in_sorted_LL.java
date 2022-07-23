package Linked_list;

public class _5_insert_in_sorted_LL {
    public static void main(String[] args) {

        // insertion in a sorted linked list. The linked list should remain sorted after insertion.
        //  TIME COMPLEXITY: depends on position where inserted; theta(posi)
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = insertIn(head, 25);
        printList(head);

        System.out.println("\n");

        head = insertIn(head, 35);
        printList(head);

        System.out.println("\n");

        head = insertIn(head, 50);
        printList(head);
    }
    
    static void printList(Node head){
        if (head == null) return;
        Node curr = head;
        while ( curr != null ) {
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }

    static Node insertIn(Node head, int x) {
        Node temp = new Node(x);
        if ( head == null )
            return temp;
        if ( head.data >= x ) {
            temp.next = head;
            return temp;
        }Node curr = head;
        while (curr.next != null && curr.next.data <= x)
            curr = curr.next;
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
}
