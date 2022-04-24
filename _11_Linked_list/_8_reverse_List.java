import java.util.ArrayList;

public class _8_reverse_List {
    public static void main(String[] args){

    
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

    // Reversing a linked list in an iterative manner. 

        head = useArrayList(head);
        printList(head);
        System.out.println("-----------------");
        head = use3pointer(head);
        printList(head);
        
    // Reversing a linked list in an recursive manner. 

        System.out.println("-----------------");
        head = useRecursion_1(head);
        printList(head);
        
        System.out.println("-----------------");
        head = useRecursion_2(head, null);
        printList(head);
    }

    // NAIVE SOLUTION USING ARRAYLIST:
    // It takes O(n) extra space!
    static Node useArrayList(Node head){
        if(head == null) return null;
        ArrayList<Integer> al = new ArrayList<>();
        for(Node curr = head; curr != null; curr = curr.next) al.add(curr.data);
        for(Node curr = head; curr != null; curr = curr.next) curr.data = al.remove(al.size()-1);
        return head;
    }

    // Efficient solution using 2 pointer and a prev tracking pointer.
    /* 
    IT does not take extra space.
        We need to change the links.
        We intitalize two pointer prev and curr.
        prev = null, curr = head
            First store the curr next in a temp Node for swapping later
            Make the head node point to null i.e curr.next = prev
            Now update the curr and prev 
                prev = curr
                and curr = temp
        REPEAT SAME until the curr node is null, i.e. we traversed the complete list.
        return prev as the new head.
    */
    static Node use3pointer(Node head){
        if(head == null ) return null;
        Node curr = head, prev = null;
        while( curr != null ){
            Node temp = curr.next;      // Stores next ref.
            curr.next = prev;           // new ref.
            prev = curr; curr = temp;   // update nodes
        }return prev;
    }

    // RECURSIVE SOLUTION: METHOD 1
    /* 
        10 20 30 40 50
    
        head = 10, 
        1rest_head = func(20) -> head = 20, 
        2rest_head = func(30) -> head = 30, 
        3rest_head = func(40) -> head = 40, 
        4rest_head = func(50) -> head = 50 || head.next == null return null
            4res_head = 50
            head = 40
            tail = 50
            tail 50 -> 40
            40 -> null
            List = null <- 40 <- 50
            return 50: 
                3rest_head = 50
                head = 30
                tail = 40
                tail 40 -> 30
                head 30 -> null
                null <- 30 <- 40 <- 50
                return 50
                    2rest_head = 50
                    head = 20
                    tail = 30
                    tail 30 -> 20
                    20 -> null 
                    null <- 20 <- 30 <- 40 <- 50
                        1rest_head = 50
                        head = 10
                        tail = 20
                        tail 20 -> 10
                        10 -> null
                        null <- 10 <- 20 <- 30 <- 40 <- 50
    */
    //  Changing links from the end to start
    static Node useRecursion_1( Node head ){        
        if( head == null || head.next == null ) return head; // base condition
        Node rest_head = useRecursion_1(head.next);
        Node tail = head.next;
        tail.next = head;
        head.next = null;
        return rest_head;
    }

    // It works the reverse way of previous solution:
    //  Changing links from the start to end
    /* 
        head, null
        curr  prev
        10    null
        
        temp = 20
        10 -> null

        prev = curr; curr = temp
        10           20
    */
    static Node useRecursion_2(Node curr, Node prev){
        if( curr == null ) return prev;
        Node temp = curr.next;
        curr.next = prev;
        return useRecursion_2(temp, curr);
    }

    public static void printList(Node head){
        if( head == null ) return;
        for(Node curr = head; curr != null; curr = curr.next)
            System.out.println(curr.data + " ");
    }
}
