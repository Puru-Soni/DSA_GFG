package Linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

// Given a singly linked list, check whether the given linked list is palindrom or not
/*  
    EX:
        R -> A -> D -> A -> R
        Yes

        G -> F -> G
        Yes

        G -> E -> E -> K
        No
*/
class LNode{
    LNode next;
    char data;
    LNode(char i){
        data = i;
    }
}

public class _20_palindrom {
    public static void main(String[] args) {
        LNode head = new LNode('R');
        head.next = new LNode('A');
        head.next.next = new LNode('D');
        head.next.next.next = new LNode('A');
        head.next.next.next.next = new LNode('R');

        System.out.println(isPalindromEff(head));
    }   

    /*
    NAVIE SOLUTION:
        Idea is to use STACK data structure.
        Travese the linked list, and keep pushing node values in the stack.
        Once completed, we again pop items from the stack and compare it with the linked list.
        While items are same keep updated linked list and stack forward.
        if stack is empty return true.
        else return fasle.
    */
    static boolean isPalindrom(LNode head){
        Deque<Character> stack  = new ArrayDeque<>();
        for(LNode curr = head; curr != null; curr = curr.next){
            stack.push(curr.data);
        } for(LNode curr = head; curr != null; curr = curr.next ){
            if( stack.pop() != curr.data ) return false;
        } return true;
    }

    /* 
    EFFICIENT SOLUTION:
        Find the middle node.
        Reverse the linked list after the middle node.
        We compare node from head and from next of middle node
        If match move forward if not return false
        
        For even number of nodes.
        Take n/2 as middle and compare from head and from next of middle. 
    */

    static boolean isPalindromEff(LNode head){
        LNode fast = head, slow = head;
        while( fast != null && fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        } reverseList(slow);

        fast = head;
        slow = slow.next;
        while( slow != null ){
            if(fast.data != slow.data) return false;
            slow = slow.next; fast = fast.next;
        } return true;
    }

    static void reverseList(LNode head){
        LNode curr = head.next;
        LNode prev = null;
        while( curr != null ){
            LNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } head.next = prev;
    }
}
