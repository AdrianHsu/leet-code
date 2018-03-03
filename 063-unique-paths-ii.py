class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        foo = 0
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        grid = [[foo for j in range(n)] for i in range(m)]
        
        for j in range(0, n):
            if j == 0:
                if obstacleGrid[0][j] == 1:
                    grid[0][j] = 0
                else:
                    grid[0][j] = 1
            else:
                if obstacleGrid[0][j] == 1:
                    grid[0][j] = 0
                else:
                    grid[0][j] = grid[0][j - 1]

        for i in range(0, m):
            if i == 0:
                if obstacleGrid[i][0] == 1:
                    grid[i][0] = 0
                else:
                    grid[i][0] = 1
            else:
                if obstacleGrid[i][0] == 1:
                    grid[i][0] = 0
                else:
                    grid[i][0] = grid[i - 1][0]

        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    grid[i][j] = 0
                else:
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j]
        return grid[m - 1][n - 1]

s = Solution()
print(s.uniquePathsWithObstacles([[0,0,0],
  [0,1,0],
  [0,0,0]]))