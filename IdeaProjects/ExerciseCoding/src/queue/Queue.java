package queue;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class Queue {
    public QueueNode head;
    public QueueNode current;
    public void add(int data){
        if (head==null){
            head = new QueueNode(data);
            current=head;
        }else {
            QueueNode queueNode=new QueueNode(data);
            current.next=queueNode;
            current=current.next;
        }
    }
    public QueueNode pop(){
        if (current==null)
            return null;
        QueueNode res=head;
        head=head.next;
        return res;
    }

    public static void main(String[] args) {
        Queue queue=new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.pop().data);
        System.out.println(queue.pop().data);
        System.out.println(queue.pop().data);
    }
}

class QueueNode{
    int data;
    QueueNode next;
    public QueueNode(int data){
        this.data=data;
    }
}