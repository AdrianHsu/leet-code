public class P98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        
        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) return true;
            if (root.val >= maxVal || root.val <= minVal) return false;
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(20);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(new Solution().isValidBST(t2));
    }
}
