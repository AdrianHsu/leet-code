import java.util.*;
public class P3 {
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            int max = 0;

            if( len == 0 ) return 0;
            else if(len == 1) return 1;
            HashMap m = new HashMap<Character, Integer>();
            
            int l = 0;
            for(int r = 0; r < len; r ++)
                char c = s.charAt(r);
                if(m.containsKey(c) && (int)m.get(c) >= l) {
                    max = Math.max(max, r - l);
                    l = (int)m.get(c) + 1;
                } else {
                    max = Math.max(max, r - l + 1);
                }
                m.put(c, r); // it will override!
            }

            // int max=0;
            // int r = 0, l = 0;
            // while(r < len) {
            //     char c = s.charAt(r);
            //     if (m.containsKey(c)){
            //         l = Math.max(l, m.get(c) + 1);
            //     }
            //     m.put(c,r);
            //     max = Math.max(max, r - l + 1);
            //     r += 1;
            // }

            return max;
        }
    }
    public static void main(String[] args) {
        // StringBuffer s = new StringBuffer("pwwkew");
        // String s = "qojoi29b0xoij";
        // String s = "pwwkew";
        String s = "dbbckc";
        int a = new Solution().lengthOfLongestSubstring(s);
        System.out.println(a);
    }
}
