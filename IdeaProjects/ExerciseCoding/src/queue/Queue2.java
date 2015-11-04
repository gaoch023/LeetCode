package queue;

import java.util.Stack;


/**
 * Created by Gaochao on 2015/9/10.
 */
public class Queue2 {
    private Stack<Integer> stack1=new Stack();
    private Stack<Integer> stack2=new Stack();
    public void push(int data){
        stack1.push(data);
    }
    public int pop(){
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()){
            System.out.println("empty");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Queue2 queue2=new Queue2();
        queue2.push(1);
        queue2.push(3);
        queue2.push(5);
        System.out.println(queue2.pop());
        System.out.println(queue2.pop());
        System.out.println(queue2.pop());
    }
}
