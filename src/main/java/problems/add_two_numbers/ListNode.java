package problems.add_two_numbers;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return printList(this);
    }

    private String string = "";

    private String printList(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next ==null){
                string += listNode.val;
            }else {
                string += listNode.val + "->";
            }
            printList(listNode.next);
        }
        return string;
    }
}