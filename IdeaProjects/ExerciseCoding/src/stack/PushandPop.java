package stack;

import java.util.Stack;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class PushandPop {
    public static boolean sequenseIsPop(int[] data1,int[] data2){
        Stack<Integer> stack=new Stack<Integer>();
        for (int i=0,j=0;i<data1.length;i++){
            stack.push(data1[i]);
            while (stack.size()>0&&stack.peek()==data2[j]){
                stack.pop();
                j++;
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 3, 4, 5};
        int[] data2 = {4, 5, 3, 2, 1};
        int[] data3 = {4, 5, 2, 3, 1};
        System.out.println(sequenseIsPop(data1,data2));
        System.out.println(sequenseIsPop(data1,data3));
    }
}
