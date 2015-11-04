package ZhezhiProblem;

/**
 * Created by Gaochao on 2015/8/3.
 */
public class ZhezhiProblem {
    public static void main(String[] args) {
        printZhexian(1, 3, true);
    }
    public static void printZhexian(int i,int N,boolean flag){
        if(i>N){
            return;
        }
        printZhexian(i+1, N, true);
        System.out.println(flag?"down":"up");
        printZhexian(i+1, N, false);
    }
}
