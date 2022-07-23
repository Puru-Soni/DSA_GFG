package Stack;

import java.util.ArrayList;

// Designing my own Class
// Here problem is UnderFlow, Overflow and No dynamic size
class myStack {

    ArrayList<Integer> stk = new ArrayList<>();

    boolean isEmpty() {
        return stk.size() == 0;
    }

    void push(int val) {
        stk.add(val);
        System.out.println(val + " is added to the stack");
    }

    int pop() {
        int x = stk.get(stk.size() - 1);
        stk.remove(stk.size() - 1);
        return x;
    }

    int peek() {
        return stk.get(stk.size() - 1);
    }

    int size() {
        return stk.size();
    }

    void show() {
        if ( stk.size() > 0 ) {
            for (int i = stk.size()-1; i >= 0; i--) {
                System.out.println(stk.get(i));
            }
        }
    }
}

public class StackAsArrayList {

    public static void main(String[] args) {

        myStack stack = new myStack();

        stack.push(10);
        stack.push(5);
        stack.push(15);

        stack.show();

        int x1 = stack.pop();
        System.out.println(x1 + " popped");

        int x2 = stack.pop();
        System.err.println(x2 + " popped");

        System.err.println(stack.isEmpty() ? "Yes" : "No");

        stack.push(25);
        stack.push(45);
        stack.push(2);
        stack.push(34);

        int y1 = stack.peek();
        System.out.println(y1);

        System.err.println(stack.size());
    }
}