package reverselinkedlistII;

/**
 * Created by Gaochao on 2015/9/20.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode res=null;
        while (head!=null){
            ListNode temNode=head;
            head=head.next;
            temNode.next=res;
            res=temNode;
        }
        return res;

    }
}
