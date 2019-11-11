import java.util.Scanner;
public class theSumInN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i= 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(groups(a,n,0,40));
    }

    private static int groups(int[] a, int n, int index, int v){
        if(v==0)
            return 1;
        if(n==0)
            return 0;
        else
            return groups(a,n-1,index+1, v -a[index])+groups(a,n-1 ,index+1,v);
    }

}
