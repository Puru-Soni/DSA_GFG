public class _13_delNode_withAdd {
    public static void main(String[] args) {

// The tricky problem asked in an interview where a random address to a node of the linked list,
// is given and the user needs to delete the node of the given address. 
// The address can point to any random node in-between a linked list.

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);


    }

    // It works if node to be deleted is not the last node.
    static void delNode(Node curr){
        if(curr.next != null ){
            curr.data = curr.next.data;
            curr.next = curr.next.next;
        }
    }
}