package huawei;

/**
 * Created by Gaochao on 2015/9/10.
 */
import java.util.Scanner;
public class FibGame {
    //这里为什么声明数列长度为48呢？因为计算到f[48]已经接近超出int的数据范围了
    private int[] fib=new int[48];
    public void f(){
        fib[0]=0;fib[1]=1;
        for (int i=2;i<48;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
    }
    public void input(){
        Scanner cin=new Scanner(System.in);
        int n;
        while(cin.hasNext()){
            n=cin.nextInt();
            if (n<=1||n>48){
                System.out.println("请输入大于2小于48的数字");
                return;
            }
            boolean flag=false;
            for (int i=3;i<48;i++){
                if (n==fib[i]){
                    flag=true;
                    break;
                }
            }
            if (flag){
                System.out.println("Second win");
            }else{
                System.out.println("First win");
            }
        }
    }
    public static void main(String arg[]){
        FibGame fg=new FibGame();
        fg.f();
        fg.input();
    }
}