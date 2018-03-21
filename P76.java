// Sliding Window
import java.util.*;


public class P76 {

    public static class Solution {
        public String minWindow(String s, String t) {
            String res = "";
            String tmp = "";
            HashMap tMap = new HashMap<Character, Integer>();
            for(int i = 0; i < t.length(); i++) {  
                mapModify(tMap, t.charAt(i), +1);
            }
            int total = t.length();
            int cnt = 0;
            boolean init = true; // to make left = i for the first time
            boolean init2 = true; // to make sure String res is correct for the first time
            HashMap sMap = new HashMap<Character, Integer>();

            for(int i = 0, left = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!tMap.containsKey(c)) continue;
                if(init) {
                    init = false;
                    left = i;
                }

                mapModify(sMap, c, +1);
                if((int)sMap.get(c) <= (int)tMap.get(c)) {
                    cnt++;
                } else {
                    // do nothing
                }
                while(cnt == total) {
                    tmp = s.substring(left, i + 1);
                    if(init2) {
                        res = tmp;
                        init2 = false;
                    }
                    if(tmp.length() < res.length())
                        res = tmp;
                    mapModify(sMap, s.charAt(left), -1);
                    if((int)sMap.get(s.charAt(left)) < (int)tMap.get(s.charAt(left)))
                        cnt --;

                    left ++;
                    while(left <= i && !tMap.containsKey(s.charAt(left)))
                        left++;
                }
            }

            return res;
        }
        public void mapModify(HashMap<Character, Integer> map, char c, int num) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int n = map.get(c);
                map.put(c, n + num);
            }
        }
    }
    public static void main(String[] args) {
        // String s = "ADOBECODEBANC";
        // String t = "ABC";
        String s = "A";
        String t = "AA";
        System.out.println(new Solution().minWindow(s, t)); // "BANC"
    }
}
