import java.util.*;

public class P5 {
    public static class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            int max = 0;
            char last = '';

            for(int i = 0; i < s.length(); i++) {
                Stack<Character> st = new Stack<>();
                for(int j = i; j < s.length(); j++) {
                    
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "cbbd"; // 回文
        System.out.println(s.longestPalindrome(str));

    }
}
