package reverselinkedlistII;

/**
 * Created by Gaochao on 2015/9/20.
 */
public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m, int n){
        if (m==n)
        {
            return head;
        }
        ListNode tempNode=null,endNode=null;
        ListNode indexNode=head;
        ListNode resNode=null;
        int index=1;
            if (m>1) {
                while (index < m - 1) {
                    indexNode = indexNode.next;
                    index++;
                }
                if (index == m - 1) {
                    tempNode = indexNode;
                    indexNode = indexNode.next;
                    index++;
                    endNode = indexNode;

                }
                while (index <= n) {
                    ListNode listNode = indexNode;
                    indexNode = indexNode.next;
                    index++;

                    listNode.next = resNode;
                    resNode = listNode;


                }
                endNode.next = indexNode;
                tempNode.next = resNode;
            }else if (m==1){

                endNode=indexNode;
                while (index <= n) {
                    ListNode listNode = indexNode;
                    indexNode = indexNode.next;
                    index++;

                    listNode.next = resNode;
                    resNode = listNode;


                }
                endNode.next = indexNode;
                head = resNode;
            }



        return head;

    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(3);
        ListNode n3=new ListNode(4);
        ListNode n4=new ListNode(6);
        ListNode n5=new ListNode(8);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        ListNode n6=new ListNode(3);
        ListNode n7=new ListNode(5);
        n6.next=n7;

        ListNode res=reverseBetween(n6,1,2);
        while (res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }

    }
}
class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}