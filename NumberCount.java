import java.util.*;

public class NumberCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        TreeMap<Character,Integer> a = new TreeMap<>();
        for(int i = 0;i<n.length();i++){
            if(a.containsKey(n.charAt(i)))
                a.replace(n.charAt(i),a.get(n.charAt(i)),a.get(n.charAt(i))+1);
            else {
                a.put(n.charAt(i),1);
            }
        }
        Character key = null;
        Integer value = null;
        for (Map.Entry<Character, Integer> characterIntegerEntry : a.entrySet()) {
            // 获取key
            key = characterIntegerEntry.getKey();
            // 获取value
            value = (Integer) ((Map.Entry) characterIntegerEntry).getValue();
            System.out.println(key + ":" + value);
        }
    }
}
