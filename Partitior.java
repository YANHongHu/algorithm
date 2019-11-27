public class Partitior {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
    private static ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead==null){
            return null;
        }
        //创建x结点作为分割前半部分和后半部分的中间结点
        ListNode nodex=new ListNode(x);
        //创建newHead结点方便第一个小于x值的插入
        ListNode newHead=new ListNode(0);
        newHead.next=nodex;
        //创建before结点，在迭代过程中始终保持before.next=nodex
        //从而保证小于x值的结点可以插入到nodex结点之前
        ListNode before=newHead;
        //创建after结点，在迭代过程中始终保持after结点是最后一个结点
        //从而保证大于等于x值的结点可以插入链表的最后位置
        ListNode after=nodex;
        ListNode walkNode=pHead;
        while(walkNode!=null){
            //如果当前节点小于x，复制结点并将其插入到xnode的前一个结点，然后移动before指针
            if(walkNode.val<x){
                ListNode node=new ListNode(walkNode.val);
                before.next=node;
                node.next=nodex;
                before=node;
            }
            //如果当前节点大于x，复制结点并将其插入到链表最后一个结点，然后移动after指针
            else {
                ListNode node=new ListNode(walkNode.val);
                after.next=node;
                after=node;
            }
            walkNode=walkNode.next;
        }
        //忽略自建的x结点nodex和头结点newHead；
        //因为x结点不一定存在于原链表，所以此处要将分开的前后部分相连
        before.next=nodex.next;
        return newHead.next;
    }
}
