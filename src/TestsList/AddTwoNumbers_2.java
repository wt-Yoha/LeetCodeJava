package TestsList;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x;}
}


public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode p1=l1, p2=l2, pr=new ListNode(-1), rear;
        pr.next = l1;

        while(p1!=null && p2!=null){
            sum = p1.val + p2.val + carry;
            if(sum>9){
                p1.val = sum - 10;
                carry = 1;
            }
            else {
                p1.val = sum;
                carry = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
            pr  = pr.next;
        }

        if(p1!=null){
            rear = p1;
        }
        else if (p2!=null){
            pr.next = p2;
            rear = p2;
        }
        else {
            rear = null;
        }

        while (carry > 0 && rear != null){
            sum = rear.val + carry;
            if(sum > 9){
                rear.val = sum - 10;
                carry = 1;
            }
            else {
                rear.val = sum;
                carry = 0;
            }
            rear = rear.next;
            pr = pr.next;
        }

        if (carry > 0){
            ListNode node = new ListNode(carry);
            pr.next = node;
        }
        return l1;
    }

    public static ListNode produceList(int x){
        ListNode l = new ListNode(-1), pr = l;
        while(x > 0){
            ListNode node = new ListNode(x%10);
            x /= 10;
            pr.next = node;
            pr = node;
        }
        return l.next;
    }

    public static void printList(ListNode l){
        ListNode p = l;
        StringBuilder res = new StringBuilder();
        while(p != null){
//            System.out.print(p.val);
            res.append(p.val);
            p = p.next;
        }
        for(int i=res.length()-1;i>=0;i--){
            System.out.print(res.charAt(i));
        }
    }

    public static void main(String[] args) {
        int a = 199, b = 99;
        ListNode l1 = produceList(a);
        ListNode l2 = produceList(b);
        ListNode sum;
        printList(l1);
        System.out.println();
        printList(l2);
        System.out.println();
        sum = addTwoNumbers(l1, l2);
        printList(sum);
    }
}
