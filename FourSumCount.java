package algorithm;

public class FourSumCount {

	public static void main(String[] args) {
		int A[]= {1,2};
		int B[]= {-2,-1};
		int C[]= {-1,2};
		int D[]= {0,2};
		System.out.println(fourSumCount(A, B, C, D));
	}
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int num = A.length;
        int count = 0;
        for(int i=0;i<num;i++) {
        	for(int j=0;j<num;j++) {
        		for(int k=0;k<num;k++) {
        			for(int l=0;l<num;l++) {
        				if(A[i]+B[j]+C[k]+D[l]==0) {
        					count++;
        				}
        			}
        		}
        	}
        }
		return count;
    }
}
