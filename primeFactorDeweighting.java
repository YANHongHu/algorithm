import java.util.Scanner;

public class primeFactorDeweighting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        System.out.println(primeFactor(num));
    }

    public static int primeFactor(long num){
        int p =1;
        for(long i=2;i*i<=num;i++){
            if(num%i==0) {
                p*=i;
                while (num % i == 0) {
                    num = (num / i);
                }
            }
        }
        return (int) (p*num);
    }
}
