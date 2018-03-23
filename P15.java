import java.util.*;

public class P15 { // 很多例外要小心
    public static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length;
            if(length <= 2) return res;

            for(int i = 0; i < length - 2; i++) {
                if(i == 0 || i > 0 && nums[i] != nums[i - 1]) { // 如果有 [-1, -1, 0, 1, 2] 不能抓兩次 [-1, 0, 1] 
                    int l0 = i + 1;
                    int r0 = length - 1;
                    while(l0 < r0) {
                        if(nums[l0] + nums[r0] + nums[i] < 0) {
                            l0++;
                        } else if (nums[l0] + nums[r0] + nums[i] > 0) {
                            r0--;
                        } else {
                            res.add(Arrays.asList(nums[i], nums[l0], nums[r0]));
                            while(l0 + 1 < r0 && nums[l0] == nums[l0 + 1]) l0++; // 不能重複的 [a, b, c]
                            while(r0 - 1 > l0 && nums[r0] == nums[r0 - 1]) r0--;
                            l0++;
                            r0--;
                        }
                    }
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        int[] a = {-4, -1, -1, 0, 1, 2};
        // int [] a = {-1, -1, 2};
        // int[] a = {0, 0};
        System.out.println(new Solution().threeSum(a));
    }
}
