import java.util.*;

public class P139 {
    public static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1]; // all false by default
            // dp[i] s.substring(0, i) can be segmented 
            Set<String> set = new HashSet<>();
            set.addAll(wordDict);

            dp[0] = true;
            for(int i = 1; i <= n; i ++) {
                for(int j = i - 1; j >= 0; j --) {
                    dp[i] = dp[j] && set.contains(s.substring(j, i)); // substring(0, j) 且 substring(j, i) 均可以被 segmented，則 dp[i] = true
                    if(dp[i]) break;
                }
            }
            return dp[n];
        }
        // public boolean backtrack(List<String> w, String s, String now) {
        //     int now_len = now.length();
        //     if(s.length() <= now_len) {
        //         if(s.equals(now))
        //             return true;
        //         else return false;
        //     }
        //     String sub = s.substring(0, now_len);
        //     if(!sub.equals(now)) {
        //         return false;
        //     }

        //     for(int i = 0; i < w.size(); i++) {

        //         String tmp = w.get(i);
        //         if(backtrack(w, s, now + tmp)) {
        //             return true;
        //         }
        //     }
        //     return false;
        // }

        // public boolean wordBreak(String s, List<String> wordDict) {
        //     String now = "";
        //     return backtrack(wordDict, s, now);
        // }
    }
    public static void main(String[] args) {
        List<String> w = new ArrayList<>();
        // w.add("code");
        // w.add("leet");
        // w.add("haha");
        // w.add("ya");
        // System.out.println(new Solution().wordBreak("leetcodehaha", w));
        w.add("a");
        w.add("b");
        w.add("bbb");
        w.add("bbbb");
        System.out.println(new Solution().wordBreak("bb", w));
    }
}
