import java.util.Scanner;

public class MaxCake{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int count = 0;
        // 从(0,0)开始摆放蛋糕
        for(int i = 0;i<h;i++){
            int j=0;
            //如果(i/2)是偶数，那么蛋糕可以从这行的0位置开始放
            //如果(i/2)是奇数，那么蛋糕可以从这行的2位置开始放
            if(i/2%2 !=0){
                j=2;
            }
            //每放两个蛋糕就要跳过两个空位，一共就是每次四个位置
            for(;j<w;j+=4){
                if(j+1<w){
                    count +=2;
                }else{
                    count+=1;
                }
            }
        }
        System.out.println(count);
    }
}
