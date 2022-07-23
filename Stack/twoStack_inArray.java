package Stack;
// Implement two stacks in a array

import java.util.Scanner;

// Method 1 : Use half array for stack 1 and half array for stack 2, 
// but if we have space for items and one stack is not full that is disadvantage. 

// Method 2 : Start stack 1 from 0th index left side, and start stack 2 from rightmost side, n-1 th index.
// dynamic within a array

class Stack {
    int n;
    int[] ar;
    int top1, top2;

    Stack(int cap) {
        n = cap;
        ar = new int[n];
        top1 = 0;
        top2 = n - 1;
    }

    void push1(int d) {
        if (top1 < top2) {
            ar[top1++] = d;
        }
    }

    void push2(int d) {
        if (top2 > top1) {
            ar[top2--] = d;
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int x = ar[top1--];
            return x;
        }
        return -1;
    }

    int pop2() {
        if (top2 < n) {
            int x = ar[top2++];
            return x;
        }
        return -1;
    }
}


public class twoStack_inArray {
    public static void main(String[] args) {
        Stack obj = new Stack(10);
        obj.push1(1);
        obj.push1(2);
        obj.push2(10);
    }
}
