import java.util.*;

public class P102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();            
            
            List<Integer> l = new ArrayList<>();
            q.offer(root);
            while(!q.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int cnt = q.size();
                // key: 把同一層的開個for 一次處理掉，不要用原本的 while 處理
                for(int i = 0; i < cnt; i++) {
                    TreeNode t = q.poll();
                    level.add(t.val);
                    if(t.left != null) {
                        q.offer(t.left);
                    }
                    if(t.right != null) {
                        q.offer(t.right);
                    }
                }
                res.add(level);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t2.left = t6;

        System.out.println(new Solution().levelOrder(t1));
    }
}
