import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[1000000];
        int i;
        arr[0] = 0;
        arr[1] = 1;
        for(i = 2;arr[i-1]<=num;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(Math.min(arr[i-1]-num,num-arr[i-2]));
    }
}