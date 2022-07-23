package Tree;
// In a Balanced Binary Tree for every node, 
// the difference between heights of left subtree and right subtree should not be more than one.

public class balanceTree {

    // Method 1 : O(n*n )
    static int getheight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getheight(root.left), getheight(root.right)) + 1;
    }

    static boolean balance(TreeNode root) {
        if (root == null)
            return true;
        int a = getheight(root.left);
        int b = getheight(root.right);
        int ans = a - b;
        return (Math.abs(ans) <= 1 && balance(root.left) && balance(root.right));
    }

    // Method 2: O(n)
    static int balance1(TreeNode root) {
        if (root == null)
            return 0;
        int l = balance1(root.left);
        if (l == -1)
            return -1;
        int b = balance1(root.right);
        if (b == -1)
            return -1;
        if (Math.abs(l - b) > 1)
            return -1;
        else
            return Math.max(l, b) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(14);
        root.left.right.left = new TreeNode(17);
        root.left.right.right = new TreeNode(16);
        root.right.left = new TreeNode(15);

        System.out.println(balance1(root));
    }
}
