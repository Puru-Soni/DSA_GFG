package Linked_list;

public class mergeTwoLinkedList {
    public  static Node mergeTwoLists(Node list1, Node list2) {
        Node head = null, curr = head;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                if (curr == null)
                    curr = list1;
                else
                    curr.next = list1;
                list1 = list1.next;
            } else {
                if (curr == null)
                    curr = list2;
                else
                    curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next = new Node(5);

        Node root1 = new Node(1);
        root1.next = new Node(3);
        root1.next = new Node(4);

        Node head = mergeTwoLists(root, root1);
    
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
