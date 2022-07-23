package Linked_list;

public class _12_remv_loop {
    public static void main(String[] args) {
        // Node head = null;
        Node head = new Node(10);
        // head.next = head;
        Node temp1 = new Node(20);
        head.next = temp1;
        temp1.next = new Node(30);
        temp1.next.next = new Node(40);
        Node temp2 = new Node(50);
        temp1.next.next.next = temp2;
        temp2.next = temp1;

        head = delLoop(head);
        _0_LinkedList.printList(head);
    }

    /* 
    DETECT THE LOOOP AND REMOVE THE LOOP:
        ALGORITHUM:
            1 - Use flyods cycle algo to Detect the loop
            2 - Move slow to beginning of list and keep fast at the meet point only
            3 - Move both of them one by one, next meep up is the start of the loop        
        The algo says the second meeting point is fixed.
    */

    static Node delLoop(Node head){
        if( head == null ) return head;
        Node slow = head, fast = head;
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow ) break;
        } if( slow != fast ) return head;
        slow = head;
        while( slow.next != fast.next ){
            slow = slow.next;
            fast = fast.next;
        } fast.next = null;
        return head;
    }
}
