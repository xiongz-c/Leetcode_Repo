class P0019{

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(new Solution().removeNthFromEnd(head,1));
    }

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head.next==null && n == 1)return null;
            ListNode nxt = head;
            ListNode now = head;
            int k = n;
            while(k-->0){
                nxt = nxt.next;
            }
            if(nxt==null){
                head = head.next;
                return head;
            }
            while(nxt.next!=null){
                now = now.next;
                nxt = nxt.next;
            }
            now.next = now.next.next;
            return head;
        }
    }
}