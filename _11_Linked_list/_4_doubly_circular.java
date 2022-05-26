/* 
In doubly circular linked list:
    Every node has two pointers, inlcuding the last and the head node.
    I.e. previous of head node is last node,
    and next of last node is head.

    PROS:
        all advantage of circular and doubly linked list.
*/
class Node {
    int data; // datatype can we anything;
    Node next; // it has reference of self type; Linked List is an exmaple of self referential
               // structure;
    Node prev; // !for doubly linked list!

    // Constructor
    Node(int x) {
        data = x;
        next = null; // optinal, if we do not initiallize a member it will be a null by default.
    }
}

public class _4_doubly_circular {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.prev = temp2;
        head.next = temp1;

        temp1.prev = head;
        temp1.next = temp2;

        temp2.prev = temp1;
        temp2.next = head;

        // TRAVERSING:
        printList(head);

        System.out.println("-----------------");

        // INSERT in begin and end
        head = insertBegin(head, 0);
        printList(head);

        System.out.println("-----------------");

        head = insertEnd(head, 40);
        printList(head);

        System.out.println("-----------------");

        // DELETE in begin and end
        head = delBegin(head);
        printList(head);

        System.out.println("-----------------");

        head = delEnd(head);
        printList(head);
    }

    static void printList(Node head) {
        if (head == null)
            return;
        Node curr = head;
        do {
            System.out.println(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
    }

    // INSERT
    static Node insertBegin(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.prev = temp;
            temp.next = temp;
            return temp;
        }
        temp.next = head;
        temp.prev = head.prev;
        head.prev.next = temp;
        head.prev = temp;
        return temp;
    }

    static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.prev = temp;
            temp.next = temp;
            return temp;
        }
        temp.next = head;
        temp.prev = head.prev;
        head.prev.next = temp;
        head.prev = temp;
        return head;
    }

    // DELETE:
    static Node delBegin(Node head) {
        if (head == null || head.next == head)
            return null;
        head.next.prev = head.prev;
        head.prev.next = head.next;
        return head.next;
    }

    static Node delEnd(Node head) {
        if (head == null || head.next == head)
            return null;
        head.prev.prev.next = head;
        head.prev = head.prev.prev;
        return head;
    }
}
