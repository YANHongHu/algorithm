package algorithm;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
		System.out.println(numberOfBoomerangs(points));
	}
	public static int numberOfBoomerangs(int[][] points) {
		int count = 0;
		Double arr[]=new Double[points.length];
        for(int i= 0;i<points.length;i++) {
        	HashMap<Double, Integer> hashMap = new HashMap<>();
        	for(int j=0;j<points.length;j++) {
        		arr[j]= Math.sqrt((points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
        	}
        	for (int  k= 0; k < arr.length; k++) {
            	if (hashMap.get(arr[k]) != null) {
    				int tmp = hashMap.get(arr[k]);
    				hashMap.put(arr[k], tmp+1);
    			}
            	else hashMap.put(arr[k], 1);
    		}
        	for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
     			if(entry.getValue()>1) {
     				count += entry.getValue()*(entry.getValue()-1);
     			}
     		}
        }
		return count;
    }
}
