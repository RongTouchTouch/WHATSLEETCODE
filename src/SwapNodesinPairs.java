import java.util.List;

/***
 * Index: 24
 * Difficulty: Medium
 * Related Topic: Linked List
 */

/***
 * 解法一：（正确）
 * 思路是将原有的List先拆为两个List，然后再把它们合到一起。
 * 优点是速度很快，缺点是需要存很多head，而且从代码上来看写的也并不优美。
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode head1 = head;
        ListNode head2 = head.next;
        while(l1.next.next!=null && l2.next.next!=null){
            l1.next = l1.next.next;
            l2.next = l2.next.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1.next.next != null)
            l1.next = l1.next.next;
        else
            l1.next = null;
        l2.next = null;

        l1 = head1;
        l2 = head2;
        ListNode result = new ListNode(l2.val);
        ListNode new_result = result;
        int step = 0;
        while(l2.next!=null){
            if(step %2 ==0){
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            }
            else{
                result.next = new ListNode(l2.next.val);
                result = result.next;
                l2 = l2.next;
            }
            step++;
        }
        while(l1 != null){
            result.next = new ListNode(l1.val);
            result = result.next;
            l1 = l1.next;
        }
        return new_result;
    }

}

/***
 * 解法二：迭代（正确）
 * 别人的算法。。应该是相同的原理，能比我短那么多。。
 * 我感觉我把代码写简洁的能力还是不行
 *
 * 他这么写的好处很明显，就是不用区分是哪条List，因为交换的操作总是一样的。
 * new一个新节点dummy，然后把dummy.next设为head也很巧妙
 * 感觉在Linked Lst问题中使用局部变量会非常有效！（指下面代码中的swap1与swap2
 */

//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode point = dummy;
//        while (point.next != null && point.next.next != null) {
//            ListNode swap1 = point.next;
//            ListNode swap2 = point.next.next;
//            point.next = swap2;
//            swap1.next = swap2.next;
//            swap2.next = swap1;
//            point = swap1;
//        }
//        return dummy.next;
//    }


/***
 * 解法三：递归（正确）
 * 要想清楚它是怎么个递归流程
 */

//public ListNode swapPairs(ListNode head) {
//    if ((head == null)||(head.next == null))
//        return head;
//    ListNode n = head.next;
//    head.next = swapPairs(head.next.next);
//    n.next = head;
//    return n;
//}