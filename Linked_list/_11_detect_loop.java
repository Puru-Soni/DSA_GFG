package Linked_list;

import java.util.HashSet;

class Node{
    int data;
    boolean visit; // modification
    Node next;
    Node(int x){
        data = x;
        visit = false;
    }
}

public class _11_detect_loop {
    public static void main(String[] args) {
// The problem of checking whether a linked list contains any loop or not
    /*  
         1 -> 2 -> 3 -> 4 -> 5 ->        
                  ^------------v    loop here.
        return Yes.
    */
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

        // 10 -> 20 -> 30 -> 40 -> 50 ->
        //       ^--------------------v

        // _0_LinkedList.printList(head);
        // boolean chk = detectLoopNavie(head);
        // boolean chk = detectLoopNavie2(head);
        // boolean chk = detectLoopUseTemp(head);
        // boolean chk = detectLoopUsehash(head);
        boolean chk = detectLoopUsePointer(head);
        System.out.println((chk) ? "Yes" : "No");
    }   

    
    // Using 2 poiters fast and slow:
    /*  
    FLOYDS CYCLE LINKED LIST:
        initial two pointer slow and fast;
        We move slow by one and fast by two node;
        Now if there is a loop they will meet at a certain point.
    */
    static boolean detectLoopUsePointer(Node head){
        Node fast = head, slow = head;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if( fast == slow ) return true;
        }return false;
    }
    
    // using hashSet
    // Cons : more space complexity
    static boolean detectLoopUsehash(Node head){
        if( head.next == head ) return true;
        HashSet<Node> hs = new HashSet<>();
        Node curr = head;
        while(curr != null){
            if(!hs.contains(curr)){
                hs.add(curr);
                curr = curr.next;
            }else return true;
        }return false;  
    }

    // Using temp node:
    // We store the next of each node and then point curr node to temp, in case of loop a node is already pointed to temp is detected.
    // cons : linked list changed
    static boolean detectLoopUseTemp(Node head){
        Node temp = new Node(-1);
        Node curr = head;
        while( curr != null ){
            Node dum = curr.next;
            if( dum == temp ) return true;
            curr.next = temp;
            curr = dum;
        }return false;
    } 

    // NAVIE 2
    // Cons : MODIFITY NODE CLASS
    static boolean detectLoopNavie2(Node head){
        Node curr = head;
        while(curr != null ){
            if( curr.visit == true ) return true;
            else curr.visit = true;
            curr = curr.next;
        } return false;
    }

    //  NAVIE SOLUTION: 
    // Cons: O(n*n)
    static boolean detectLoopNavie(Node head ){
        if( head == null || head.next == null ) return false;
        if( head.next == head) return true;
        Node curr = head;
        Node prev = head;
        while( curr != null && curr.next != null ){
            while( prev != curr){
                if(prev == curr.next) return true;
                prev = prev.next;
            } prev = head;
            curr = curr.next;
        }return false;
    }
}