import java.util.Arrays;

public class MinIncrementForUnique {
    public static void main(String[] args) {
        int[] a = null;
        System.out.println(minIncrementForUnique(a));
    }

    public static int minIncrementForUnique(int[] A) {
        int count = 0;
        try {
            Arrays.sort(A);
            int flag = A[0];
            for (int i = 1;i<A.length;i++){
                if (A[i]>flag) {
                    flag = A[i];
                }
                else {
                    count+=flag-A[i]+1;
                    flag = flag+1;
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return 0;
        }
        return count;
    }
}
