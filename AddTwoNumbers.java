/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(0);
        ListNode summer = addTwoNumbers(l1,l2);
        while (summer!=null){
            System.out.println(summer.val);
            summer = summer.next;
        }
    }

    /**
     * 状态：通过
     * 执行用时: 2 ms
     * 内存消耗: 39.9 MB
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // 创建一个新链表的首结点，初始化为0
        ListNode cur = new ListNode(0) ;
        // 创建一个结点指向新链表的首结点，用于返回链表
        ListNode sumHeader = cur;
        // 创建一个p结点指向l1
        ListNode p = l1;
        // 创建一个结点q指向l2
        ListNode q = l2;
        // 定义一个carry用来标志进位，因为两个个位数相加再加上进位最大值为9+9+1=18，所以carry的值是在0-1之间
        int carry = 0;
        // 只要相加的两个链表都不到最后一个结点，循环就不停止
        while (p!=null||q!=null){
            // 判断两个链表的当前结点是否为空，如果是空则取其值为0
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            // 给新创建的链表结点赋值
            cur.val = (x+y+carry)%10;
            // 给carry赋值
            carry = (x+y+carry)/10;
            // 判断当前结点是否是空，不是就指向下一个结点
            if(p!=null)
                p = p.next;
            if(q!=null)
                q = q.next;
            // 如果当前两个链表的结点不同时为空，就为新链表创建一个新的结点，并将其指向移后一位
            if(q!=null||p!=null){
                cur.next = new ListNode(0);
                cur = cur.next;
            }
        }
        // 检查最后一位相加是否有进位，有进位则为新链表创建一个新结点进1
        if (carry>0)
            cur.next = new ListNode(carry);
        return sumHeader;
    }
}
