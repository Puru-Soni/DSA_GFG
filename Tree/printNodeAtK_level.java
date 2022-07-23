package Tree;

public class printNodeAtK_level {

    // Nodes at distance k from the root are basically the nodes at (k+1)th level of
    // the Binary Tree.
    // A function that takes root and k as a parameter

    static void getNodeAtK(TreeNode root, int k) {
        if (root == null)
            return;
        if (k == 0)
            System.out.println(root.key);
        else {
            getNodeAtK(root.left, k - 1);
            getNodeAtK(root.right, k - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(20);

        getNodeAtK(root, 3);
    }
}
