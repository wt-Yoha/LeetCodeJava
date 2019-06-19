package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyGUI implements ActionListener {
    JFrame frame;
    JButton button;
    int output;
    Thread r;

    public void setRecive(Thread r){
        this.r = r;
    }

    public void go(){
        frame = new JFrame("MyGUI");
        button = new JButton("PressMe");
        Container pane = frame.getContentPane();
        pane.add(button,BorderLayout.CENTER);
        button.addActionListener(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        output = (int) (Math.random()*10);
        System.out.print("Press me\n");
        r.resume();
    }
}

class MyTreadGUI implements Runnable{
    int output=-1;
    MyGUI myGUI=null;

    @Override
    public void run() {
        Thread.currentThread().suspend();
        if(myGUI!=null)
            output = myGUI.output;
    }
}

public class Test_Thread {

    public static void main(String[] args){
        MyTreadGUI g = new MyTreadGUI();
        MyGUI mg = new MyGUI();

        g.myGUI = mg;
        mg.go();

//        try {
//            for(int i=0;i<10;i++) {
//                Thread t = new Thread(g);  //创建接收线程t
//                mg.setRecive(t);  //关联两个线程
//                t.start();  //t启动时即阻塞自己，等待mg监听对应的事件后唤醒
//                t.join();  //main等待接收线程结束（强制主线程等待，相当于让主线程阻塞了）
//                System.out.println("This is in main().\nThe output is "+g.output);
//            }
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }

        //========================更优雅的方法===========================
        Thread main = Thread.currentThread();

        mg.setRecive(main);  //将当前主线程与GUI关联

        try {
            for(int i=0;i<3;i++) {
                main.suspend();  //挂起自己，等待事件响应后被唤醒
                System.out.println("This is in main().\nThe output is "+mg.output);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }


        System.out.println("Main is end.\n");
    }
}
