package algorithm;

public class MatrixReshape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums= {{1,2},{3,4}};
		int r=1;
		int c=4;
		nums=matrixReshape(nums, r, c);
	}
	
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int count = 0;
		int[][] new_nums = new int[r][c];
        if(nums.length*nums[0].length==r*c) {
        	int arr[] = new int[r*c];
        	for(int i=0;i<nums.length;i++) {
        		for(int j=0;j<nums[0].length;j++){
        			arr[count]=nums[i][j];
        			count++;
        		}
        	}
        	count=0;
        	for(int i=0;i<r;i++) {
        		for(int j=0;j<c;j++) {
        			new_nums[i][j]=arr[count];
        			count++;
        		}
        	}
        	return new_nums;
        }
        else {
			return nums;
		}
    }
}
