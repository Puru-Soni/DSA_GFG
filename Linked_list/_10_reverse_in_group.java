package Linked_list;

import java.util.ArrayList;

public class _10_reverse_in_group {
    public static void main(String[] args) {
        
    // We are given a singly linked list and a value k, we need to reverse the linked list in groups of size k
    /* 
        EX: 10 -> 20 -> 30 -> 40 -> 50 -> 60
            K = 3

            30 -> 20 -> 10 -> 60 -> 50 -> 40
    */ 
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        
        // head = recursiveRev(head, 3);
        head = iterativeSolution(head, 3);
        _0_LinkedList.printList(head);
    }

    //  NAVIE SOLUTION:
    // Used array list to store k data of node until we traverse the list.
    // Keeping pointer on start node for bracktracking to override data.
    // Take more space !!
    static void revInGroup(Node head, int k){
        if( head.next == null ) return;
        ArrayList<Integer> as = new ArrayList<>();
        Node curr = head;
        while( curr != null ){
            Node prev_head = curr;
            for(int i = 0; i < k && curr != null ; i++ ){
                as.add(curr.data);
                curr = curr.next;
            }curr = prev_head;
            for(int i = 0; i < k && curr != null; i++ ){
                curr.data = as.remove(as.size()-1);
                curr = curr.next; 
            }
        }
    }
    //RECURSIVE SOLUTION:
    /* 
        First apply iterative 3 pointer approach for the first 3 items, then recursicce call for rest.
        O(n)
        but it takes auxilary space in the call stack.
    */
    static Node recursiveRev(Node head, int k){
        Node curr = head, prev = null, next = null;
        int cnt = 0;
        while( curr != null && cnt < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }if( next != null ){
            Node rest_head = recursiveRev(next, k);
            head.next = rest_head;
        }return prev;
    }
    
    //Iterative SOLUTION:
    /*
        Time - theta(n)
        space - theta(1) 
    */
    static Node iterativeSolution(Node head , int k){
        Node curr = head, rest_head = null; // storing prev head to join two grouped linked list
        boolean chk = true;
        while( curr != null ){
            Node first = curr, prev = null;
            int cnt = 0;
            while( curr != null && cnt < k ){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt++; 
            }if( chk ){
                head = prev;
                chk = false;
            }else{
                rest_head.next = prev;
            }rest_head = first;
        }return head;
    }
}
