class P0234{
    public static void main(String[] args) {
        
    }
    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
 
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head==null || head.next==null)return true;
            Deque<ListNode> dq = new LinkedList<>();
            ListNode tail = head;
            int len = 0;
            while(tail!=null){
                len++;
                tail = tail.next;    
            }
            tail = head;
            int half = len/2;
            while(half-->0){
                dq.addLast(tail);
                tail = tail.next;
            }
            if(len%2==1)tail = tail.next;
            while(tail!=null){
                if(tail.val==dq.removeLast().val)tail = tail.next;
                else return false;    
            }
            return true;
        }
    }
}