package Linked_list;

public class _16_pairwiseSwap {
    public static void main(String[] args) {
//  Given a linked list we need to pair wise swap nodes:

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // head = _PairSwap(head);
        // head = _SwapRef(head);
        head = _generalSol(head);
        _0_LinkedList.printList(head);
    }

    // changing data: O(n) & O(1)
        // IN case of large data, changing data might cost more.
    static Node _PairSwap(Node head){
        if( head == null || head.next == null ) return head;
        Node curr = head;
        while( curr != null && curr.next != null ){
            int val = curr.data;
            curr.data = curr.next.data;
            curr.next.data = val;

            curr = curr.next.next;
        } return head;
    }

    // Changing refernce:
    static Node _generalSol(Node head){
        if( head == null || head.next == null ) return head;
        Node prev = head;
        head = head.next;
        head.next = prev;

        Node curr = head.next.next;
        while( curr != null && curr.next != null ){
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        } prev.next = curr;
        return head;
    }
}