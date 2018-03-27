public class P19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head.next == null) return null;
            ListNode del = head;
            ListNode prev = head;
            ListNode runner = head;
            // me.next = null;
            // System.out.println(head.next); // null !!
            
            for(int i = 0; i < n - 1; i++)
                runner = runner.next;
            while(runner != null) {
                runner = runner.next;
                if(runner == null) break;
                prev = del;
                del = del.next;
            }
            if(del == head) head = head.next;
            prev.next = del.next;
            return head;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(new Solution().removeNthFromEnd(l1, 2).val);
    }
}
