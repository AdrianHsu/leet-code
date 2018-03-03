import math

class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if len(s) == 0:
            return ""
        if numRows == 1:
            return s
        if numRows == 2:
            down = ""
            up = ""
            for i in range(0, len(s)):
                if i % 2 == 0:
                    up += s[i]
                else:
                    down += s[i]
            s = up + down
            return s


        tot = []

        iternum = math.floor(len(s) / (numRows+(numRows - 2)))

        shift = 0
        for it in range(0, iternum):
            a = []
            for i in range(0, numRows):
                a.append(s[shift + i])
            tot.append(a)
            shift += numRows
            b = []
            for i in range(0, numRows - 2):

                b.append(s[shift + i])
            tot.append(b)
            shift += numRows - 2
        
        mod = len(s) % (numRows+(numRows - 2))
        if mod < numRows:
            a = []
            for i in range(0, mod):
                a.append(s[shift + i])
            tot.append(a)
            shift += mod
        else: 
            a = []
            for i in range(0, numRows):
                a.append(s[shift + i])
            tot.append(a)
            shift += numRows
            b = []
            for i in range(0, mod - numRows):
                b.append(s[shift + i])
            tot.append(b)
            shift += mod - numRows
        # print(tot)            

        # result = []
        s = ""
        for i in range(0, numRows):
            for j in range(0, len(tot)):
                if j % 2 == 0:
                    # full column
                    if len(tot[j]) > i:
                        s += (tot[j][i])
                else:
                    if i >= 1 and i <= numRows - 2:
                        if len(tot[j]) > numRows - 2 - i:
                            s += (tot[j][numRows - 2 - i])
        return s

s = Solution()
# print(s.convert("PAYPALISHIRING", 5))
print(s.convert("A", 3))