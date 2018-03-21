# https://leetcode.com/problems/container-with-most-water/discuss/6150/For-someone-who-is-not-so-clear-on-this-question



import math

class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l = 0
        r = len(height) - 1
        result = 0

        # 如果 l 不動，r 動的話，如果 l 比當前的 r 短，則 r-- 的地方，儘管 r 可能變長可能變短，
        # 但不管 r 變長還是用 l 當高、 r 變短則是用 r 當高，結果都一定比原本的 r 乘出來的面積小

        # 同理，如果 r 不動， l 動的話，...
        

        while l < r:
            area = 0
            if height[l] < height[r]:
                area = height[l] * (r - l)
                l += 1
            else:
                area = height[r] * (r - l)
                r -= 1

            result = max(result, area)

        return result



s = Solution()
print(s.maxArea([1, 3, 8, 5, 12, 4])) 
# 3~4 -> 3 * 4 = 12
# 8~4 -> 3 * 4 = 12
# 8~12 -> 8 * 2 = 16
print(s.maxArea([1, 1]))

# 使 底＊高最大
# 找最高的前兩根、只要 O(n) 但底可能很短
# 從兩側往中間縮，可考慮底最大的狀況、然後底慢慢變小
# 應該靠左縮還是靠右縮
# 體積只要看第二高的＊底，第一高反而沒用到
# 最高的不一定會被用過
