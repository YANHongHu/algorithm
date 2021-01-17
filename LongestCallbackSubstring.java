/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */


public class LongestCallbackSubstring {
    public static void main(String[] args) {
        String s = null;
        System.out.println(find_callback(s));
        System.out.println(find_callback2(s));
    }

    /**
     * 动态规划
     * 由回文的性质可知，一个回文串去掉首位后还是回文串，由此可以得到状态转移方程
     * P(i,j)=P(i+1,j−1)∧(Si==Sj)
     * S[i..j]代表子串的起始和终点位置
     * 但是上述条件是子串的长度>2的情况，在子串长度为1和2时我们可以知道
     * P(i,i)=true,P(i,i+1)=(Si==Si+1)
     * @param str
     * @return
     */
    public static String find_callback(String str){
        // 获取输入字符串的长度
        int len = str.length();
        // 初始化一个布尔类型的二维数组，默认值为false
        boolean[][] dp = new boolean[len][len];
        // 初始化一个回文子串
        String sub_str = "";
        // 从0-0,0-1,1-1,...,len-len按列遍历二维数组的右上部分
        for (int j=0;j<len;j++){
            for (int i=0;i<=j;i++){
                // 如果子串的长度为1，一定是回文子串，即二维数组的对角线上所有的值都为true
                if (i==j) {
                    dp[i][j]=true;
                }
                boolean b = str.charAt(i) == str.charAt(j);
                // 如果子串的长度为2，只要Si==Sj，就是回文子串
                if (j==i+1){
                    if(b){
                        dp[i][j]=true;
                    }
                }
                // 如果子串的长度大于2，只要满足P(i,j)=P(i+1,j−1)∧(Si==Sj)，就是回文子串
                if (i<j-1){
                    if(dp[i + 1][j - 1] && b){
                        dp[i][j]=true;
                    }
                }
                // 如果当前子串为回文子串并且长度大于之前的最长回文子串，就更新最长的回文子串的值
                if(dp[i][j]&&j-i+1>sub_str.length()){
                    sub_str = str.substring(i,j+1);
                }
            }
        }
        return sub_str ;
    }

    /**
     * 中心拓展算法
     * 由之前的动态规划法可以发现其实质意义就是，枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。
     * 对所有的长度求最大值
     * 自己写的
     */
    public static String find_callback2(String str){
        // 边界值处理
        if (str == null || str.length() < 1) {
            return "";
        }
        String sub_str = "";
        int len = str.length();
        int maxl = 0;
        int beg=0;
        int end=0;
        for(int i=1;i<len;i++) {
            for(int j=i;j<=i+1;j++){
                beg = i;
                end = j;
                // 当子串中心长度为1
                if(beg==end){
                    maxl = 1;
                    beg--;
                    end++;
                    while (beg>=0&&end<len&&str.charAt(beg)==str.charAt(end)){
                        maxl+=2;
                        --beg;
                        ++end;
                    }
                    if(maxl>sub_str.length()){
                        sub_str = str.substring(beg+1,end);
                    }
                }
                // 当子串中心长度为2
                else if (end==beg+1&&end<len){
                    maxl = 2;
                    if(str.charAt(beg)==str.charAt(end)){
                        beg--;
                        end++;
                        while (beg>=0&&end<=len&&str.charAt(beg)==str.charAt(end)){
                            maxl+=2;
                            --beg;
                            ++end;
                        }
                        if(maxl>sub_str.length()){
                            sub_str = str.substring(beg+1,end);
                        }
                    }
                }
            }
        }
        return sub_str;
    }
    /**
     * 标准答案的中心拓展算法
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
