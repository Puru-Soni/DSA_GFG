package Linked_list;

import java.util.HashSet;

public class _15_intersection {
    public static void main(String[] args) {
        
//  We are given two linked list: We need to find the itersection point between two list.
        Node head1 = new Node(5);
        head1.next = new Node(8);
        head1.next.next = new Node(7);
        head1.next.next.next = new Node(10);

        Node head2 = new Node(9);
        head2.next = head1.next.next.next;

        head1.next.next.next.next = new Node(12);
        head1.next.next.next.next.next = new Node(15);

        // System.out.println(intersection(head1, head2));
        System.out.println( intersectionEff( head1, head2 ) );
    }   

    // EFFICIENT METHOD:
    /* 
        Count the length of both the list, let c1 and c2
        Traverse the bigger list abs(c2-c1) times.
        Next move boht the list pointer one by one, when curr1 == curr2 that is the intersection point.
    */
    static int intersectionEff(Node l1, Node l2){
        if( l1 == null || l2 == null ) return -1;
        int c1 = countList(l1);
        int c2 = countList(l2);
        int d;
        if( c1 > c2 ){
            d = c1-c2;
            return _getIntersection(d, l1, l2);
        } else{
            d = c2-c1;
            return _getIntersection(d, l2, l1);
        }
    }

    static int _getIntersection(int d, Node l1, Node l2){
        for(int i = 0; i < d && l1 != null ; i++){
            l1 = l1.next;
        } while( l1 != null && l2 != null ){
            if( l1 == l2 ) return l1.data;
            l1 = l1.next;
            l2 = l2.next;
        } return -1;
    }

    static int countList(Node l){
        Node curr = l;
        int cnt = 0;
        while( curr != null ){
            cnt++;
            curr = curr.next;
        } return cnt;
    }

    // Using HashSet:
    // Time O(m+n) - m = size of l1 list, n = size of l2 list. 
    // Space O(k) - k = size of hashSet.
    static int intersection(Node l1, Node l2){
        if( l1 == null || l2 == null ) return -1;
        HashSet<Node> hs = new HashSet<>();
        while( l2 != null ){
            if( !hs.contains(l2) ){
                hs.add(l2);
            } l2 = l2.next;
        } while( l1 != null ){
            if( !hs.contains(l1) ){
                hs.add(l1);
            } else return l1.data;
            l1 = l1.next;
        } return -1;
    }
}