public class P70 {
    public static class Solution {

// Sol 1.
        // public int climbStairs(int n) {
            
        //     int [] dp = new int [n + 1];
        //     if(n == 0) return 0;
        //     else if(n == 1) return 1;
        //     else if(n == 2) return 2;
        //     dp[0] = 0;
        //     dp[1] = 1;
        //     dp[2] = 2;
        //     for(int i = 3; i < n + 1; i++) {
        //         dp[i] = dp[i - 1] + dp[i - 2];
        //     }

        //     return dp[n];
        // }

// Sol 2.
        public int climb(int n, int [] arr) {
            if(arr[n] != 0)
                return arr[n]; // immediately return
            else 
                arr[n] = climb(n - 1, arr) + climb(n - 2, arr);
            return arr[n];
        }
        public int climbStairs(int n) {
            if(n == 0) return 0;
            else if(n == 1) return 1;
            else if(n == 2) return 2;

            int[] arr = new int[n + 1];
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            return climb(n, arr);
        }
// Sol 3.
        // public int climbStairs(int n) { // TLE...
            
        //     if(n == 0) return 0;
        //     else if(n == 1) return 1;
        //     else if(n == 2) return 2; // 2, 1+1

        //     int res = climbStairs(n - 1) + climbStairs(n - 2);
        //     return res;
        // }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(1));
    }
}

// 4 = 1 + 3
// 3 = 2 + 1
// 2 = 1 + 1 or 2