public class P152 {
    public static class Solution {
        public int maxProduct(int[] nums) {
            if(nums.length == 0) return 0;
            int res = nums[0];
            int []max_dp = new int [nums.length];
            int []min_dp = new int [nums.length];

            max_dp[0] = nums[0];
            min_dp[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] < 0) {
                    int tmp = max_dp[i - 1];
                    max_dp[i - 1] = min_dp[i - 1];
                    min_dp[i - 1] = tmp;
                }
                max_dp[i] = Math.max(nums[i], max_dp[i - 1] * nums[i]);
                min_dp[i] = Math.min(nums[i], min_dp[i - 1] * nums[i]);
                res = Math.max(res, max_dp[i]);
            }
            return res;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[] {2, 3, -2, 4, -1}));
    }
}
