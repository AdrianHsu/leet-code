import java.util.*;

public class Subsets078 {

    public static class Solution {
        private void dfs(List<List<Integer>> res, List<Integer> arr, int i, int[] nums) {
            res.add(new ArrayList<Integer>(arr));
            for(int j = i; j < nums.length; j++) {
                arr.add(nums[j]);
                dfs(res, arr, j+1, nums);
                arr.remove(arr.size() - 1);
            }
        }
        public List<List<Integer>> subsets(int[] nums) {

            // 如何 initialize 一個 list of list：還蠻重要的!!
            List<List<Integer>> res = new ArrayList<>();

            int i = 0;
            List<Integer> arr = new ArrayList<>();
            dfs(res, arr, i, nums);

            return res;
        }

    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] a = {1, 2, 3};

        System.out.println(s.subsets(a));
    }
}

