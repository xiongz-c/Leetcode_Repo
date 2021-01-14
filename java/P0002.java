/**
 * P0002:Add Two Numbers
 * 题意：链表相加
 * 注意处理进位
 */

public class P0002 {
    public static void main( String[] args ) {
        ListNode a = new ListNode( 2 );
        a.next = new ListNode( 4 );
        a.next.next = new ListNode( 3 );
        ListNode b = new ListNode( 5 );
        b.next = new ListNode( 6 );
        b.next.next = new ListNode( 4 );
        Solution sol = new Solution( );
        System.out.println( sol.addTwoNumbers( a , b ).val );
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode( int val ) {
            this.val = val;
        }

        ListNode( int val , ListNode next ) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers( ListNode l1 , ListNode l2 ) {
            if ( l1 == null && l2 == null ) return new ListNode( );
            else if ( l1 == null ) return l2;
            else if ( l2 == null ) return l1;
            boolean flag = false;
            ListNode head = new ListNode( );
            ListNode ans = head;
            while (l1 != null && l2 != null) {
                ans.next = new ListNode( );
                ans = ans.next;
                if ( flag ) {
                    if ( l1.val + l2.val + 1 > 9 ) {
                        ans.val = ( ( l1.val + l2.val + 1 ) % 10 );
                    } else {
                        ans.val = ( l1.val + l2.val + 1 );
                        flag = false;
                    }
                } else {
                    if ( l1.val + l2.val > 9 ) {
                        ans.val = ( ( l1.val + l2.val ) % 10 );
                        flag = true;
                    } else {
                        ans.val = ( l1.val + l2.val );
                    }
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                ans.next = new ListNode( );
                ans = ans.next;
                if ( flag ) {
                    if ( l1.val + 1 > 9 ) {
                        ans.val = ( ( l1.val + 1 ) % 10 );
                    } else {
                        ans.val = ( l1.val + 1 );
                        flag = false;
                    }
                } else {
                    if ( l1.val > 9 ) {
                        ans.val = ( ( l1.val  ) % 10 );
                        flag = true;
                    } else {
                        ans.val = ( l1.val  );
                    }
                }
                l1 = l1.next;
            }
            while (l2 != null) {
                ans.next = new ListNode( );
                ans = ans.next;
                if ( flag ) {
                    if ( l2.val + 1 > 9 ) {
                        ans.val = ( ( l2.val + 1 ) % 10 );
                    } else {
                        ans.val = ( l2.val + 1 );
                        flag = false;
                    }
                } else {
                    if ( l2.val > 9 ) {
                        ans.val = ( ( l2.val  ) % 10 );
                        flag = true;
                    } else {
                        ans.val = ( l2.val  );
                    }
                }
                l2 = l2.next;
            }
            if(flag){
                ans.next = new ListNode( 1 );
                ans = ans.next;
            }
            return head.next;
        }
    }
}
