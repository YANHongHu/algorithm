public class test {
    public static void main(String[] args) {
        for(int i=3;i<9;i++){
            for (int j=i;j<=9;j++){
                if(i==j){
                    while (--i>=0&&++j<=9&&i<j){
                        System.out.println(i);
                        System.out.println(j);
                    }
                }
            }
        }

    }
}
