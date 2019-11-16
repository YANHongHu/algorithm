import java.util.ArrayList;
import java.util.Scanner;

public class ResortNumtoString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0){
            System.out.println(0);
            return;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; n!=0;i++ ){
            a.add(n%10);
            n /= 10;
        }
        for(int i = 0; i<a.toArray().length;i++ ) {
            System.out.print(a.toArray()[i]);
        }
    }
}
