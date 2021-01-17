import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            if ('a' <= charAt && charAt <= 'z') {
                System.out.print(Character.toUpperCase(charAt));
            }
            else {
                System.out.print(Character.toLowerCase(charAt));
            }
        }
    }
}