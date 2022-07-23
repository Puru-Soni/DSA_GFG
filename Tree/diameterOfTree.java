package Tree;

// Diameter of a tree is the longest path between two leaf nodes.
public class diameterOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(20);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(80);

        root.left.left.left = new TreeNode(40);
        root.left.left.right = new TreeNode(50);
        root.left.right.right = new TreeNode(90);

        root.left.left.left.left = new TreeNode(60);
        root.left.right.right.right = new TreeNode(18);

        // int d = diameter_navie(root);
        int h = eff_height(root);
        System.out.println(h + " = height");
        System.out.println(result + " = diameter");
    }

    // METHOD 1 : Get height from each node
    // O(n*n)
    static int heigth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(heigth(root.left), heigth(root.right)) + 1;
    }

    static int diameter_navie(TreeNode root) {
        if (root == null)
            return 0;
        int d = 1 + heigth(root.left) + heigth(root.right);
        int l = heigth(root.left);
        int r = heigth(root.right);
        return Math.max(d, Math.max(l, r));
    }

    // Method 2 : Precompute the height of binary Tree and store it in the Map
    // O(n) time, O(N) EXTRA space

    // Method 3 : modifing the height table.
    // O(n) time, O(1) space
    static int result = 0;

    static int eff_height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = eff_height(root.left);
        int rh = eff_height(root.right);
        result = Math.max(result, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
