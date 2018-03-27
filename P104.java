public class P104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public static class Solution {
        public int depth(TreeNode root, int res) {
            if(root == null) {return res;}
            
            int left = depth(root.left, res + 1);
            int right = depth(root.right, res + 1);
            
            return Math.max(left, right);
        }
        public int maxDepth(TreeNode root) {
            int res = 0;
            return depth(root, res);
        }
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t4.right = t5;
        System.out.println(new Solution().maxDepth(t1));
    }
}
