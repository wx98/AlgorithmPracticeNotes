# 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。   
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。   
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。   
>示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)   
输出：7 -> 0 -> 8   
原因：342 + 465 = 807   

* Code:[Solution.java](src/main/java/problems/add_two_numbers/Solution.java)
* ~~这个数据结构不是很熟悉啊-20200626~~
```java
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
}
```