import math

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # round(9/2) is 4

        l1 = nums1
        l2 = nums2

        if len(l1) + len(l2) == 0:
            return 0.0

        left = 0 # element num of left
        right = 0 # element num of right

        left_fin = 0
        right_fin = 0

        if ( len(l1) + len(l2) ) % 2 == 1:
            left_fin = math.floor((len(l1) + len(l2)) / 2)
            right_fin = left_fin

            if len(l1) == 0:
                return float(l2[left_fin])
            elif len(l2) == 0:
                return float(l1[left_fin])
        else:
            right_fin = int(((len(l1) + len(l2)) / 2) - 1)
            left_fin = right_fin
            if len(l1) == 0:
                return float( (l2[left_fin] + l2[left_fin + 1]) / 2)
            elif len(l2) == 0:
                return float( (l1[left_fin] + l1[left_fin + 1]) / 2)

        for i in range(0, 10):
            odd1 = False
            odd2 = False
            r1 = math.floor(len(l1) / 2)
            r2 = math.floor(len(l2) / 2)

            if len(l1) % 2 == 1:
                odd1 = True
            if len(l2) % 2 == 1:
                odd2 = True


            if l1[r1] < l2[r2]:
                if odd1 == True:
                    left += r1
                    l1 = l1[r1:]
                else:
                    left += r1 - 1 
                    l1 = l1[(r1-1):]
                if odd2 == True:
                    right += r2
                    l2 = l2[:(r2+1)]
                else:
                    right += r2
                    l2 = l2[:r2]


            elif l1[r1] > l2[r2]:
                if odd2 == True:
                    left += r2
                    l2 = l2[r2:]
                else:
                    left += r2 - 1 
                    l2 = l2[(r2-1):]
                if odd1 == True:
                    right += r1
                    l1 = l1[:(r1+1)]
                else:
                    right += r1
                    l1 = l1[:r1]

            else:
                if ( len(l1) + len(l2) ) % 2 == 0:
                    if len(l1) % 2 == 0:
                        if l1[r1] < l2[r2]:
                            return (l1[r1] + l1[r1-1])/2
                        else:
                            return (l1[r1] + l2[r2-1])/2
                    # else:

                return float(l1[r1])

            # print(l1)
            # print(l2)
            # print(left)
            # print(right)
            # print(left_fin)
            # print(right_fin)
            if len(l1) + len(l2) == 3:
                l = []
                l.extend(l1)
                l.extend(l2)
                l.sort()
                if ( len(nums1) + len(nums2) ) % 2 == 0:
                    if right_fin == right:
                        return(l[1] + l[2]) / 2
                    elif left_fin == left:
                        return(l[0] + l[1]) / 2
                    else:
                        return float(l[1])
                else:
                    if right_fin == right:
                        return float(l[2])
                    elif left_fin == left:
                        return float(l[0])
                    else:
                        return float(l[1])
            elif len(l1) + len(l2) == 2:
                l = []
                l.extend(l1)
                l.extend(l2)
                l.sort()
                if ( len(nums1) + len(nums2) ) % 2 == 0:
                    return (l[0] + l[1]) / 2
                else:
                    return float(l[1])
        
s = Solution()
# print(s.findMedianSortedArrays([1,3,5,7,9],[2,4,6,8,10])) 
# print(s.findMedianSortedArrays([5,7], [4,6])) 
# print(s.findMedianSortedArrays([1,3], [2]))
# print(s.findMedianSortedArrays([1, 2], [1, 2]))
# print(s.findMedianSortedArrays([2], []))
# print(s.findMedianSortedArrays([1,1,3,3], [1,1,3,3]))
# print(s.findMedianSortedArrays([1,2,2], [1,2,3]))
# print(s.findMedianSortedArrays([3],[1,2,4])) 
# print(s.findMedianSortedArrays([1],[2,3,4,5])) 
# print(s.findMedianSortedArrays([4],[1,2,3,5])) 
# print(s.findMedianSortedArrays([3],[1,2])) 
print(s.findMedianSortedArrays([1],[2,3,4,5,6])) # GG 