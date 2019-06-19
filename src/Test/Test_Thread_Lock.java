package Test;


class Stack{
    int pos = -1;
    int[] stack = new int[4];
    int lock=0;

    public void push(int x){
        stack[++pos] = x;
    }

    public int pop(){
        return stack[pos--];
    }

    public boolean isEmpty(){ return pos==-1; }

    public boolean isFull(){ return pos==stack.length-1; }
}

class MyThread1 extends Thread {
    Stack s;
    MyThread1(Stack s){
        this.s = s;
    }

    @Override
    public void run() {
        for(int i=0;i<4;i++) {
//            if(!s.isFull()) {
                if(s.lock>0) {
                    s.lock=0;
                    s.push(i);
                    System.out.println("The number " + i + " is pushed");
                    s.lock=1;
                }
                else
                    System.out.println("T1 S is been occupied.");
//            }
//            else
//                System.out.println("In thread1 the stack is full!");
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Push task is over.");
    }
}

class MyThread2 extends MyThread1{

    MyThread2(Stack s) {
        super(s);
    }

    @Override
    public void run() {
        for(int i=0;i<4;i++) {
                if(s.lock>0) {
                    s.lock = 0;
                    if (!s.isEmpty()) {
                        System.out.println("In thread2 the number is " + s.pop());
                        s.lock = 1;
                    } else {
                        System.out.println("In thread2 the stack is empty!");
                        s.lock = 1;
                    }
                }
                else {
                        System.out.println("T2 S is been occupied.");
                }
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test_Thread_Lock {
    public static void main(String[] args) {
        Stack s = new Stack();
        MyThread1 t1 = new MyThread1(s);
        MyThread2 t2 = new MyThread2(s);
        t1.start();
        t2.start();
        System.out.println("The main thread is over.");
    }

}

