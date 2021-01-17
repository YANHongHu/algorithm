import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 左右两个指针，从第一个字符开始，向后遍历，找到一个重复的字符，然后记录下这段不重复字符串的长度，然后从重复字符第一个出现的位置向后遍历直到再次出现重复字符，重复以上步骤，直至循环结束
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        int max_len = 0;
        int len = 0;
        int left = 0;
        int right;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                len++;
            }
            else {
                if(max_len<len)
                    max_len = len;
                right = map.get(s.charAt(i));
                for(int j = left;j<=right;j++){
                    map.remove(s.charAt(j));
                }
                left = right+1;
                map.put(s.charAt(i),i);
                len = i - right;
            }
        }
        if(max_len<len)
            max_len = len;
        return max_len;
    }

    /**
     * 用一个左指针和右指针，左指针从第一个字符开始，右指针从左指针开始向后移直至出现与之前相同的字符，并记录下这段字符的长度，每完成一次，左指针向后移动一位，直至找到最长的字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_pub(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除第一个字符
                occ.remove(s.charAt(i - 1));
            }
            // 判断右指针有没有超过字符串的长度，并且集合里是否包含当前指向的字符
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 只要没有超过，并且不包含就把新字符放进集合里
                occ.add(s.charAt(rk + 1));
                // 不断地移动右指针
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
