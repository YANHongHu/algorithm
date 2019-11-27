import java.util.HashMap;

public class Gift {
    public static void main(String[] args) {
        int[] gifts = {3,3,3,4,5,3,3,2,1,3};
        int n = gifts.length;
        System.out.println(getValue(gifts,n));
    }
    private static int getValue(int[] gifts, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:gifts){
            if(map.containsKey(num))
                map.replace(num,map.get(num),map.get(num)+1);
            else
                map.put(num,1);
        }
        for (int num:map.keySet()){
            if(map.get(num)>n/2)
                return num;
        }
        return 0;
    }
}
