package stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class Stack2 {
    private Queue<Integer> queue1=new ArrayDeque<Integer>();
    private Queue<Integer> queue2=new ArrayDeque<Integer>();

    public void push(int data){
        queue1.add(data);
    }
    public int pop(){
        int data=0;
        if (queue1.size()==0){
            System.out.println("empty");
        }
        while (queue1.size()!=0){
            if (queue1.size()==1){
               data=queue1.poll();

            }else
            queue2.add(queue1.poll());
        }
        while (queue2.size()!=0){
            queue1.add(queue2.poll());
        }
        return data;
    }

    public static void main(String[] args) {
        Stack2 stack2=new Stack2();
        stack2.push(1);
        stack2.push(3);
        stack2.push(4);
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
    }


}
