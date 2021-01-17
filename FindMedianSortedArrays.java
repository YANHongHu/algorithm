/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        //System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays_log(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int len = n1+n2;
        int pre = -1, cur = -1;
        int num1Start = 0, num2Start = 0;
        for (int i = 0; i <= len / 2; i++) {
            pre = cur;
            if (num1Start < n1  && (num2Start >= n2 || nums1[num1Start] < nums2[num2Start])) {
                cur = nums1[num1Start++];
            } else {
                cur = nums2[num2Start++];
            }
        }
        //判断总长度是奇数还是偶数
        if((len & 1)==0)
            return (pre+cur)/2.0;
        return cur;
    }

    public static double findMedianSortedArrays_log(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int k = (n1+n2)/2+1;
        int pre = -1, cur = -1;
        int mid = k/2;
        int flag1 = mid;
        int flag2 = mid;
        if(n1==0) {
            if (((n1 + n2) & 1) == 0)
                return (nums2[k - 1] + nums2[k - 2]) / 2.0;
            return nums2[k - 1];
        }
        if(n2==0) {
            if (((n1 + n2) & 1) == 0)
                return (nums1[k - 1] + nums1[k - 2]) / 2.0;
            return nums1[k - 1];
        }
        while (mid>=0){
            if(k==1&&mid==0){
                cur = Math.max(nums1[flag1-1], nums2[flag2-1]);
                pre = Math.min(nums1[flag1-1], nums2[flag2-1]);
                break;
            }
            if(flag1>n1){
                if(nums1[n1-1]>cur){
                    cur = nums1[n1-1];
                    flag2 += mid;
                }else{
                    k = k - mid + (flag1-n1);
                    flag2 += k;
                    cur = nums2[flag2-1];
                    pre = nums2[flag2-2];
                    break;
                }
            }
            if(flag2>n2){
                if(nums2[n2-1]>cur){
                    cur = nums2[n2-1];
                    flag1 += mid;
                }else{
                    k = k - mid + (flag2-n2);
                    flag1 += k;
                    cur = nums1[flag1-1];
                    pre = nums1[flag1-2];
                    break;
                }
            }
            if(flag1<=n1&&flag2<=n2) {
                if (nums1[flag1-1] > nums2[flag2-1]) {
                    cur = nums1[flag1-1];
                    flag2 += mid;
                } else {
                    cur = nums2[flag2-1];
                    flag1 += mid;
                }
                k = k-mid;
                mid = k/2;
            }
        }
        //判断总长度是奇数还是偶数
        if(((n1+n2) & 1)==0)
            return (pre+cur)/2.0;
        return cur;
    }
}
