public class deleteDuplicatesAll {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        deleteDuplicates.ListNode one = new deleteDuplicates.ListNode(1);
        deleteDuplicates.ListNode two = new deleteDuplicates.ListNode(1);
        deleteDuplicates.ListNode three = new deleteDuplicates.ListNode(2);
        deleteDuplicates.ListNode four = new deleteDuplicates.ListNode(2);
        deleteDuplicates.ListNode five = new deleteDuplicates.ListNode(3);
        deleteDuplicates.ListNode six = new deleteDuplicates.ListNode(4);
        deleteDuplicates.ListNode seven = new deleteDuplicates.ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        println(deleteDuplicatesAll(one));
    }

    private static void println(deleteDuplicates.ListNode head) {
        deleteDuplicates.ListNode cur = head;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }

    public static deleteDuplicates.ListNode deleteDuplicatesAll(deleteDuplicates.ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next != null && head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            //去掉所有重复的数字，然后进行递归
            return deleteDuplicatesAll(head.next);
        } else {
            head.next = deleteDuplicatesAll(head.next);
        }
        return head;
    }
}
