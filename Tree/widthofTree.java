package Tree;

import java.util.LinkedList;
import java.util.Queue;

// Maximum Width of Binary tree is the maximum number of nodes present in a level of the Tree.

public class widthofTree {

    // Time = theta(n)
    // Space = O(n)
    static void getWidth(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int max = 0;
        int cnt = 0;

        while (q.size() > 1) {
            TreeNode temp = q.poll();
            if (temp == null) {
                max = Math.max(cnt, max);
                cnt = 0;
                q.add(null);
                continue;
            }
            cnt++;
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        System.out.println(max);
    }

    static void getWidth1(TreeNode root) {
        if (root == null) {
            System.out.println(0);
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;

        while (q.isEmpty() == false) {
            int cnt = q.size();
            res = Math.max(res, cnt);

            for (int i = 0; i < cnt; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }

        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(14);
        root.left.left = new TreeNode(17);
        root.left.left.left = new TreeNode(16);

        getWidth(root);
    }
}
