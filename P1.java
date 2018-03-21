// https://leetcode.com/problems/two-sum/description/
import java.util.HashMap;

public class P1 {
    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap m = new HashMap<Integer, Integer>();
            int [] res = {0, 0};
            for(int i = 0; i < nums.length; i++) {
                int k = nums[i];
                if(m.get(target - k) != null) {
                    res[0] = (int) m.get(target - k);
                    res[1] = i;
                    break;
                }
                else {
                    m.put(k, i);
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        int[] res = s.twoSum(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
