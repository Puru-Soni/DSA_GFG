package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class leftViewOfTree {

    static int maxLevel = 0;

    // Approach 1 : Recursive method:
    // Track 2 pointers maxlevel = max seen, and level = current traversing level.
    static void leftView(TreeNode root, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            System.out.println(root.key);
            maxLevel = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    // Appraoch 2 : Iterative:
    // Traverse in BFS method and print the first items in updated queue.
    static void leftView(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode temp = q.poll();
                if (i == 0) {
                    System.out.println(temp.key);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        // root.left.left = new Node(1);
        // root.left.right = new Node(7);
        // root.right.left = new Node(20);

        leftView(root, 1);
    }
}
