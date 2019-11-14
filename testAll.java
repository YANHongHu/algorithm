import java.util.ArrayList;
import java.util.List;

public class testAll {
    public static void main(String[] args) {
        for(int i =1;i<=999;i++){
            if (me(i)==others(i))
                System.out.println("right!"+i);
            else {
                System.out.println("wrong!"+i);
                break;
            }
        }
    }

    private static int others(int n){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            i = (i + 2) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }

    private static int me(int n){
        Node cur;
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
        return cur.num;
    }
}
