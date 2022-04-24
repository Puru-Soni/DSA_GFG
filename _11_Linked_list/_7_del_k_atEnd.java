public class _7_del_k_atEnd {
    public static void main(String[] args) {
        
    // Finding the n-th node from the end of a given linked list. 
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        // head = delKatEnd(head, 5);
        printList(head);

        System.out.println("---------------------------------------");

        head = delKatEndEff(head, 5);
        printList(head);
    }

    static void printList(Node head){
        if( head == null )return;
        for(Node curr = head; curr != null; curr = curr.next)
            System.out.println(curr.data + " ");
    
    }

    // NAVIE METHOD:
    static Node delKatEnd(Node head, int k){
        int cnt = 0;
        for(Node curr = head; curr != null; curr = curr.next ) cnt++;
        if( cnt < k) return null;
        if( cnt-k == 0 ) return head.next;

        Node curr = head;
        for(int i = 1; i < cnt-k; i++ ){
            curr = curr.next;
        } curr.next = curr.next.next;
        return head;
    }

    // EFFICIENT METHOD:
    /* 
        Approach that works with out finding the length of the linked list:
            We use the concept of two references:
            - Move first pointer Kth position ahead,
            - Start second pointer from head, with the first pointer moving 1 node at a time.
            
    */
    static Node delKatEndEff(Node head, int k){
        Node first = head, second;
        for(int i = 0; i < k; i++ ) first = first.next;
        if(first == null ) return head.next; // corner case if k == length of list or list has only 1 node
        for( second = head; first.next != null; second = second.next ) first = first.next;
        second.next = second.next.next;
        return head;
    }
}
