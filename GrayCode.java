import java.util.*;
public class GrayCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(Arrays.toString(getGray(n)));
    }

    private static String[] getGray(int n) {
        if(n == 1){
            return new String[]{"0","1"};
        }else{
            String[] temp = getGray(n-1);
            String[] result= new String[temp.length*2];
            for(int i = 0; i < temp.length;i++)
                result[i] = "0"+temp[i];
            int i,j;
            j = temp.length - 1;
            for( i = 0; i < temp.length && j>= 0;i++,j--)
                result[i+temp.length] = "1"+temp[j];
            return result;
        }
    }
}
