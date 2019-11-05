public class PalinDrome {
    public static void main(String[] args) {
        String a  =  "aab";
        String b  =  "b";
        System.out.println(CountPalinDrome(a,b));
    }

    private static int CountPalinDrome(String a, String b) {
        int count = 0;
        for(int i = 0;i<=a.length();i++){
            StringBuffer A = new StringBuffer(a);
            A.insert(i,b);
            if(isHuiWen(A.toString())){
                count++;
            }
        }
        return count;
    }

    private static boolean isHuiWen(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
