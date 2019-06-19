package GUI_Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameDemo {
    public static void main(String[] args){
        JFrame frame = new JFrame("JFrameDemo");

        MyEventTest tt = new MyEventTest("kakaka");

        tt.go();

//        frame.getContentPane().add(button, BorderLayout.CENTER);
//
//        frame.pack();
//        frame.setVisible(true);
    }
}

class MyEventTest extends JFrame implements KeyListener, MouseMotionListener, MouseListener {
    String name;
    JFrame J;
    JTextField tf;

    MyEventTest(String text){
        this.name = text;
    }

    public void go(){

        MyButton button = new MyButton("Press me");

        J = new JFrame();
        tf = new JTextField(30);
        J.getContentPane().add(new Label("Click and drag mouse"),BorderLayout.NORTH);
        J.getContentPane().add(tf, BorderLayout.SOUTH);
        J.getContentPane().add(button,BorderLayout.CENTER);

        J.addKeyListener(this);
        J.addMouseListener(this);
        J.addMouseMotionListener(this);

        J.setSize(300,300);
        J.setVisible(true);
    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String s="Mouse entered";
        tf.setText(s);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String s="Mouse exit";
        tf.setText(s);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        String s="Mouse dragging: X="+e.getX()+" Y="+e.getY();
        tf.setText(s);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(this.name);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}

class MyButton extends JButton implements ActionListener{
    MyButton(String s){
        super(s);
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action occurred.\n");
    }
}