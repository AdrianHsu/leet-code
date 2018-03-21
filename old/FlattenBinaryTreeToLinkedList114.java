import java.util.*;

public class FlattenBinaryTreeToLinkedList114 {
    
     // * Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
     
    public static class Solution {

        public void flatten(TreeNode root) {
            flatten(root,null);
        }

        // 把 preorder traversal 的結果，全部接成右子樹、一直往下接
        // ??? 通常 preorder 不是自己，左子，右子嗎？
        // 因為 flatten 要從最後一個往回接，所以就變成先右、再左、再自己了！

        // 先一路 dfs 找到最右下的，設好之後，開始把 prev 往回傳
        // 把 pre 放到最後一個去，也就是 root.right
        // 再往回找，root.right 的前一個就是 root 本身，把它改成 pre 了
        
        //        O  // again, root.right = pre
        //         \
        //          O 他是 root   // pre = root
        //           \
        //            O 他是 pre  // root.right = pre

        private TreeNode flatten(TreeNode root, TreeNode pre) {
            if (root == null) return pre;
            pre = flatten(root.right, pre);
            pre = flatten(root.left, pre);
            root.right = pre;
            root.left = null;
            pre = root;
            return pre;
        }
    }
    // 測法長這樣
    public static void main(String args[]) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        s.flatten(t1);
        System.out.println(t1.right.val);
        System.out.println(t2.right.val);
    }
}