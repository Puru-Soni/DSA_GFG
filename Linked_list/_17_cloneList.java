package Linked_list;

import java.util.HashMap;

/**
 * _17_cloneList
 */

class Node {  
    int data;  
    Node next;
    Node prev;
    Node random;  
    Node(int x)  
    {  
        data = x;  
        next = random = null;  
    }  
}

public class _17_cloneList {

    public static void main(String[] args) {
//  Given a linked list where every node has two pointers, one points to next node and another to a random node.
//  We need to clone the same linked list and make a new linked list.
        Node head = new Node(10); 
        head.next = new Node(5); 
        head.next.next = new Node(20); 
        head.next.next.next = new Node(15); 
        head.next.next.next.next = new Node(20); 
        
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next.next.next;

        Node cl_head = _useHash(head);
        _0_LinkedList.printList(cl_head);
    }

    /* 
    USING HASHING:
        create a hash Map
        Put all node of head as key and new node with thier data as value with no links
        Link all new node according the keys next and random nodes
    */  
    static Node _useHash(Node head){
        HashMap<Node, Node> hm = new HashMap<>();
        for(Node curr = head; curr != null; curr = curr.next ) hm.put( curr, new Node(curr.data) );
        for(Node curr = head; curr != null; curr = curr.next ){
            Node cl_node = hm.get(curr);
            cl_node.next = hm.get(curr.next);
            cl_node.random = hm.get(curr.random);
        } return hm.get(head);
    }

    /* 
        USING REFERENCE:
        O(n) time + O(1) space

        Trick:
            PART 1: Insert all new node in the original linked list:
            ex: original list: 10 -> 5 -> 20 -> 15 -> 20
                added clones: 10 -> 10 -> 5 -> 5 -> 20 -> 20 -> 15 -> 15 -> 20 -> 20
            
            PART 2: Connect the random pointers of the clone nodes
            PRRT 3: Remove the clone node from originla list, to form a new clone list.
    */ 

    static Node _useRef(Node head){
        // adding clone nodes
        for( Node curr = head; curr != null; ){   // 1 
            Node forward = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = forward;
            curr = forward;
        } for( Node curr = head ; curr != null; curr = curr.next.next){             // 2
            curr.next.random = (curr.random != null ) ? curr.random.next : null;
        } Node rest_head = head.next;
        for(Node curr = head, temp=rest_head; curr != null && temp != null; curr = curr.next, temp = temp.next ){   // 3
            curr.next = (curr.next != null ) ? curr.next.next: null;
            temp.next = (temp.next != null ) ? temp.next.next : null;
        } return rest_head;
    }
}