public class P141 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
       }
    }

    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null) {
                fast = fast.next;
                if(fast.next != null)
                    fast = fast.next;
                else
                    break;
                slow = slow.next;
                if(fast == slow)
                    return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        // l4.next = l2;

        System.out.println(new Solution().hasCycle(l2));
    }
}
