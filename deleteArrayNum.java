import java.util.LinkedList;
import java.util.Scanner;

class Node{
    int num;

    Node() {
    }

    Node(int n){
        this.num = n;
    }

    Node next;
}

public class deleteArrayNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<=0)
            return;
        if(n>1000)
            n = 999;
        Node cur = new Node();
        Node head = new Node(0);
        cur = head;
        for(int i = 1;i<n;i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;
        Node flag = cur;
        cur = head;
        while (cur.next!=cur){
            flag = cur.next;
            cur = flag.next;
            flag.next=cur.next;
            cur = cur.next;
        }
        System.out.println(cur.num);
    }
}
