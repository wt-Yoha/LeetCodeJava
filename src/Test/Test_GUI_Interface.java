package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyGUI2 extends JFrame implements ActionListener {
//    private int out;
//    private final Character x;
    private Box x;

    MyGUI2(Box x){
        this.x = x;
    }

    void go(){
        JFrame frame;
        Container container;
        JButton b1;
        JButton b2;
        JButton b3;
        JPanel panel = new JPanel();
        frame = new JFrame("MyGUI2");
        container = frame.getContentPane();

        b1 = new JButton("press=1");
        b2 = new JButton("press=2");
        b3 = new JButton("press=3");

        container.add(panel,BorderLayout.SOUTH);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

//    public int getOut() { return out; }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "press=1":
//                out = 1;
                x.push(1);
                break;
            case "press=2":
//                out = 2;
                x.push(2);
                break;
            default:
//                out = 3;
                x.push(3);
                break;
        }
//        synchronized (x){
////            System.out.println("Main thread will be notified");
//            x.notify();
//        }
    }
}

class Box{
 private int box;

 synchronized void push(int x) {
     box = x;
     notify();
 }

 synchronized int getBox(){
     try {
         wait();
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     return box;
 }
}

public class Test_GUI_Interface {
    public static void main(String[] args){
//        Character out = 0;
        Box b = new Box();
        MyGUI2 mg = new MyGUI2(b);
        StringBuilder s = new StringBuilder();
        mg.go();

        while(true) {

//            System.out.println("Main thread in while loop");

//            synchronized (out){  // 这种方式还是不被推荐，一个synchronized的变量很危险，最好是一段代码
//                                 // 因此实现方式最好还是创建一个类作为synchronize的对象
//                try {
//                    out.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

//            System.out.println("Main thread is been weak");

//            int c = mg.getOut();

            int c = b.getBox();
            
            s.append((char)(c+'0'));
            System.out.println("You pressed the button "+c);

            if(s.length()==3){
                if(s.toString().equals("213")){
                    System.out.println("Password right, let's break!");
                    break; }
                else{
                    System.out.println("Wrong password!");
                    s.delete(0,s.length()); }
            }

        }

    }
}
