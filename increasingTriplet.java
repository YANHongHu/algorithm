public class increasingTriplet {
    public static void main(String[] args) {
        int[] nums = {1,2,-10,-8,-9};
        System.out.println(ifIncreasingTriplet(nums));
    }

    /* 用两个变量记录三个递增序列中的最小值和中间值，首先用min记录数组第一个元素，接着判断下
    一个元素如果比min小则把他赋值给min，如果比min大则用mid记录它(确保min<mid)，紧接着下一个元素，
    首先要先判断它的min的大小，和之前一样，如果比min小则赋值给min，如果比min大，则判断它和mid
    的大小，比mid大，则存在三个数满足递增子序列，跳出循环；如果比mid小则更新mid的值，因为mid越小
    （前提是满足比min大）在后面的值中越容易找到比mid大的值。*/
    public static boolean  ifIncreasingTriplet(int[] nums){
        int min = Integer.MAX_VALUE;//定义一个min取int类型最大值
        int mid = Integer.MAX_VALUE;//定义一个min取int类型最大值
        // 循环遍历数组
        for(int i = 0;i<nums.length;i++){
            // 比较min和当前数组值，确保min一直指向最小值
            min = Math.min(min,nums[i]);
            // 如果min大于等于当前值，则直接跳到下一个数(min的值更新为当前值，则跳到下一个)
            if(min<nums[i]){
                // 只有在min的值小于当前值的情况下，才会比较mid的值和当前值
                if(mid<nums[i])
                    return true;
                // mid大于等于当前值时，则更新mid
                mid = nums[i];
            }
        }
        return false;
    }
}

