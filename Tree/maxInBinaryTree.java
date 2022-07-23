package Tree;

public class maxInBinaryTree {

    // Time : O(n)
    static int getmax(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.key, Math.max(getmax(root.left), getmax(root.right)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(20);

        System.err.println(getmax(root));
    }
}
