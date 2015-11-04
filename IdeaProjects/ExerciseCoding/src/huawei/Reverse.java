package huawei;

import java.util.Scanner;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine().trim();
        if (s==null){

            return;
        }
        char[] chars=s.toCharArray();

        int low=0;
        int high=s.length()-1;
        while (low<=high){
            char c=chars[low];
            chars[low]=chars[high];
            chars[high]=c;
            low++;
            high--;
        }

        System.out.println(chars);

    }
}
