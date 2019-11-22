public class UnusualAdd {
    /*
     二进制加法。发现一个特点。
     位的异或运算跟求'和'的结果一致：
     异或 1^1=0 1^0=1 0^0=0
     求和 1+1=0 1+0=1 0+0=0
     位的与运算跟求'进位‘的结果一致：
     位与 1&1=1 1&0=0 0&0=0
     进位 1+1=1 1+0=0 0+0=0
     于是可以用异或运算和与运算来表示加法
     A^B是不考虑进位的结果，（A&B）<<1是求得的进位
     因此A^B+（A&B）<<1的结果就是和，只要（A&B）<<1=0，两项就变成了一项，不需要加法了*/
    private int addAB(int A, int B) {
        if(B!=0){
            int a=A^B;
            int b=(A&B)<<1;
            return addAB(a,b);
        }else{
            return A;
        }
    }
}
