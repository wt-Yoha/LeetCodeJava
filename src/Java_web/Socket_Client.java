package Java_web;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Socket_Client implements Runnable {
    int ID;

    Socket_Client(int i){
        ID = i;
    }

    @Override
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.print("The thread ID is " + ID + " ");
                try {
                    go();
                    Thread.sleep(2000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void go() throws IOException {
        Socket s;
        String recive;
        char[] c = new char[50];
        InputStreamReader d;

        s = new Socket(InetAddress.getLocalHost(),6167);
        d = new InputStreamReader(s.getInputStream());
        d.read(c);
        System.out.println(String.valueOf(c));
        s.close();
    }

    public static void main(String[] args){
        Thread t1 = new Thread(new Socket_Client(1));
        Thread t2 = new Thread(new Socket_Client(2));

        t1.start();
        t2.start();

        System.out.println("Main thread is end.");
    }
}
