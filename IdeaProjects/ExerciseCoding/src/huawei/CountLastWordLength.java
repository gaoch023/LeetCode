package huawei;

import java.util.Scanner;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class CountLastWordLength {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String s=scanner.nextLine();
        if (s==null){
            return;
        }
        String[] strings=s.trim().split(" ");
        int length=strings[strings.length-1].length();
        System.out.println(length);
    }
}
