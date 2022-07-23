package Linked_list;

// Given two sorted linked list, new need to merger the two sorted linked list with O(1) space.

public class _19_link_sorted_lists {
    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        Node head2 = new Node(5);
        head2.next = new Node(15);
        head2.next.next = new Node(17);
        head2.next.next.next = new Node(18);
        head2.next.next.next.next = new Node(35);

        Node head = _merge(head1, head2);
        _0_LinkedList.printList(head);
    }

    // O(n) 
    public static Node _merge(Node h1, Node h2){
        if(h1==null) return h2; if(h2==null) return h1;
        Node temp = new Node(-1), curr = temp;
        while( h1 != null && h2 != null ){
            if( h1.data < h2.data ){
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            } curr = curr.next;
        } if( h1 != null ) curr.next = h1;
        if( h2 != null ) curr.next = h2;
        return temp.next;
    }
}
