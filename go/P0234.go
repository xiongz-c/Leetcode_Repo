//题意：判断回文链表，要求时间On空间O1
//题解：快慢指针，到一半的时候反转后半段链表。
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func isPalindrome(head *ListNode) bool {
    if head == nil || head.Next == nil{
        return true
    }
    slow,fast := head,head
    for fast!=nil && fast.Next!=nil{
        fast = fast.Next.Next
        slow = slow.Next
    }
    var pre,now,nxt *ListNode
    now = slow
    for now!=nil{
        nxt = now.Next
        now.Next = pre
        pre = now
        now = nxt
    }
    beg := pre
    for head!=nil && beg!=nil && beg!=head{
        if head.Val!=beg.Val{
            return false
        }
        head = head.Next
        beg = beg.Next
    }
    return true
}