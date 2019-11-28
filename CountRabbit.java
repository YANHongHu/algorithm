import java.util.Scanner;

public class CountRabbit {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int input = scanner.nextInt();
                System.out.println(countRabbit(input));
            }
            scanner.close();
        }

        /**
         * 统计第n个月的兔子总数
         * 兔子可以看作第一个月未成熟，第二个月成熟，第三个月产仔，可以构造一个“斐波那契数列”问题
         */
        private static int countRabbit(int input) {

            if (input <= 0) {
                return 0;
            } else if (input <= 2) {
                return 1;
            } else {

                int prev1 = 1;
                int prev2 = 1;
                int result = 0;
                for (int i = 3; i <= input; i++) {
                    result = prev1 + prev2;
                    prev1 = prev2;
                    prev2 = result;
                }
                return result;
            }
        }
}
