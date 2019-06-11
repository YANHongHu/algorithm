package algorithm;
import java.util.Scanner;

public class PalindromeSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String substring = longestPalindrome(s);
		System.out.println(substring);
	}
	public static String longestPalindrome(String s) {
		int len = s.length();
	    if(len == 0){
	    	return "";
	    }
	    char[] sToArray = s.toCharArray();
	    boolean[][] mem = new boolean[len][len];
	    int maxLen = 1;
	    int fromIndex = 0;
	    int toIndex = 1;
	        // 初始化条件
	        for(int i = 0; i < len; ++i){
	            mem[i][i] = true;
	            if(i + 1 < len && sToArray[i] == sToArray[i + 1]){
	                mem[i][i + 1] = true;
	                maxLen = 2;
	                fromIndex = i;
	                toIndex = i + 1 + 1;
	            }
	        }
	        // 执行dp
	        for(int i = 2; i < len; ++i){
	            for(int j = 0; j < i - 1; ++j){
	                mem[j][i] = mem[j + 1][i - 1] && sToArray[j] == sToArray[i];
	                if(mem[j][i] && i - j + 1 > maxLen){
	                    maxLen = i - j + 1;
	                    fromIndex = j;
	                    toIndex = i + 1;
	                }
	            }
	        }

	        return s.substring(fromIndex, toIndex);
	    }
	}

