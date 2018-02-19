# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        result = ListNode(0)
        dummy = ListNode(0)
        dummy.next = result
        while True:
            v1 = 0
            v2 = 0
            ten = result.val
            if l1 is not None:
                v1 = l1.val
                l1 = l1.next
            if l2 is not None:
                v2 = l2.val
                l2 = l2.next
            total = v1 + v2 + ten
            v = 0
            if total > 9:
                ten = 1
                v = total % 10
            else:
                ten = 0
                v = total
            result.val = v

            if l1 is None and l2 is None:
                if ten != 0:
                    result.next = ListNode(ten)
                    result = result.next
                break

            result.next = ListNode(ten)
            result = result.next

        return dummy.next

if __name__ == '__main__':
    # a, a.next, a.next.next = ListNode(2), ListNode(4), ListNode(3)
    # b, b.next, b.next.next = ListNode(5), ListNode(6), ListNode(4)
    # result = Solution().addTwoNumbers(a, b)
    # print("{0} -> {1} -> {2}".format(result.val, result.next.val, result.next.next.val))

    # a, a.next, a.next.next = ListNode(2), ListNode(4), ListNode(3)
    # b, b.next = ListNode(5), ListNode(6)
    # result = Solution().addTwoNumbers(a, b)
    # print("{0} -> {1} -> {2}".format(result.val, result.next.val, result.next.next.val))

    # a, a.next = ListNode(1), ListNode(8)
    # b = ListNode(0)
    # result = Solution().addTwoNumbers(a, b)
    # print("{0} -> {1}".format(result.val, result.next.val))

    a, a.next = ListNode(9), ListNode(9)
    b = ListNode(1)
    result = Solution().addTwoNumbers(a, b)
    print("{0} -> {1} -> {2}".format(result.val, result.next.val, result.next.next.val))