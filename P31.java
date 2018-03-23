import java.util.*;

public class P31 {
    public static class Solution {

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        public void reverse(int [] nums, int i, int j) {
            while(i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        // 1. 從後找到沒有 descending 的點
        // 2. 從後找到比他大的來換
        // 3. 把他以後的都倒過來
        public void nextPermutation(int[] nums) {
            if(nums.length <= 1) return;
            int i = nums.length - 2;
            while(i >= 0 && nums[i] >= nums[i + 1]) i --;            
            if(i >= 0) {
                int j = nums.length - 1;
                while(nums[i] >= nums[j]) j--;
                swap(nums, i, j);
            }
            reverse(nums, i + 1, nums.length - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        new Solution().nextPermutation(nums);
        System.out.println("Result: " + Arrays.toString(nums));
    }
}


// public class P31 {
//     public static class Solution {

//         public void swap(int[] nums, int i, int j) {
//             int tmp = nums[i];
//             nums[i] = nums[j];
//             nums[j] = tmp;
//         }
//         public void perm(int[] nums, int l) {
//             if(l == nums.length - 1) {
//                 System.out.println(Arrays.toString(nums));
//             }
//             for(int i = l; i < nums.length; i++){
//                 swap(nums, i, l);
//                 perm(nums, l + 1);
//                 swap(nums, i, l);
//             }
//         }
//         public void nextPermutation(int[] nums) {
//             perm(nums, 0);
//         }
//     }
//     public static void main(String[] args) {
//         int[] nums = new int[]{1, 2, 3};
//         new Solution().nextPermutation(nums);
//         System.out.println("Result: " + Arrays.toString(nums));
//     }
// }
