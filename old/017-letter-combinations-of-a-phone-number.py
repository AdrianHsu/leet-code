class Solution:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        d = {}
        d['2'] = "abc"
        d['3'] = "def"
        d['4'] = "ghi"
        d['5'] = "jkl"
        d['6'] = "mno"
        d['7'] = "pqrs"
        d['8'] = "tuv"
        d['9'] = "wxyz"
        d['1'] = None
        d['*'] = None
        d['0'] = None
        d['#'] = None
        leng = len(digits)
        if leng == 0:
            return []

        def dfs(st, i, cum):
            if cum > leng:
                return
            elif cum == leng:
                result.append(st)
                return
            else:
                for i in range(i, len(digits)):
                    value = d[digits[i]]
                    for j in range(0, len(value)):
                        char = value[j]
                        tmp = st
                        tmp += char
                        dfs(tmp, i + 1, cum + 1)
        result = []
        st = ""
        dfs(st, 0, 0)
        return result
        
if __name__ == '__main__':
    print(Solution().letterCombinations("234"))