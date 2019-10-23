import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CheckSam {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        if(stringA.length()!=stringB.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<stringA.length();i++) {
            map.put(stringA.charAt(i),1);
        }
        for(int i = 0;i<stringB.length();i++) {
            if(map.containsKey(stringB.charAt(i)))
                map.replace(stringB.charAt(i),map.get(stringB.charAt(i))+1);
        }
        for(Integer v:map.values()){
            if(v == 1)
                return false;
        }
        return true;
    }
}
