/**
 * StackAsLinkedList
 */

// If we keep track of tail, insert is O(1) and delete is O(n) linear time, hence better to use double linked list.
// If we keep track of head, operations are O(1) both insert and delete.
class myNode {
    myNode next;
    int data;
    myNode(int x) {
        data = x;
        next = null;
    }
}

class myStack {
    myNode head;
    int sz;

    myStack() {
        sz = 0;
        head = null;
    }

    int size() {
        return sz;
    }

    boolean isEmpty() {
        return ( head == null );
    }

    void push(int val) {
        myNode newNode = new myNode(val);
        newNode.next = head;
        head = newNode;
        sz++;
    }
    
    int pop() {
        if (head == null) {
            System.out.println("Stack is Empty!");
            return 0;
        } else {
            int x = head.data;
            head = head.next;
            sz--;
            return x;
        }
    }

    int peek() {
        return head.data;
    }

    void show(){
        myNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    } 
}

public class StackAsLinkedList {
    public static void main(String[] args) {

        myStack stk = new myStack();
        
        System.out.println(stk.isEmpty() ? "yes" : "no");

        stk.push(5);
        stk.push(10);
        stk.push(15);

        stk.show();

        System.out.println(stk.peek());

        int x = stk.pop();
        System.out.println(x);
        stk.show();
    }

}