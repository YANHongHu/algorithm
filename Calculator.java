import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模拟程序型计算器，依次输入指令，可能包含的指令有
 * 1. 数字：‘NUM X’，X为一个只包含大写字母和数字的字符串，表示一个当前进制的数
 * 2. 运算指令：‘ADD’,‘SUB’,‘MUL’,‘DIV’,‘MOD’，分别表示加减乘，除法取商，除法取余
 * 3. 进制转换指令：‘CHANGE K’，将当前进制转换为K进制(2≤K≤36)
 * 4. 输出指令：‘EQUAL’，以当前进制输出结果
 * 5. 重置指令：‘CLEAR’，清除当前数字
 *
 * 指令按照以下规则给出：
 * 　　数字，运算指令不会连续给出，进制转换指令，输出指令，重置指令有可能连续给出
 * 　　运算指令后出现的第一个数字，表示参与运算的数字。且在该运算指令和该数字中间不会出现运算指令和输出指令
 * 　　重置指令后出现的第一个数字，表示基础值。且在重置指令和第一个数字中间不会出现运算指令和输出指令
 * 　　进制转换指令可能出现在任何地方,运算过程中中间变量均为非负整数，且小于2^63。
 *
 * 以大写的'A'~'Z'表示10~35
 */
public class Calculator {
    public static String action;
    public static long x;
    public static int hex = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String action = "";
        for (int i=0;i<n;i++) {
            String order = bufferedReader.readLine();
            handle(order);
        }
    }

    public static void handle(String ord){
        String[] tmp = ord.split(" ");
        switch(tmp[0]){
            case "NUM":
                switch (action){
                    case "":
                        x = Long.parseLong(tmp[1], hex);
                        action = "";
                        break;
                    case "add":
                        x = x + Long.parseLong(tmp[1],hex);
                        action = "";
                        break;
                    case "sub":
                        x = x-Long.parseLong(tmp[1],hex);
                        action = "";
                        break;
                    case "mul":
                        x = x*Long.parseLong(tmp[1],hex);
                        action = "";
                        break;
                    case "div":
                        x = x/Long.parseLong(tmp[1],hex);
                        action = "";
                        break;
                    case "mov":
                        x = x%Long.parseLong(tmp[1],hex);
                        action = "";
                        break;
                }
                break;
            case "ADD":
                action = "add";
                break;
            case "SUB":
                action = "sub";
                break;
            case "MUL":
                action = "mul";
                break;
            case "DIV":
                action = "div";
                break;
            case "MOV":
                action = "mov";
                break;
            case "CLEAR":
                x = 0;
                action = "";
                break;
            case "CHANGE":
                hex = Integer.parseInt(tmp[1]);
                break;
            case "EQUAL":
                System.out.println(Long.toString(x, hex).toUpperCase());
                break;
        }
    }
}


