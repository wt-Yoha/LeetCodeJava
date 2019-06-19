package LinkList;

import java.util.HashSet;

public class HasCycle {

    private static boolean hasCycle(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;

        while(p!=null){
            if(!set.contains(p))
                set.add(p);
            else
                return true;
            p = p.next;
        }

        return false;
    }

    public static void main(String[] args){
        ListNode h = ListNode.BuildList("1 23 34 1 56 2");
        ListNode p = h;

        while(p.next!=null){
            p = p.next;
        }

        p.next = h.next.next;

        System.out.println(hasCycle(h));

    }


}
