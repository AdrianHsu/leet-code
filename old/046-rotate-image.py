class Solution:
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        # transpose
        for i in range(n):
            for j in range(i + 1, n):
                tmp = matrix[i][j] # just a swap
                matrix[i][j] = matrix[j][i] 
                matrix[j][i] = tmp
        # flip horizontally
        for i in range(n):
            for j in range(int(n/2)):
                tmp = matrix[i][j]
                matrix[i][j] = matrix[i][n - 1 - j]
                matrix[i][n - 1- j] = tmp


        
s = Solution()
m = [
  [1,2,3],
  [4,5,6],
  [7,8,9]
]
s.rotate(m)
print(m)