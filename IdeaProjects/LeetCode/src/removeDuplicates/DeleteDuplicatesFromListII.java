package removeDuplicates;

/**
 * Created by Gaochao on 2015/9/8.
 */
public class DeleteDuplicatesFromListII {

    public ListNode deleteDuplicates(ListNode head){
        if (head==null){
            return null;
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
