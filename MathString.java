import java.util.Hashtable;
import java.util.Scanner;

public class MathString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<String,Integer> set = new Hashtable<>();
        while(sc.hasNext()){
            String str = sc.next();
            set.put(str, 1);
        }
        System.out.println(set.size());
    }
}
