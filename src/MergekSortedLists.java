import java.util.List;

/***
 * Index: 23
 * Difficulty: Hard
 * Related Topic: Linked List, Divide and Conquer, Heap
 */

/***
 * 解法一：（正确）
 * 直接把MergeTwoSortedLists用进来
*/

public class MergekSortedLists {
    // 最白给的 一个个结合然后和下一个merge
    // 时间复杂度大概是O(n^2*length^2) length是单个的长度 n是链表的个数
    //这个算法应该是最慢的，比把他们全部插进一个列表再快排都慢
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode list = new ListNode();
        for(int i = 0; i < lists.length; i++){
            list = mergeTwoLists(list, lists[i]);
        }
        return list;
    }
    //改进版 每次都是两个两个结合
    //merge写法最好记一下，我刚刚一直想不通怎么把每一项都遍历到，这个方法写的很好
    //时间复杂度大概是O(nx*log(n))?
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while( interval < lists.length){
            for ( int i = 0; i + interval < lists.length; i+=interval*2){
                lists[i] = mergeTwoLists(lists[0], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
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
//
//        ListNode cur = root;
//
//        while(l1!=null && l2!=null){
//            ListNode temp;
//            if(l1.val < l2.val){
//                temp = l1;
//                l1 = l1.next;
//                cur.next = temp;
//            }
//            else {
//                temp = l2;
//                l2 = l2.next;
//                cur.next = temp;
//            }
//            cur = cur.next;
//        }
//        if(l1 != null)
//            cur.next = l1;
//        if(l2 != null)
//            cur.next = l2;
        return root;
    }
}
