package LinkList;

import java.util.ArrayList;

public class IsPalidrome {
    @SuppressWarnings("unused")
    private static boolean isPalidrome1(ListNode head){
        //时间复杂度O(1) 空间复杂度O(n)
        ArrayList<Integer> h = new ArrayList<>();
        ListNode p = head;

        while(p!=null){
            h.add(p.val);
            p = p.next;
        }

        for(int i=0;i<h.size()/2;i++){
            if(!h.get(i).equals(h.get(h.size()-1-i)))
                return false;
        }


        return true;
    }

    private static boolean isPalidrome2(ListNode head) {
        //时间复杂度为O(n) 空间复杂度O(1)
        ListNode h = head,rear;//rear is the last 2 number

        while(h!=null){
            rear = h;
            while(rear.next!=null&&rear.next.next!=null){
                rear = rear.next;
            }
            if(rear.next!=null&&h.val!=rear.next.val)
                return false;
            h = h.next;
            rear.next = null;
        }


        return true;
    }

    public static void main(String[] args){
        ListNode h;
        h = ListNode.BuildList("-129 34 45 45 43 -129");
        if(h!=null) {
            System.out.println(h.toString());
            System.out.println(isPalidrome2(h));
        }
    }
}
