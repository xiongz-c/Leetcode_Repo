/**
 * P0143.重排列表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
class P0147{
    public static void main(String[] args) {
        
    }
  public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
    static class Solution {
            public void reorderList(ListNode head) {
                if(head==null)return null;
                Deque<ListNode> deque = new LinkedList<>();
                ListNode now = head;
                while(now!=null){
                    deque.addLast(now);
                    now = now.next;
                }
                int idx = 0;
                ListNode newHead = deque.pollFirst();
                while(deque.size()>0){
                    if(idx%2==0)newHead.next = deque.pollLast();
                    else newHead.next = deque.pollFirst();
                    idx++;
                }
                return head;
            }
        }
}