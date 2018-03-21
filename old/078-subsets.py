class Solution:
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        def dfs(i, arr):
            res.append(arr[:])
            for i in range(i, len(nums)):
                arr.append(nums[i])
                dfs(i + 1, arr)
                arr.pop()

        i = 0
        arr = []
        dfs(i, arr)
        return res
        
s = Solution()
print(s.subsets([1, 2, 3]))