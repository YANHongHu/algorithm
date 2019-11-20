import java.util.*;
public class minNumber {
    /**
     *
     * 输入描述:
     * 每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
     *
     * 格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
     *
     *  输出描述:  在一行中输出能够组成的最小的数。
     *  输入
     *
     * 2 2 0 0 0 3 0 0 1 0
     *  输出
     * 10015558
     */
//这道题输入即有序！！！
        public static void main(String[] args) {
            int i = 0;
            int j = 0;
            int k = 0;
            List<Integer> list = new ArrayList<>();
            int[] arr = new int[10];
            Scanner sc = new Scanner(System.in);
            //输入数据
            for(i = 0;i < 10;i++) {
                arr[i] = sc.nextInt();
            }
            //把从数字1开始的第一个不为0的数字放到list第一个
            if(arr[0] != 0) {
                for( i = 1;i < 10;i++) {
                    if(arr[i] != 0){
                        list.add(i);
                        arr[i]--;
                        break;
                    }
                }
            }
            //把剩余数字按位置放入list
            for(i = 0;i < 10;i++) {
                for(j = 0;j < arr[i];j++) {
                    list.add(i);
                }
            }
            //按顺序输出即可
            for(int t : list) {
                System.out.print(t);
            }
        }
}
