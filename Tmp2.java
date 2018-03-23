import java.util.*;

public class Tmp2 {
    private static class Solution {



        public String done(String s) {
            String res = "";
            int[] arr = new int [10];
            for(int i = 0; i < s.length(); i++) {
                int c = (int)s.charAt(i) - 48;
                arr[c]++;
            }
            for(int i = 1; i < 10; i++) {
                if(arr[i] == 0){
                    char c = (char)(i + 48);
                    String tt = "";
                    tt += c;
                    return tt;
                } 
            }

            return res;
        }
    }
    public static void main(String[] args) {
        String s = "123456789";
        // Scanner scanner = new Scanner(System.in);
        // String s = scanner.next();//"aab";
        System.out.println(new Solution().done(s));
    }
}
