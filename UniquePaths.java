/**
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问总共有多少条不同的路径？
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(countPath_2(10, 10));
        //System.out.println(countPath_1(10, 10));
    }

    /**
     * 动态规划：由每次只能向右或者向下走，可知
     * f(m,n) = f(m,n-1) + f(m-1,n)
     * 边界值 f(1,n) = 1, f(m,1) = 1 f(1,1) = 1
     * @param m
     * @param n
     * @return
     */
    private static int countPath_1(int m, int n){
        int[][] map = new int[m][n];
        for (int i = 0; i < m; ++i) {
            map[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            map[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m-1][n-1];
    }

    /**
     * 组合数学
     * 从左上角到右下角的过程中，我们需要移动 m+n-2 次，其中有 m-1 次向下移动，n-1 次向右移动。
     * 因此路径的总数，就等于从 m+n-2 次移动中选择 m-1 次向下移动的方案数
     * @param m
     * @param n
     * @return
     */
    private static int countPath_2(int m, int n){
        int x = Math.min(m,n);
        long y = 1, c = 1;
        for (int i = 1;i<x;i++){
            y*=i;
        }
        for (int i = m+n-x;i<m+n-1;i++){
            c*=i;
        }
        return (int)(c/y);
    }
}
