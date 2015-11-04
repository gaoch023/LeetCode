package huawei;

/**
 * Created by Gaochao on 2015/9/10.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MinRectangle {
    public static void main(String arg[]){
        List<Integer> ldata=new ArrayList<Integer>();
        boolean flag=false;
        // (0,0)连续出现的次数，连续出现两次即结束输入
        int testNum=0;// 测试用例的个数
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            int x=cin.nextInt();
            int y=cin.nextInt();
            if (Math.abs(x)>1000||Math.abs(y)>1000)
                return;
            if (x==0&&y==0){
                if (flag){
                    break;
                }else{
                    flag=true;//一个测试用例结束
                    testNum++;
                }

            }else
                flag=false;
            ldata.add(x);
            ldata.add(y);
        }
        cin.close();
        int size=ldata.size();
        int k=0;
        for (int i=0;i<testNum;i++){
            int minX=Integer.MAX_VALUE;
            int minY=Integer.MAX_VALUE;
            int maxX=Integer.MIN_VALUE;
            int maxY=Integer.MIN_VALUE;
            for (;k<size/2;k++){
                int x=ldata.get(2*k);
                int y=ldata.get(2*k+1);
                if (x==0&&y==0){
                    k++;
                    break;// 一个测试用例结束
                }
                minX=Math.min(x,minX);
                minY=Math.min(y,minY);
                maxX=Math.max(x, maxX);
                maxY=Math.max(y,maxY);
            }
            if (minX!=maxX&&minY!=maxY&&minX!=Integer.MAX_VALUE&&  minY!=Integer.MAX_VALUE&&maxX!=Integer.MIN_VALUE&&maxY!=Integer.MIN_VALUE){
                System.out.println(minX+" "+minY+" "+maxX+" "+maxY);
            }
        }
    }
}