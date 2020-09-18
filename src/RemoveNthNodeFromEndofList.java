/***
 * Index: 19
 * Difficulty: Medium
 * Related Topic: Linked List, Two Pointers
 */

/***
 * 解法一：两个指针（正确）
 * 稍微注意一下如果first已经走完了，因为first已经移动到first.next，所以应该是判断first是否为null
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        for(int i = 0; i < n; i++){
            first = first.next;
        }
        ListNode second = head;
        if(first == null)
            return head.next;
        while(first.next !=null){
            first = first.next;
            second = second.next;
        }
        if(n > 0)
            second.next = second.next.next;
        return head;
    }
}
