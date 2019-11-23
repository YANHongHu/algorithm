
    import java.util.Scanner;
    public class washCard{
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                int m = scanner.nextInt();
                while(m!=0){
                    int n = scanner.nextInt();
                    int k = scanner.nextInt();
                    int [] arr = new int[2*n];
                    //计算下标
                    for(int i = 0; i < 2*n;i++){
                        int temp = i;
                        for(int j = 0; j < k ;j++){
                            if(temp < n){
                                temp = 2*temp;
                            }else{
                                temp = 2*(temp-n) + 1;
                            }
                        }
                        //temp为元素经历k次之后的下标
                        arr[temp] = scanner.nextInt();
                    }
                    //输出
                    for(int i = 0;i < 2*n;i++){
                        if(i == 2*n-1){
                            System.out.print(arr[i]);
                        }else {
                            System.out.print(arr[i]+" ");
                        }
                    }
                    System.out.println();
                    m--;
                }
            }
        }
    }

