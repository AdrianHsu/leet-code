import java.util.*;

public class BinarySearch {
    public static class Solution {

        public int recursive(int[] arr, int t, int l, int r) {
            if(l > r) return -1;

            int mid = (l + r) >> 1;
            int res = -1;
            if(arr[mid] == t) {
                return t;
            } else if (arr[mid] < t) {
                res = recursive(arr, t, mid + 1, r);
            } else {
                res = recursive(arr, t, l, mid - 1);
            }
            return res;
        }

        public int binarySearch(int[] arr, int t) {
            return recursive(arr, t, 0, arr.length - 1);
        }

        
        // public int binarySearch(int [] arr, int t) {
        //     int res = -1;
        //     int l = 0, r = arr.length - 1;
        //     while(l <= r) {
        //         int mid = (l + r) >> 1;
        //         if(arr[mid] == t) {
        //             res = t;
        //             break;
        //         } else if (arr[mid] < t) {
        //             l = mid + 1;
        //         } else {
        //             r = mid - 1;
        //         }
        //     }
        //     return res;
        // }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().binarySearch(new int[]{1, 3, 5, 8, 9, 11, 25}, 11));
    }
}
