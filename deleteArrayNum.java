import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class Nodes{
    int num;
    Nodes next;

    public Nodes() {}


    public Nodes(int _val) {
        num = _val;
    }
}


public class deleteArrayNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<=0)
            return;
        if(n>1000)
            n = 999;
        Nodes cur = new Nodes();
        //Nodes cur = testAll.getNodes(n);
        System.out.println(cur.num);
    }
}
