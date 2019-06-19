package LinkList;

public class RemoveNth_FromENd {

    public static ListNode removeNthFromEnd(ListNode head,int n){

        ListNode pre = head, lat = head;

        for(int i=1;i<n&&lat!=null;i++) {
            lat = lat.next;
        }

        if(lat==null)
            return pre;

        if(lat.next==null)
            return pre.next;

        while(lat.next!=null&&lat.next.next!=null){
            pre = pre.next;
            lat = lat.next;
        }

        pre.next = pre.next.next;

        return head;
    }

    public static void main(String[] args){
        ListNode p,h = new ListNode(0);
        p = h;

        for(int i=1;i<=1;i++){
            p.LinkNode(i);
            p = p.next;
        }

        System.out.print(h.toString());
        System.out.println();

        h = removeNthFromEnd(h,2);

        if(h!=null)
            System.out.print(h.toString());
        else
            System.out.print("空链表");
    }

}
