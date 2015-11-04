package stack;
import java.util.Stack;
/**
 * Created by Gaochao on 2015/9/10.
 */
public class MinStack {
    private Stack<Integer> stack=new Stack<Integer>();
    private Stack<Integer> minStack=new Stack<Integer>();
    public void push(int data){
        stack.push(data);
        if (minStack.size()==0||data<minStack.peek()){
            minStack.push(data);
        }else
            minStack.push(minStack.peek());
    }
    public int pop(){
        if (stack.size()==0)
            System.out.println("empty");
        minStack.pop();
        return stack.pop();
    }
    public int min(){
        if (minStack.size()==0){
            System.out.println("empty");
        }
        return minStack.pop();
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(4);
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.min());
    }
}
