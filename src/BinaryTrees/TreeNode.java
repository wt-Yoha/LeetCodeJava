package BinaryTrees;


class Queue{
    private Object[] queue;
    private int front=0;
    private int rear=0;
    private int len;

    Queue(){
        len = 20;
        queue = new Object[len];
    }

    Queue(int len){
        this.len = len;
        queue = new Object[len];
    }

    boolean isEmpty(){
        return front==rear;
    }

    boolean isFull(){
        return (rear+1)%len==front;
    }

    boolean add(Object x){
        if(isFull())
            return false;
        rear = (rear+1)%len;
        queue[rear] = x;
        return true;
    }

    Object delet(){
        if(isEmpty())
            return null;
        front = (front+1)%len;
        return  queue[front];
    }
}

public class TreeNode {
    int val;
    TreeNode left=null;
    TreeNode right=null;

    TreeNode(int x){ val = x; }

    public static TreeNode buildTreeByLine(String str){
        if(str==null) return null;
        TreeNode root, p, t;
        String[] data = str.split(" ");
        Queue queue = new Queue();
        int k = 1;

        root = new TreeNode(Integer.parseInt(data[0]));
        queue.add(root);

        while(!(queue.isEmpty())){
            p = (TreeNode) queue.delet();
            if(data[k].equals("null")||data[k].equals("n")) {
                p.left = null;
            }
            else {
                t = new TreeNode(Integer.parseInt(data[k]));
                p.left = t;
                queue.add(t);
            }
            k++;
            if(k>=data.length) break;
            if(data[k].equals("null")||data[k].equals("n")) {
                p.right = null;
            }
            else {
                t = new TreeNode(Integer.parseInt(data[k]));
                p.right = t;
                queue.add(t);
            }
            k++;
            if(k>=data.length) break;
        }
        return root;
    }

    public String preTravers(){
        StringBuffer b = new StringBuffer();
        b.append(val);
        b.append(" ");
        if(left!=null)
            b.append(left.preTravers());
        if(right!=null)
            b.append(right.preTravers());
        return b.toString();
    }

    public String orderTravers(){
        StringBuffer b = new StringBuffer();
        if(left!=null)
            b.append(left.orderTravers());
        b.append(val);
        b.append(" ");
        if(right!=null)
            b.append(right.orderTravers());
        return b.toString();
    }

    public static void main(String[] args){
        TreeNode t = TreeNode.buildTreeByLine("1 2 3 n n 4 5 n n n n ");
        System.out.println(t.orderTravers());
    }

}
