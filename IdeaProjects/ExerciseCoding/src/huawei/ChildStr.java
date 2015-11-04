package huawei;

/**
 * Created by Gaochao on 2015/9/10.
 */
import java.util.Scanner;
public class ChildStr {
    private String str;
    private int len;
    public void input(){
        Scanner cin=new Scanner(System.in);
        str=cin.nextLine();
        len=str.length();
        if (str!=null&&len>9){
            str=null;
            return;
        }
        for (int i=0;i<len;i++){
            char c=str.charAt(i);
            if (c<'1'||c>'9'){
                str=null;
                return;
            }
        }
    }
    public void search(){
        if (str==null){
            return;
        }
        String s=null;
        for (int i=0;i<len-1;i++){
            s=str.substring(i,i+1);//截取子串
            if (str.lastIndexOf(s)!=i){//从尾部检索是否包含s，返回其位置
             System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    public static void main(String arg[]){
        ChildStr cs=new ChildStr();
        cs.input();
        cs.search();
    }
}