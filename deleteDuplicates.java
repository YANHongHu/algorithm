
public class deleteDuplicates {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(4);
        ListNode seven = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        println(deleteDuplicates(one));
    }

    private static void println(ListNode head) {
        ListNode cur = head;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
            if(pre.val==cur.val){
                if(cur.next!=null) {
                    pre.next = cur.next;
                    pre = pre.next;
                    cur = cur.next;
                }
                else
                    pre.next = null;
            }
            else
                pre = pre.next;
        }
        return head;
    }
}

