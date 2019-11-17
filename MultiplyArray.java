public class MultiplyArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = multiply(a);
        for (int num: b) {
            System.out.println(num);
        }
    }
    public static int[] multiply(int[] A) {
        int n = A.length;
        if(n < 2)
            return null;
        int[] B = new int[n];
        B[0] = 1 ;
        for(int i = 1 ;i<n;i++)
            B[i] = B[i-1]*A[i-1];
        int right = 1;
        for(int i = n-2;i>=0;i--) {
            right = right * A[i + 1];
            B[i] = B[i]*right;
        }
        return B;
    }
}
