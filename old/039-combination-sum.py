class Solution:
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        def dfs(l, i, cum):
            if cum > target:
                return
            elif cum == target:
                result.append(l)
                return
            else:
                for i in range(i, len(candidates)):
                    tmp = l.copy()
                    tmp.append(candidates[i])
                    # print(tmp)
                    dfs(tmp, i, cum + candidates[i])
        l = []
        dfs(l, 0, 0)
        return result

if __name__ == '__main__':
    print(Solution().combinationSum([2,3,6,7], 7))