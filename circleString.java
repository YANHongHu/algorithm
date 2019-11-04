import java.util.Stack;

public class circleString {
    public static void main(String[] args) {
        String str = "abaabcddcefhgghfkhijkllmn";
        System.out.println(countSubstrings(str));
    }

    /*
    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即
    使是由相同的字符组成，也会被计为是不同的子串。
    中心扩展==>时间复杂度O(n^2)
     * 从中心（区分1个点的中心还是两个点的中心）向两边同时扩散，如左右两边都相等则是回文，继续扩散
     *
     * 执行用时 :2 ms , 在所有 Java 提交中击败了99.02%的用户
     * 内存消耗 :34 MB, 在所有 Java 提交中击败了92.79%的用户
     */
    private static int countSubstrings(String s) {
        int count = 0;
        int i;
        for(i = 0; i < s.length(); i++){
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }
    private static int countPalindrome(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
            count++;
        }
        return count;
    }
}
