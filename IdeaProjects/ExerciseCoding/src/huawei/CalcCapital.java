package huawei;

import java.util.Scanner;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class CalcCapital {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        if (s.trim()==null){
            System.out.println(0);
            return ;
        }
        char[] chars=s.trim().toCharArray();
        int count=0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]>='A' && chars[i]<='Z'){
                count++;
            }
        }

        System.out.println(count);
    }
}
