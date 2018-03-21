import math
# https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/share-my-ologminmn-solution-with-explanation
class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # math.floor(9/2) is 4

        A = nums1
        B = nums2
        if len(A) > len(B):
            A = nums2
            B = nums1
        m, n = len(A), len(B)
        half = math.floor((m+n+1)/2)
        imin, imax = 0, m
        while imin <= imax:
            i = math.floor((imin + imax) / 2)
            j = half - i
            if i < m and B[j-1] > A[i]:
                imin = i + 1
            elif i > 0 and A[i-1] > B[j]:
                imax = i - 1
            else:
                if i == 0:
                    max_left = B[j-1]
                elif j == 0:
                    max_left = A[i-1]
                else:
                    max_left = max(A[i-1], B[j-1])
                if (m + n) % 2 == 1:
                    return max_left

                if i == m:
                    min_right = B[j]
                elif j == n:
                    min_right = A[i]
                else:
                    min_right = min(A[i], B[j])
                return (max_left + min_right) / 2.0

def test(l1, l2):
  print('input: l1:{} l2:{}'.format(l1,l2))
  print(Solution().findMedianSortedArrays(l1,l2))

if __name__ == '__main__':
  # test([2], [])
  # test([1,2,3],[4,5,6])
  test([1,2],[3,4,5])
  test([1,2],[3,4,5,6])
  test([1,2],[3,4,5,6,7])
  test([2,4],[1,3,5])
  test([9,10],[2,4,6])
