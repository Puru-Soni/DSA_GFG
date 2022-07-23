package Tree;

public class sizeOfBinaryTree {

    // Time: O(n) Space : O(n)
    static int getsizeoftree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + getsizeoftree(root.left) + getsizeoftree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(20);

        System.out.println(getsizeoftree(root));
    }
}
