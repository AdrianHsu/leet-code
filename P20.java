import java.util.*;

public class P20 {

    public static class Solution {
        public boolean isValid(String s) {
            if(s.length() == 0) return true;
            else if(s.length() == 1) return false;

            Stack<Character> st = new Stack<>();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(st.empty()) {
                    st.push(c);
                    continue;
                }

                char peek_inv = inv(st.peek());
                if(peek_inv == c) 
                    st.pop();
                else
                    st.push(c);
            }
            if(st.empty()) return true;
            else return false;
        }
        public char inv(char c) {
            if(c == '(') return ')';
            else if (c == ')') return '(';
            else if (c == '{') return '}';
            else if (c == '}') return '{';
            else if (c == '[') return ']';
            else if (c == ']') return '[';
            else return 0;    
        }
    }
    public static void main(String[] args) {
        // String s = "([{[[()]{}]}])";
        // String s = "({}[([)])";
        String s = "()[]";
        System.out.println(new Solution().isValid(s));
    }
}
