import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SimpleCalculator {
    // 存储当前进制
    public static int radix = 10;

    //当前数,永远都为10进制
    public static long res = 0;

    //是否为第一个输入数的标志
    public static boolean isFirst = true;

    //当前要进行的运算
    public static String calType = "";

    //将要用于计算的第二个输入数字
    public static long calNum = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int flag = Integer.parseInt(bufferedReader.readLine());;
        long count = 0;
        for(int n = 0;n<flag;n++){
            String str = bufferedReader.readLine();
            deal(str);
        }
    }

    private static void deal(String str){
            //不是真正的运算，只记录运算符
            if (str.length() == 3) {
                calType = str;
            }
            else {
                //清除
                if(str.equals("CLEAR")) {
                    res = 0;
                    isFirst = true;
                    calType = "";
                }
                else {
                    switch (str.charAt(0)) {
                        //求解输出结果
                        case 'E':
                            System.out.println(Long.toString(res, radix).toUpperCase());
                            break;
                        //输入number
                        case 'N':
                            String[] strNum = str.split(" ");
                            long tmpNumber = Long.valueOf(strNum[1], radix);
                            //判断是否为首个输入数
                            if(isFirst) {
                                res = tmpNumber;
                                isFirst = false;
                            }
                            else {
                                calNum = tmpNumber;
                                operation(calType);
                            }
                            break;
                        //改变进制
                        case 'C':
                            String[] strRadix = str.split(" ");
                            radix = Integer.parseInt(strRadix[1]);
                            break;
                    }
                }
            }
    }

    private static void operation(String str) {

        //真正的运算
        switch (str.charAt(0)) {
            case 'A':
                res += calNum;
                break;
            case 'S':
                res -= calNum;
                break;
            case 'M':
                if(str.equals("MUL")) {
                    res *= calNum;
                }
                else {
                    res %= calNum;
                }
                break;
            case 'D':
                res /= calNum;
                break;
        }
        calType = "";
    }
}
