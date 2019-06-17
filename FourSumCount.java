package algorithm;

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
	            //计数A和B中不同值的和各自出现了多少次
	            hashMap.put(sumAB, hashMap.getOrDefault(sumAB, 0) + 1);
	        }
	    }
	    for (int numC : C){
	        for (int numD : D){
	            int sumCD = numC + numD;
	            //判断在哈希表中是否存在与C、D中的数的和为相反数的AB和，如果则把它出现的次数加到count，没有则加0
	            count += hashMap.getOrDefault(-sumCD,0);
	        }
	    }
	    return count;
	}
}
