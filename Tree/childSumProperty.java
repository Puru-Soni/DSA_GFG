package Tree;

public class childSumProperty {

    static boolean checkChildSum(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int sum = 0;
        if (root.left != null)
            sum += root.left.key;
        if (root.right != null)
            sum += root.right.key;
        return (sum == root.key
                && checkChildSum(root.left)
                && checkChildSum(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);

        System.out.println(checkChildSum(root));
    }
}
