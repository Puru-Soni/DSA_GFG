public class _14_sep_even_odd {
    public static void main(String[] args) {
        
//  The task is to sperate even node and odd node of a singly linked list:
//  The even node then the odd nodes:

        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);

        head = segerateNode(head);
        _0_LinkedList.printList(head);
    }   

    // OWN approach:
    // 3 pointer
    static Node segerateNode(Node head){
        if( head == null || head.next == null ) return head;
        Node oddS = null, odd = null, even = null, fast = head;
        while( fast != null ){
            if( fast.data % 2 == 0 ){       // For even node
                if( even == null ){         // if first even node
                    even = fast;
                    head = even;    
                } else{                     // else update in even node next
                    even.next = fast;
                    even = even.next;
                }
            } else {                        // similar in Odd node:
                if( odd == null ){
                    odd = fast;
                    oddS = odd;
                } else{
                    odd.next = fast;
                    odd = odd.next;
                }
            } fast = fast.next;
        } if( even != null && odd != null ){ 
            even.next = oddS; 
            odd.next = null;
        } return head;        
    }
}