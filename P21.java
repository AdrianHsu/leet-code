public class P21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            
            if(l1 == null && l2 == null) return null;
            else if(l1 == null) return l2;
            else if(l2 == null) return l1;

            ListNode prev = null;
            ListNode root = null;
            boolean init = true;
            while(!(l1 == null && l2 == null)) {
                ListNode l = null;
                if(l1 == null) {
                    l = new ListNode(l2.val);
                    l2 = l2.next;
                } else if(l2 == null) {
                    l = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    if(l1.val >= l2.val) {
                        l = new ListNode(l2.val);
                        l2 = l2.next;
                    } else {
                        l = new ListNode(l1.val);
                        l1 = l1.next;
                    } 
                }
                if(init) {
                    prev = l;
                    root = prev;
                    init = false;
                }
                else {
                    prev.next = l;
                    prev = l;
                }
            }
            return root;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(0);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        ListNode r = new Solution().mergeTwoLists(l1, l4);
        System.out.println(r.val);
        System.out.println(r.next.val);
        System.out.println(r.next.next.val);
        System.out.println(r.next.next.next.val);

    }
}
