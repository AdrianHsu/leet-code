public class P718 {
    public static class Solution {
        public int findLength(int[] A, int[] B) {
            int max = -1000000;
            int [][]dp = new int [A.length][B.length];
            for(int i = 0; i < A.length; i++) {
                for(int j = 0; j < B.length; j++) {
                    if(i == 0 || j == 0) {
                        if(A[i] == B[j]) 
                            dp[i][j] = 1;
                        else
                            dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = (A[i] == B[j] ?  dp[i-1][j-1] + 1 : 0);
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
            return max;
        }
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 6};
        int[] B = {3, 2, 3, 4, 7, 4};
        // int[] A = {0, 1, 1, 1, 1};
        // int[] B = {1, 0, 1, 0, 1};
        System.out.println(new Solution().findLength(A, B));
    }
}
