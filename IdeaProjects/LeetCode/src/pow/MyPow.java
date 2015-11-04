package pow;

/**
 * Created by Gaochao on 2015/9/22.
 */
public class MyPow {
    public double myPow(double x,int n){
        if (n<0){
            return 1.0/power(x,-n);
        }else {
            return power(x,n);
        }
    }
    public double power(double x,int n){
        if (n==0)
            return 1;
        double r=power(x,n/2);
        if (n%2==1){
            return r*r*x;
        }else {
            return r*r;
        }

    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2,10));
    }
}
