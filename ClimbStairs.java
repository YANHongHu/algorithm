/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbing(5));
        System.out.println(climbStair(5));
    }

    /**
     * 动态规划，每次爬到楼顶，最后一步都有两种可能要么是爬1阶，要么是爬2阶
     * 因此如果用f(x)表示爬x阶到楼顶有多少种不同的方法，那么f(x)=f(x-1)+f(x-2)
     * 当我们爬一阶时只有一种方法，f(1)=1,爬2阶时有两种不同的方法f(2)=2
     * 那么爬3阶：f(3)=f(2)+f(1)=2+1=3
     */
    // 递归写法，单数当num过大时，时间复杂度会过大
    //public static int climbing(int num){
    //    int ways;
    //    if(num==1)
    //        ways = 1;
    //    else if(num==2)
    //        ways =2;
    //    else {
    //        ways = climbing(num - 1) + climbing(num - 2);
    //    }
    //    return ways;
    //}
    // 循环写法
    //执行用时：0 ms
    //内存消耗：35.5 MB
    public static int climbing(int num){
        int p = 0, q = 1, ways = 2;
        for(int i=2;i<num;i++){
            p = q;
            q = ways;
            ways = p+q;
        }
        return ways;
    }
    /**
     * 矩阵快速幂
     */
    public static int climbStair(int num){
        int[][] base = {{1,1},{1,0}};
        int[][] ret = {{1,0},{0,1}};
        for(;num>0;num>>=1){
            //如果num是奇数
            if((num&1)==1){
                ret = multiply(ret,base);
            }
            base = multiply(base,base);
        }
        return ret[0][0];
    }

    // 矩阵乘法函数
    public static int[][] multiply(int[][] a, int[][] b){
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
