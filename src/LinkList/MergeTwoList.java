package LinkList;

public class MergeTwoList {

    private static ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode head = new ListNode(-1);
        ListNode p = head, p1, p2;

        if(l1.val<l2.val){
            p1 = l1;
            p2 = l2;
        }
        else{
            p1 = l2;
            p2 = l1;
        }

        while(p2!=null){
              p.next = p1;
              while(p1!=null&&p1.val<=p2.val) {
                    p1 = p1.next;
                    p = p.next;
              }
              p.next = p2;
              if(p1==null)
                  break;
              while(p2!=null&&p2.val<p1.val) {
                  p2 = p2.next;
                  p = p.next;
              }
        }

        if(p1!=null)
            p.next = p1;

        if(p2!=null)
            p.next = p2;

        return head.next;
    }



    public static void main(String[] args){
        ListNode p,h1,h2;

        h1 = ListNode.BuildList("1133377789");
        h2 = ListNode.BuildList("00222446699");

        System.out.print(h1.toString());
        System.out.println();
        System.out.print(h2.toString());
        System.out.println();

        p = mergeTwoList(h1,h2);

        System.out.print(p.toString());

    }
}
