import java.util.*;

public class P15 {
    public static class Solution {

        public List<List<Integer>> threeSum(int[] nums) { // TLEs
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length;
            if(length <= 2) return res;

            
            return res;
        }

        // public List<List<Integer>> threeSum(int[] nums) { // TLEs
        //     List<List<Integer>> res = new ArrayList<>();

        //     Arrays.sort(nums);
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     for(int i = 0; i < nums.length; i++) {
        //         if(!m.containsKey(nums[i])) 
        //             m.put(nums[i], i); // self

        //         for(int j = i + 1; j < nums.length; j++) {
        //             int sum = nums[i] + nums[j];
        //             if(m.containsKey(-sum) && m.get(-sum) != i) {
        //                 List<Integer> s = new ArrayList<>();
        //                 s.add(-sum);
        //                 s.add(nums[i]);
        //                 s.add(nums[j]);
        //                 if(!res.contains(s))
        //                     res.add(s);
        //             } 
        //         }
        //     }
        //     return res;
        // }
    }
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        // int [] a = {-1, -1, 2};
        // int[] a = {0, 0};
        System.out.println(new Solution().threeSum(a));
    }
}
