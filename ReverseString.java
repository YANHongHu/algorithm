public class ReverseString {
    public String reverseString(String iniString) {
        // write code here
        if(iniString.length() == 1||iniString == null){
            return iniString;
        }
        StringBuffer s = new StringBuffer(iniString);
        s.reverse();
        return s.toString();
    }
}
