import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

    public class train {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while(in.hasNext()){
                int n = in.nextInt();
                int[] A = new int[n];
                for(int i=0;i<n;i++){
                    A[i] = in.nextInt();
                }
                int start = 0;
                ArrayList<int[]> result = new ArrayList<int[]>();

                Permutation(A,start,n,result);
                Set<String> sortResult = new TreeSet<String>();

                for(int[] out:result){
                    if(isLegal(A,out,n)){
                        StringBuilder sb = new StringBuilder();
                        for(int i=0;i<n-1;i++){
                            sb.append(out[i]).append(" ");
                        }
                        sb.append(out[n-1]);
                        sortResult.add(sb.toString());
//                  System.out.println(sb.toString());
                    }
                }
                for(String list:sortResult){
                    System.out.println(list);
                }
            }
            in.close();

        }
        private static boolean isLegal(int[] in,int[] out,int n){
            LinkedList<Integer> stack = new LinkedList<Integer>();
            int i=0;
            int j=0;
            while(i<n){ // in 还有元素的时候都需要判断
                if(in[i] == out[j]){ //  相等时候就不用入栈，直接后移
                    i++;
                    j++;
                }else{
                    if(stack.isEmpty()){ //空stack 就只有入栈了
                        stack.push(in[i]);
                        i++;
                    }else{
                        int top = stack.peek(); // 栈顶元素相等，进行出栈
                        if(top ==out[j]){
                            j++;
                            stack.pop();
                        }else { //  不等时候入栈
                            stack.push(in[i]);
                            i++;
                        }
                    }
                }
            }
            while(!stack.isEmpty() && j<n){ // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素 相同
                int top = stack.pop();
                if(top == out[j]){
                    j++;
                }else{
                    return false;
                }
            }
            return true;

        }
        /**
         * 求出所有排列
         * @param A
         * @param start
         * @param n
         * @param result
         */
        private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){
            if(start == n){
                return;
            }
            if(start == n-1){
                int[] B = A.clone();
                result.add(B);
                return;
            }
            for(int i=start;i<n;i++){
                swap(A,start,i);
                Permutation(A,start+1,n,result);
                swap(A,start,i);
            }

        }
        private static void swap(int[] A,int i,int j){
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }
    }
