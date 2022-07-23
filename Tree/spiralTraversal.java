package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class spiralTraversal {
    // Method 1 : We use stack to store nodes at which level has to be reversed
    // then pop when in reverse order, else normal level oreder traversal.

    // We are processing some items multiple times, inserting in queue, insert in
    // stack, pop from stack, deque form queue
    // 4 times processing a same alternative item is time consuming.

    static void printSpiral(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        boolean rev = false;

        q.add(root);
        while (q.isEmpty() == false) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode temp = q.poll();

                if (rev)
                    s.push(temp.key);
                else
                    System.out.print(temp.key + " ");

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            if (rev) {
                while (s.isEmpty() == false) {
                    System.out.print(s.pop() + " ");
                }
            }
            rev = !rev;
            System.out.println();
        }
    }

    // Method 2: Using two stacks, alternate level go into alternate stacks.
    static void getSpiralEff(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (s1.isEmpty() == false) {
                TreeNode temp = s1.peek();
                s1.pop();
                System.out.print(temp.key + " ");
                if (temp.left != null)
                    s2.push(temp.left);
                if (temp.right != null)
                    s2.push(temp.right);
            }
            System.out.println();
            while (s2.isEmpty() == false) {
                TreeNode temp = s2.peek();
                s2.pop();
                System.out.print(temp.key + " ");
                if (temp.right != null)
                    s1.push(temp.right);
                if (temp.left != null)
                    s1.push(temp.left);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // root.left.left.left = new Node(8);
        // root.left.left.right = new Node(9);
        // root.right.left.left = new Node(10);

        // printSpiral(root);
        getSpiralEff(root);
    }
}
