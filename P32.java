import java.util.*;

public class P32 {
    public static class Solution {
        public int longestValidParentheses(String s) {
            // it stores the longest length of valid parentheses which is end at i.
            if(s.length() == 0) return 0;
            int [] dp = new int [s.length()];
            int max = 0;
            dp[0] = 0;
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == '(') {
                    dp[i] = 0;
                    continue;
                }
                // char is : ')'
                if(s.charAt(i - 1) == '(') {
                    if(i >= 2)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2;
                    max = Math.max(dp[i], max);
                } else {
                    if( (i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        if(i - dp[i - 1] - 2 >= 0)
                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]; // 最近的一串接上來，加上本身，加上第二近的一串
                        else
                            dp[i] = dp[i - 1] + 2 + 0;
                        max = Math.max(dp[i], max);
                    } else dp[i] = 0;
                }
                // System.out.println(dp[i] + "," + i);
            }
            return max;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()()(()))"));//("()()(()))")); // ((()(()))
    }
}
