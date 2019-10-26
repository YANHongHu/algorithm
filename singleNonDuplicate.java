import sun.rmi.transport.proxy.RMIDirectSocketFactory;

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
//    public int singleNonDuplicate(int[] nums) {
//        int single = 0;
//        for (int i:nums) {
//            single ^= i;
//        }
//        return single;
//    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(singleNonDuplicate(nums));
    }

    // 二分法找中位数求解，执行0ms，内存37.8MB
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int mid = (nums.length-1)/2;
        int pre = 0;
        while (true) {
            if (mid % 2 == 0) {
                if (mid-1>=0&&nums[mid] == nums[mid - 1]) {
                    int flag = mid;
                    mid = (pre + mid - 2) / 2;
                    pre = flag;
                } else if (mid+1<nums.length&&nums[mid] == nums[mid + 1]) {
                    mid = (mid + 2 + nums.length) / 2;
                } else {
                    return nums[mid];
                }
            } else {
                if (mid-1>=0&&nums[mid] == nums[mid - 1]) {
                    mid = (mid + 1 + nums.length - 1) / 2;
                } else if (mid+1<nums.length&&nums[mid] == nums[mid + 1]) {
                    int flag = mid;
                    mid = (pre + mid - 1) / 2;
                    pre = flag;
                } else {
                    return nums[mid];
                }
            }
        }
    }
}
