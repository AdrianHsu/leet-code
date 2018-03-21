import java.util.*;

public class P5 {
    public static class Solution {
        public String expandEven(String s, int l, int r){
            String tmp = s.substring(l, l + 1);
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                tmp = s.substring(l, r + 1);
                l--;
                r++;
            }
            return tmp;
        }
        public String expandOdd(String s, int i) {
            int l = i - 1;
            int r = i + 1;
            String tmp = s.substring(i, i + 1);
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                tmp = s.substring(l, r + 1);
                l--;
                r++;
            }
            return tmp;
        }
        public String longestPalindrome(String s) {
            int len = s.length();
            if(len == 0) return "";
            else if(len == 1) return s;

            String res = "";
            for(int i = 1; i < s.length(); i++) {
                String odd = expandOdd(s, i - 1);
                String even = expandEven(s, i - 1, i);
                String bigger = odd.length() > even.length() ? odd : even;
                if(res.length() < bigger.length())
                    res = bigger;
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "ababaxxxa9sik"; // 回文, even, odd
        System.out.println(s.longestPalindrome(str));
    }
}
