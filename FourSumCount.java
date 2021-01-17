import java.util.HashMap;

public class FourSumCount {

	public static void main(String[] args) {
		int A[]= {1,2};
		int B[]= {-2,-1};
		int C[]= {-1,2};
		int D[]= {0,2};
		System.out.println(fourSumCount(A, B, C, D));
	}
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
	    HashMap<Integer,Integer> hashMap = new HashMap<>();
	    for (int numA : A) {
	        for (int numB : B) {
	            int sumAB = numA + numB;
	            //
	            hashMap.put(sumAB, hashMap.getOrDefault(sumAB, 0) + 1);
	        }
	    }
	    for (int numC : C){
	        for (int numD : D){
	            int sumCD = numC + numD;
	            //
	            count += hashMap.getOrDefault(-sumCD,0);
	        }
	    }
	    return count;
	}
}
