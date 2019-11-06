public class FindK {
    public static void main(String[] args) {
        int[] str = {-1,-1};
        System.out.println(findKth(str, str.length, 3));
//        for (int i :str){
//            System.out.println(i);
//        }
    }


    private static int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n-1, K);
    }

    // 快排递归
    private static int quickSort(int[] a, int start, int end, int K){
        // 得到当前排序范围内，中间点的下标
        int par = portion(a, start, end);
        // 如果中间点正好位列于数组的第K位， 那么直接返回中间点
        if (par == K-1)
            return a[par];
        // 如果数组第K个数在当前排序范围内的中间点的左边，那么对此中间点的左边进行快速排序
        else if (par > K-1)
            return quickSort(a, start, par - 1, K);
        // 否则对中间点的右边进行快排
        else
            return quickSort(a, par + 1, end, K);
    }

    // 完成一次快排过程，并确定中间点的下标
    private static int portion(int[] a, int left, int right){
        // 以第一个数作为基准点
        int mid = a[left];
        // left从前往后遍历，right从后往前遍历，left和right相遇时循环停止
        while (left<right){
            // 先移动right
            // 如果right处的值大于mid那么right左移一位
            while(left<right&&a[right]>=mid){
                right--;
            }
            // 当找到小于mid的值，right停止左移，并用right处的值替换left处的值（原left处的值已经赋值给mid，所以未丢失）
            a[left]=a[right];
            // 开始移动left,如果left的值小于mid，left右移一位
            while (left<right&&a[left]<=mid){
                left++;
            }
            // 当找到大于mid的值，left停止右移，并用left处的值替换right处的值（原right处的值已经和left替换，所以未丢失）
            a[right] = a[left];
        }
        a[left] = mid;
        return left;
    }
}
