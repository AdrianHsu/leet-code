public class P581 {
    public static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int begin = 0, end = -1;
            int min = nums[n - 1], max = nums[0];
            for(int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[n - 1 - i]);
                if( nums[i] < max ) end = i;
                if( nums[n - 1 - i] > min ) begin = n - 1 - i;
            }
            return end - begin + 1;
        }
    }
    public static void main(String[] args) {
        // 1, 3, 2, 4, 5 -> end is 2, begin is 3
        System.out.println(new Solution().findUnsortedSubarray(new int[] {1, 2, 3, 3, 3}));
        // System.out.println(new Solution().findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
    }
}
