import java.util.*;

public class P22 {
    public static class Solution {
        public void backtrack(List<String> res, String s, int n, int open, int close){
            if(close > open) return;

            if(s.length() == 2 * n) {
                if(open == n && close == n) {
                    String copy = new String(s);
                    res.add(copy);
                }
                return;
            }
            backtrack(res, s + '(', n, open + 1, close);
            backtrack(res, s + ')', n, open, close + 1);            
        }
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            String s = "";
            backtrack(res, s, n, 0, 0);
            return res;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(4));
    }
}
