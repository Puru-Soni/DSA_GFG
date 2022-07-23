package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversing {

    // Approach 1 :
    // get height of binary tree and then print k = 1 to h distance node from root

    // O(n)
    static int getheight(TreeNode root) {
        if (root != null) {
            return Math.max(getheight(root.left), getheight(root.right)) + 1;
        }
        return 0;
    }

    // O(N+H)*n = H*n
    static void levelorder(TreeNode root, int h) {
        if (root == null)
            return;
        if (h == 0)
            System.out.println(root.key);
        else {
            levelorder(root.left, h - 1);
            levelorder(root.right, h - 1);
        }
    }

    // Approach 2 : Using queue DS
    // Time: theta(n) ; Space : O(n)
    static void printLevel(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            TreeNode temp = q.poll();
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
            System.out.println(temp.key);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(20);

        // int k = getheight(root);

        // for (int i = 0; i < k; i++) {
        // levelorder(root, i);
        // }

        printLevel(root);
    }
}
