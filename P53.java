public class P53 {
    public static class Solution {

        public int maxSubArray(int[] nums) {
            if(nums.length == 0) return 0;
            int n = nums.length;
            int [] dp = new int [n];
            dp[0] = nums[0];
            int max = dp[0];
            for(int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                if(dp[i] > max)
                    max = dp[i];
            }
            return max;
        }
    }
    public static void main(String[] args) {
        int [] arr = new int []{-2,1,-3,3,-1,2,4,-5,4};
        System.out.println(new Solution().maxSubArray(arr));
    }
}
