package Linked_list;

public class _9_rmv_duplicate_sortedList {
    public static void main(String[] args) {
        
// remove duplicates from a sorted singly linked list:
        // Node head = null;
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(40);

        removeDupli(head);
        _0_LinkedList.printList(head);
    }

    // Removing duplicates from the list.
    // When we check node.next we need to ensure that node is not null, hence null.next is nullPointerException case.
    static void removeDupli(Node head){
        Node curr = head;
        while( curr != null && curr.next != null){   // Also handles conditional case for null and 1 node only.
            if(curr.data == curr.next.data ){
                curr.next = curr.next.next;
            }else curr = curr.next;
        }
    }

}
