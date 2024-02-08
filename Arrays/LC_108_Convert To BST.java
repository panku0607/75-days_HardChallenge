package Arrays;

public class LC_108_convertToBST {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }

    public static TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        TreeNode rootNode = helper(nums, 0, nums.length - 1);
        return rootNode;

    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;

        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void main(String[] args) {

        int nums[] = { -10, -3, 0, 5, 9 };

        preOrder(sortedArrayToBST(nums));

    }
}
