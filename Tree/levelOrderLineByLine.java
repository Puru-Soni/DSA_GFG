package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderLineByLine {

    // Approach 1 : Insert a null stage value in a queue for each level
    // O(N+H) h = no of nulls per levels.
    // Space: theta(W) : w = width

    static void levelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            TreeNode temp = q.poll();
            if (temp == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(temp.key + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    // Approach 2 : Running two loop, first until queue is empty and second for size
    // of each level.
    // Time: O(n), enter and come out of queue is constant work, Space: theta(n)
    static void levelOrder2(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add((root));
        while (q.isEmpty() == false) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode temp = q.poll();
                System.out.print(temp.key + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(20);

        // levelOrder(root);
        levelOrder2(root);
    }
}
