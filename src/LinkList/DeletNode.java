package LinkList;

public class DeletNode {

    static void deletNode(ListNode node){
        ListNode cur = node,next = node.next;

        while(next!=null){
            cur.val = next.val;

            if(next.next==null)
            {
                cur.next = null;
                break;
            }

            cur = next;
            next = next.next;
        }

    }

    public static void main(String[] args){
        ListNode p, h;

        h = new ListNode(0);
        p = h;

        for(int i=1;i<8;i++){
            p.LinkNode(i);
            p = p.next;
        }

        System.out.print(h.toString());
        System.out.println();

        p = h;
        while(p!=null){
            if(p.val==3)
                break;
            p = p.next;
        }

        deletNode(p);

        System.out.print(h.toString());

    }
}
