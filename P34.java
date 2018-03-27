import java.util.*;
public class P34 {
    public static class Solution {
        public int[] searchRange(int[] nums, int t) {
            int l = 0, r = nums.length - 1;
            int[] ran = new int[2];
            ran[0] = -1;
            ran[1] = -1;
            while(l <= r) {
                int mid = (l + r) >> 1;
                if(nums[mid] == t) {
                    
                    if(mid - 1 >= 0 && nums[mid - 1] == t){
                        r = mid - 1;
                    } else {
                        ran[0] = mid;
                        break;
                    }
                } else if(nums[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            l = 0;
            r = nums.length - 1;
            while(l <= r) {
                int mid = (l + r) >> 1;
                if(nums[mid] == t) {
                    
                    if(mid + 1 < nums.length && nums[mid + 1] == t){
                        l = mid + 1;
                    } else {
                        ran[1] = mid;
                        break;
                    }
                } else if(nums[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ran;
        }
    }
    public static void main(String[] args) {
        int[] a = new Solution().searchRange(new int[]{5, 6, 7, 7, 8, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(a));
    }
}
