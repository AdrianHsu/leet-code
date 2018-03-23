public class P121 {

    public static class Solution {
        public int maxProfit(int [] prices) {
            int res = 0;
            // int [] dp = new int [prices.length];
            // dp[0] = 0;
            int min = 9999;
            for(int i = 0; i < prices.length; i++) {
                if(prices[i] < min) {
                    min = prices[i];
                    continue;
                }
                if(prices[i] - min > res) {
                    res = prices[i] - min;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int [] {2, 3, 1, 4, 3, 6, 5};
        System.out.println(new Solution().maxProfit(arr));
    }
}

//{2, 3, 1, 4, 3, 6}
//dp = [0, 2, 2, 1, 1, 1]