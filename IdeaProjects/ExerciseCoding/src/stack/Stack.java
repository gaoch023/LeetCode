package stack;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class Stack {
    public Node head;
    public Node current;
    public void push(int data){
        if (head==null){
            head=new Node(data);
            current=head;
        }else {
            Node node=new Node(data);
            node.pre=current;
            current=node;
        }


    }
    public Node pop(){
        if (current==null)
            return null;
        Node node=current;
        current=current.pre;
        return node;
    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
    }
}

