        # 從左出發、也從右出發，跟 container 那題一樣
        # 先看一小部分：
        # 如果目前遇到最高的是 l，那假設現在這格是比 l 小，則多出來的就是 max_l - height[l]
        # 如果待會遇到的還是比最高的 l 還矮，那就一樣，算多出來的
        # 如果遇到更高的，那就結算剛剛結果，然後把 max_l 換掉，待會的格子都用新的 max_l 來相減

        # 同理，從右邊過來也是這樣，遇到最高的是 r，
        # 直到 l >= r 就是結束
        
        # 那為什麼要 if height[l] <= height[r] ？
        # 想 [2, 0, 3]
        # 答案是 2，因為是用 lower 的高來算面積，比 3 大更多的數字最後都還是 2
        # 所以現在 height[l] <= height[r]，待會就把 l++，然後算他跟 max_l 差多少，就結束

        # 那為什麼先判 if height[l] <= height[r] 才判 if height[l] > max_l
        # 要先挑出哪邊 height 較小，然後從那邊往中間靠，
        # 挑出走哪邊後才要討論多出來的面積怎麼算

class Solution:
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l = 0
        r = len(height) - 1
        max_l = 0
        max_r = 0
        re = 0


        while l < r:
            if height[l] <= height[r]:
                if height[l] > max_l:
                    max_l = height[l]
                else:
                    re += max_l - height[l]
                l += 1
            else:
                if height[r] > max_r:
                    max_r = height[r]
                else:
                    re += max_r - height[r]
                r -= 1
        return re

s = Solution()
print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1]))