package Tree;

// Construct a binary tree from inorder and preOrder array

class getTree_in_pre_order {
    public static void main(String[] args) {
        // int[] in = { 20, 10, 40, 30, 50 };
        // int[] pre = { 10, 20, 30, 40, 50 };

        int[] in = { -1 };
        int[] pre = { -1 };

        int end = in.length - 1;
        TreeNode root = getTree(in, pre, 0, end);

        _0_introToTree.inOrder(root);
    }

    // Time: O(n*n) for every node we run a for loop.
    static int preIndex = 0;

    static TreeNode getTree(int[] in, int[] pre, int start, int end) {

        if (start > end)
            return null;

        System.out.println(start + " " + end);

        TreeNode root = new TreeNode(pre[preIndex++]);

        System.out.println(root.key + " " + preIndex);

        int inIndex = -1;
        int i = start;
        int j = end;
        while (i < j && in[i] != root.key && in[j] != root.key) {
            i++;
            j--;
        }
        if (in[i] == root.key)
            inIndex = i;
        else
            inIndex = j;

        System.out.println(inIndex);

        root.left = getTree(in, pre, start, inIndex - 1);
        root.right = getTree(in, pre, inIndex + 1, end);
        return root;
    }

    // using Hashing we can preprocess inorder array as Key : node value , value :
    // indexes
}