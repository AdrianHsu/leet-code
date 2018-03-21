public class P2 {
    public static class ListNode {
       int val;
       ListNode next; // default is null
       ListNode(int x) { val = x; }
    }
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int v = 0, ten = 0;
            ListNode start = null, prev = null;
            while(l1 != null || l2 != null) {
                v = ten;
                if(l1 != null)
                    v += l1.val;
                if(l2 != null)
                    v += l2.val;
                if(v >= 10) {
                    ten = 1;
                    v -= 10;
                } else
                    ten = 0;
                
                ListNode l = new ListNode(v);
                if(start == null) {
                    prev = l;
                    start = prev;
                } else {
                    prev.next = l;
                    prev = l;
                }
                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }
            if(ten == 1) {
                ListNode l = new ListNode(ten);
                prev.next = l;
                prev = l;
            }
            return start;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;        
        Solution s = new Solution();
        ListNode l = s.addTwoNumbers(l1, l4);
        System.out.println(l.val);
        System.out.println(l.next.val);
        System.out.println(l.next.next.val);
    }
}
