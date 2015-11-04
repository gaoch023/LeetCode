package removeDuplicates;

/**
 * Created by Gaochao on 2015/9/8.
 */
public class DeleteDuplicatesFromList {

    public ListNode deleteDuplicates(ListNode head){
        if (head==null){
        return null;
        }

        ListNode temp=head;
        ListNode temp2=head.next;
        while (temp2!=null){

            if (temp.val==temp2.val){
                temp.next=temp2.next;

            }else {
                temp=temp2;
            }
            temp2=temp2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(3);
        l1.next=l2;
       // l2.next=l3;
        ListNode l4=null;
        ListNode result=new DeleteDuplicatesFromList().deleteDuplicates(l1);
            while (result!=null) {
                System.out.println(result.val);
                result = result.next;
            }

    }
}
class ListNode{
    int val=0;
    ListNode next=null;
    public ListNode(int value){
        val=value;
    }
}