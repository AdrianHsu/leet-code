import java.util.*;

public class ProblemName {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static class Solution {
        // https://www.youtube.com/watch?v=GZ0qvkTAjmw
        // 屬於 divide and conquer

        public List<TreeNode> generateTrees(int n) {
            if(n == 0) {
                List<TreeNode> list = new ArrayList<TreeNode>();
                return list;
            }
            return genTrees(1, n);
        }

        public List<TreeNode> genTrees (int start, int end)
        {
            List<TreeNode> list = new ArrayList<TreeNode>();
            // 想像只有 [5]自己的 case: (start, 5-1), (5+1, end) -> (5, 4), (6, 5) -> start > end 就要 break
            if(start > end) { // 此時 subtree 為空的，方法數 = 1 ，就是自己本身
                list.add(null);
                return list;
            } else if(start == end) { // 此時 subtree 只有一個節點，方法數 = 1
                list.add(new TreeNode(start));
                return list;
            }
            List<TreeNode> left;
            List<TreeNode> right;

            // 以 i 作為 root，traverse 左右子樹的各種情況
            for(int i = start; i <= end; i ++ ) {
                left = genTrees(start, i - 1); // 左子樹集合
                right = genTrees(i + 1, end); // 右子樹集合

                // 左子樹和右子樹的全部組合
                // 當然有很多種，例如 [1, 2, 3] 這組，如果拿 2 當 root ，就有好幾種了
                for(TreeNode lnode: left) {
                    for(TreeNode rnode: right) {
                        TreeNode root = new TreeNode(i);
                        root.left = lnode; // 這顆 lnode 底下都已經建好了，是顆完整的子樹。
                        root.right = rnode;
                        list.add(root);
                    }
                }
            }
            return list;
        }

    }
    public static void main(String args[]) {
        Solution s = new Solution();
        s.generateTrees(3);
        // System.out.println(s.function());
    }
}