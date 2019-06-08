package algorithm;

public class Palindrome {
	public static void main(String[] args) {
		int x =10;
		boolean answer = isPalindrome(x);
		System.out.println(answer);
	}
	
	public static boolean isPalindrome(int x) {
        if(x<10||(x%10==0&&x!=0)){
            return false;
        }
        else{
            int resver = 0;
            while(x>resver){
                resver = resver*10+x%10;
                x=x/10;
            }
            if(x==resver||x==resver/10){
                return true;
            }
            return false;
        }
    }
	
}
