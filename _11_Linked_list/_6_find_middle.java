public class _6_find_middle {
    public static void main(String[] args) {
    
    // Given a singly linked list we need to find the middle of the linked list
    // also handle corner cases, 1 node, null node

        Node head = new Node(10);
        head.next = new Node(5);
        // head.next.next = new Node(20);
        // head.next.next.next = new Node(15);
        // head.next.next.next.next = new Node(25);
        // result : 20

        // middleOfList(head);
        getMiddle(head);
    }

    //navie approach:
    static void middleOfList(Node head ){
        if( head == null ) return;
        Node curr; int cnt = 0;
        for(curr = head; curr != null; curr = curr.next) cnt++;
        curr = head;
        for(int i = 1; i <= cnt/2; i++ ) curr = curr.next; 
        System.out.println(curr.data);
    }

    //efficient approach:
    /* 
        Idea is based on fast and slow pointers,
        slow move one pointer and fast two pointer at a time,
        For Even we check when fast == null then slow is the middle,
        For odd no of nodes when fast.next == null then slow is the middle.
    */
    static void getMiddle(Node head){
        if(head == null ) return;
        Node slow = head, fast = head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }System.out.println(slow.data);
    }
}
