/**
 * 142. 环形链表 II
 * 题意：如果链表有环，则返回入环的第一个节点，否则返回-1
 */
public class P0142 {
    public static void main( String[] args ) {

    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode( int x ) {
            val = x;
            next = null;
        }
    }
    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            int pos = -1;
            ListNode p1 = head,p2 = head;
            boolean with_cycle = false;
            while(p2!=null && p1!=null && p1.next!=null){
                p2 = p2.next;
                p1 = p1.next.next;
                if(p2 == p1){
                    with_cycle=true;//find cycle
                    break;
                }
            }
            if ( !with_cycle )return null;
            while(head!=p2){
                head = head.next;
                p2 = p2.next;
            }
            return head;
        }
    }
}
