public class P101 {

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Solution {
        public boolean isSym(TreeNode l, TreeNode r) {
            if(l == null && r == null) {
                return true;
            } else if(l == null) {
                return false;
            } else if(r == null) {
                return false;
            }
            if(l.val == r.val) {
                boolean b1 = isSym(l.left, r.right);
                boolean b2 = isSym(l.right, r.left);
                return b1 && b2;
            } else return false;
        }
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            return isSym(root.left, root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(new Solution().isSymmetric(t1));
    }
}
