import java.util.Scanner;

public class TenToEightNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(tenToEight(num).equals("0")){
            System.out.println(0);
        }
        else
            System.out.println("0"+tenToEight(num));
    }

    private static String tenToEight(int num){
        return Integer.toOctalString(num);// 转八进制
    }
}
