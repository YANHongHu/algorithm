package algorithm;

public class IntegerInversion {

	public static void main(String[] args) {
		int x =1534236469;
		System.out.println(reverse(x));
	}
	public static int reverse(int x) {
	        int count=0;
	        int sum = 0;
	        int a[] = new int[32];
	            for(;x!=0;count++){
	                int bit = x%10;
	                a[count] = bit;
	                x=x/10;
	            }
	            for(int i=0;i<count;i++){
	            	if (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE / 10 && a[i] > 7)) return 0;
	                if (sum < Integer.MIN_VALUE/10 || (sum == Integer.MIN_VALUE / 10 && a[i] < -8)) return 0;
	                sum = sum*10+a[i];
	            }
	            return sum;
	 }
}
