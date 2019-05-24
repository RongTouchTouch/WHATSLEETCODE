class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode start = new ListNode(0);
        ListNode temp = start;
        while (l1 != null || l2 !=null) {
            int val1 = (l1!=null) ? l1.val : 0;
            int val2 = (l2!=null) ? l2.val : 0;
            carry = val1 + val2 + carry;
            ListNode output = new ListNode(carry%10);
            start.next = output;
            start = output;
            carry = carry/10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry !=0 ){
            ListNode output = new ListNode(carry);
            start.next = output;
        }
        return temp.next;
    }
    public static void main(String agrv[]){
        AddTwoNumbers solution = new AddTwoNumbers();

    }
}
