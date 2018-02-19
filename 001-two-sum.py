class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        app = {}
        for i, n in enumerate(nums):
        	re = target - n
        	if re in app:
        		return [app[re], i]
        	else:
        		app[n] = i

s = Solution()
print(s.twoSum([3, 2, 4], 6)) #[1, 2]
print(s.twoSum([3, 3], 6)) #[0, 1]
print(s.twoSum([1, 2, 8, 11, 15], 9)) #[0, 2]