package Java_web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Sokect_Serve {
    public static void main(String[] args){
        ServerSocket s = null;
        Socket s1;
        String send = "Hello world!";
        OutputStreamWriter d;

        try {
            s = new ServerSocket(6167);
        } catch (IOException e) {
            e.printStackTrace();
        }


        while(true){
            try{
                s1 = s.accept();
                d = new OutputStreamWriter(s1.getOutputStream());
                d.write(send);

//                send = s1.

                d.close();

//                s1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
