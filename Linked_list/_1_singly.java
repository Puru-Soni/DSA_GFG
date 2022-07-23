package Linked_list;

// import Linked_list.Node;

public class _1_singly {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        // INSERTION:
        /*
         * Insert a new node at beginning of the linked-list:
         * To insert a new node at the beginning we create a temp node with data as
         * given x,
         * and assign it next node to prev head, and return the new head.
         * 
         * Time complexity:
         * O(1) constant operations.
         * 
         */
        System.out.println("INSERT FIRST -----------------------");
        head = insertInBegin(head, 5);
        head = insertInBegin(head, 0);
        // but the linked list store the values in inverse order with respect to input.
        pL(head);

        /*
         * Insert a new node at END of the linked-list:
         * To insert a new node at the end we create a temp node with data as given x,
         * and assign it next node to null and its prev next node to ref of x, and
         * return the new .
         * 
         * Time complexity:
         * O(1) constant operations.
         */
        System.out.println("INSERT END ----------------------");
        head = insertInEnd(head, 30);
        head = insertInEnd(head, 40);
        pL(head);

        // DELETION:
        /*
         * Given a singly linked list we need to delete the head node.
         * Time complexity: O(1)
         */
        head = deletefirstNode(head);
        System.out.println("DELETE FIST ----------------------");
        pL(head);

        /*
         * Given a singly linked list we need to delete the last node.
         * Time complexity: theta(n)
         */
        head = deletelastNode(head);
        System.out.println("DELETE LAST ----------------------");
        pL(head);

        // INSERTION:
        /*
         * Insertion at given position in a singly linked list:
         */
        System.out.println("Insert at given posi -------------");
        head = posiInsert(head, 50, 3);
        pL(head);

        // SEARCH:
        /*
         * Searching in Singly Linked list iterative and recursive:
         * Time complexity: theta(n)
         */
        System.out.println("Searching: ----------------  " + interativesearchLL(head, 10));
        System.out.println("Searching: ----------------  " + recursivesearchLL(head, 10));

        // CONCEPTS:
        // System.out.println(head); // address/reference of current node
        // System.out.println(head.next); // address/reference of next node
        // System.out.println(head.data); // value of current node
    }

    // print Linked list:
    public static void pL(Node head) {
        if (head != null) {
            System.out.println(head.data + " ");
            pL(head.next);
        } else
            return;
    }

    public static Node insertInBegin(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    public static Node insertInEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null)
            return temp;

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = temp;
        return head;
    }

    public static Node deletefirstNode(Node head) {
        if (head == null)
            return null;
        return head.next;
    }

    public static Node deletelastNode(Node head) {
        if (head == null || head.next == null)
            return null;
        Node curr = head;
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    static Node posiInsert(Node head, int x, int posi) {
        Node temp = new Node(x);
        if (posi == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for (int i = 1; i < posi - 1 && curr != null; i++)
            curr = curr.next;
        if (curr == null)
            return head;
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    static int interativesearchLL(Node head, int x) {
        Node curr = head;
        for (int i = 1; curr != null; i++) {
            if (curr.data == x) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    static int recursivesearchLL(Node head, int x) {
        if (head == null)
            return -1;
        if (head.data == x)
            return 1;
        else {
            int res = recursivesearchLL(head.next, x);
            if (res == -1)
                return -1;
            else
                return res + 1;
        }
    }
}