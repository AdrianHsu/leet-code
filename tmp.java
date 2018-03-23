import java.util.Scanner;

public class tmp {
    private static class Solution {
        public int distance(String s1, String s2) {
            int res = 0;
            int l1 = s1.length();
            int l2 = s2.length();

            for(int i = 0; i < (l1 - l2 + 1); i++) {
                for(int j = 0; j < l2;j ++) {
                    char c1 = s1.charAt(i + j);
                    char c2 = s2.charAt(j);
                    if(c1 != c2) res++;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.next();//"aab";
        String s2 = scanner.next();//"aba";
        System.out.println(new Solution().distance(s1, s2));
    }
}
