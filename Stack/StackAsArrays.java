package Stack;

// Designing my own Class
// Here problem is UnderFlow, Overflow and No dynamic size
class Stack {

    int capacity; // Max Size.
    int[] stk; // Stack as Array
    int top; // index of top item.

    Stack(int cap) {
        top = -1;
        capacity = cap;
        stk = new int[capacity];
    }

    boolean isEmpty() {
        return (top < 0);
    }

    void push(int val) {
        if (top >= capacity - 1)
            System.out.println("OverFlow");
        else {
            stk[++top] = val;
            System.out.println(val + " pushed into stack");
        }
    }

    int pop() {
        if (top < 0)
            System.out.println("UnderFlow");
        else
            return stk[top--];
        return 0;
    }

    int peek() {
        return stk[top];
    }

    int size() {
        return top + 1;
    }

    void show() {
        if (top < 0)
            return;
        for (int i = top; i >= 0; i--)
            System.out.println(stk[i]);
    }
}

public class StackAsArrays {

    public static void main(String[] args) {

        Stack stack = new Stack(4);

        stack.push(10);
        stack.push(5);
        stack.push(15);

        stack.show();

        int x1 = stack.pop();
        System.out.println(x1 + " popped");

        int x2 = stack.pop();
        System.err.println(x2 + " popped");

        System.out.println(stack.isEmpty() ? "Yes" : "No");

        stack.push(25);
        stack.push(45);
        stack.push(2);
        stack.push(34);

        int y1 = stack.peek();
        System.out.println(y1);

        System.out.println(stack.size());
    }
}
