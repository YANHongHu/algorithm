import java.util.Scanner;

public class MoveNums {
    public static void main(String[] args) {
//        int x=20,y=5;
//        System.out.println(x+y+""+(x+y)+y);
        //Scanner sc = new Scanner(System.in);
        //String str = sc.nextLine();
        //System.out.println(toLowerCase(str));
        //int[] nums = {1,2,3,6,7};
        // int k = sc.nextInt();
        //rotate(nums,k);
        //System.out.println(searchInsert(nums,k));
        circleNumber();
    }

    public static String toLowerCase(String str){
        StringBuffer str_n = new StringBuffer();
        for (int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='A'&&ch<='Z')
                ch = (char) (ch -'A'+'a');
            str_n.append(ch);
        }
        return str_n.toString();
    }

    public static void rotate(int[] nums, int k){
        int len = nums.length;
        for(int i=0;i<k;i++) {
            int a = 0;
            a = nums[len-1];
            for(int j = len-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0] = a;
        }
    }

    public static int removeElement(int[] nums, int val){
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        // 用for循环来遍历，如果当前元素与 val相同
        // 只要nums[i] != val 就复制 nums[j] = nums[i]同时递增两个索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void circleNumber() {
        int i = 7;
        do {
            System.out.println(--i);
            --i;
        } while (i != 0);
        System.out.println(i);
    }


    public static int searchInsert(int[] nums, int target){
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        int count = 0;
        for(int i = 0;i < nums.length;i++) {
            if (nums[i] == target) {
                count = i ;
                j++;
            }
        }
        if(j == 0) {
            if(nums[0]<nums[1]){
                for(int i = 0;i < nums.length;i++) {
                    if (nums[i] > target) {
                        count = i;
                        break;
                    }
                }
            }
            else {
                for(int i = 0;i < nums.length;i++) {
                    if(nums[i] < target) {
                        count = i;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
