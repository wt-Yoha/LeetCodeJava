package LinkList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void LinkNode(int x){
        ListNode n = new ListNode(x);
        this.next = n;
    }

    public static ListNode BuildList(String s){
        ListNode h = new ListNode(-1),p = h;
        String[] data = s.split(" ");

        for(String num : data){
            try {
                p.LinkNode(Integer.parseInt(num));
            }catch(Exception e){
                System.out.println("非法字符！");
                return null;
            }
            p = p.next;
        }
        return h.next;
    }

    public String toString(){
        StringBuffer b = new StringBuffer();
        ListNode n = this;
        while(n!=null)
        {
            b.append(n.val);
            b.append(" ");
            n = n.next;
            if(n==this)
            {
                System.out.println("循环链表");
                break;
            }
        }
        return b.toString();
    }

}
