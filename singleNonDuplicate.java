import java.util.Hashtable;

public class singleNonDuplicate {
    // 使用hashtable<k,v>求解   执行12ms，内存38.8MB
//    public int singleNonDuplicate(int[] nums) {
//        Hashtable<Integer,Integer> set = new Hashtable<>();
//        int single = 0;
//        for( int i : nums){
//            if(set.containsKey(i)) {
//                set.put(i,set.get(i)+1);
//            }
//            else
//                set.put(i,1);
//        }
//        for(int i:nums){
//            if (set.get(i)==1){
//                single = i;
//            }
//        }
//        return single;
//    }

//     使用按位异或求解   0和任何数异或都等于那个数，任意两个相同的数异或等于0
//     异或：相同为0，不同为1   执行1ms，内存37.6MB
    public int singleNonDuplicate(int[] nums) {
        int single = 0;
        for (int i:nums) {
            single ^= i;
        }
        return single;
    }
}
