import java.util.*;

public class P46 {
    public static class Solution {

        public void backtrack(List<List<Integer>> res, List<Integer> s, int[] nums, int pos, int iter){
            if(pos == nums.length) {
                List<Integer> copy = new ArrayList<Integer>(s);
                res.add(copy);

                return;
            }

            for(int i = 0; i < nums.length; i ++) {
                if(s.contains(nums[i]))
                    continue;
                s.add(nums[i]);
                backtrack(res, s, nums, pos + 1, i);
                s.remove(s.size() - 1);
            }
        }
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> s = new ArrayList<Integer>();
            backtrack(res, s, nums, 0, 0);
            return res;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> l = new Solution().permute(new int[] {1, 2, 3});
        System.out.println(l);
    }
}
