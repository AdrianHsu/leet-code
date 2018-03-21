class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        mymax = 0
        for i, c in enumerate(s):
            d = {}
            d[c] = c
            tmp = 1
            j = i + 1
            while j < len(s):
                c = s[j]
                if c in d:
                    break
                else:
                    j += 1
                    tmp += 1
                    d[c] = c
            
            if mymax < tmp:
                mymax = tmp
        return mymax
        
s = Solution()
print(s.lengthOfLongestSubstring('pwwkew'))