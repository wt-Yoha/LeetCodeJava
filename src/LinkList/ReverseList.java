package LinkList;

public class ReverseList {

    public static ListNode reverse(ListNode head){
        if(head==null||head.next==null)
            return head;

        ListNode next = head.next;
        head.next = null;

        ListNode h = reverse(next);
        next.next = head;
        return h;
    }


    public static void main(String[] args){
        ListNode p,h = new ListNode(0);
        p = h;

        for(int i=1;i<=10;i++){
            p.LinkNode(i);
            p = p.next;
        }

        System.out.print(h.toString());
        System.out.println();

        h = reverse(h);

        System.out.print(h.toString());

    }
}
