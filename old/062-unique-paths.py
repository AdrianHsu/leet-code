class Solution:
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """

        # 我需要 2-D array 紀錄每格的值
        # https://stackoverflow.com/questions/2397141/how-to-initialize-a-two-dimensional-array-in-python
        foo = 0
        grid = [[foo for j in range(n)] for i in range(m)]
        for i in range(m):
            for j in range(n):

                if i == 0 or j == 0:
                    grid[i][j] = 1
                else:
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1]
        return grid[m - 1][n - 1]
        
s = Solution()
print(s.uniquePaths(3, 3))