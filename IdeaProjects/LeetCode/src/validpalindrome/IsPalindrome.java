package validpalindrome;

/**
 * Created by Gaochao on 2015/9/15.
 */
public class IsPalindrome {
    public boolean isPalindrome(String s){
        if (s==null||s.trim().length()==0)
            return true;
        int i=0;
        int j=s.length()-1;
        while (i<j){
            while (i<j&&!Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i<j&&!Character.isLetterOrDigit(s.charAt(j)))  j--;
            if (Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
