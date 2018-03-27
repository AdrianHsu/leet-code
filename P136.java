
public class P136 {
    public static class Solution {
        public int singleNumber(int [] nums) {
            for(int i = 1; i < nums.length; i ++)
                nums[i] = nums[i - 1] ^ nums[i];
            return nums[nums.length - 1];
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int []{2, 3, 5, 5, 6, 2, 6}));
    }
}
