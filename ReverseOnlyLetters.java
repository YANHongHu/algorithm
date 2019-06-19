package algorithm;

public class ReverseOnlyLetters {
	public static void main(String[] args) {
		String s = new String();
		s ="ab-cd";
		System.out.println(reverseOnlyLetters(s));
	}
	
	public static String reverseOnlyLetters(String S) {
		int len = S.length();
		int count = 0;
		char arr1[] = new char[S.length()];
		char arr2[] = new char[S.length()];
		for(int i =0;i<len;i++) {
			if((S.charAt(i)>='a'&&S.charAt(i)<='z')||(S.charAt(i)>='A'&&S.charAt(i)<='Z')) {
				arr1[count] =S.charAt(i);
				count++;
			}
			else {
				arr2[i]=S.charAt(i);
			}
		}
		for(int i=0;i<len;i++) {
			if(arr2[i]==0) {
				arr2[i]=arr1[count-1];
				count--;
			}
		}
		return new String(arr2);     
	}
}
