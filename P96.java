public class P96 {

    public static class Solution {
        public int numTrees(int n) {
            int[] dp_g = new int [n + 1];
            int[][] dp_f = new int[n + 1][n + 1];
            dp_g[0] = 1;
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j <= i; j++) {
                    dp_f[i][j] = dp_g[j - 1] * dp_g[i - j];
                    dp_g[i] += dp_f[i][j];
                }
            }
            return dp_g[n];
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}
