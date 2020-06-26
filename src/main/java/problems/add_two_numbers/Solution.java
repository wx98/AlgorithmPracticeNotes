package problems.add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, resultList = dummyHead;
        int x = 0;
        while (null != p || null != q) {
            int a = null != p ? p.val : 0;
            int b = null != q ? q.val : 0;
            int c = a + b + x;
            x = c / 10;
            resultList.next = new ListNode(c % 10);
            resultList = resultList.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (x > 0) {
            resultList.next = new ListNode(x);
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);


        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        System.out.println(listNode1);
        System.out.println(listNode2);

        System.out.println(
                new Solution().addTwoNumbers(listNode1, listNode2)
        );

    }

}
