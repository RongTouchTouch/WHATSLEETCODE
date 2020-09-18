/***
 * Index: 12
 * Difficulty: Easy
 * Related Topic: Linked List
 */

/***
 * 解法一：（正确）
 * 思路是把通过修改l1和l2里节点的指针，把两个list直接穿在一起。
 * 注意.next==null的判断，我每次都搞不清楚什么时候该查next什么时候该查当前节点。
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        if(l1.val < l2.val)
            root = l1;
        else
            root = l2;

        ListNode cur = root;

        while(l1!=null && l2!=null){
            ListNode temp;
            if(l1.val < l2.val){
                temp = l1;
                l1 = l1.next;
                cur.next = temp;
            }
            else {
                temp = l2;
                l2 = l2.next;
                cur.next = temp;
            }
            cur = cur.next;
        }
        if(l1 != null)
            cur.next = l1;
        if(l2 != null)
            cur.next = l2;
        return root;
    }
}
