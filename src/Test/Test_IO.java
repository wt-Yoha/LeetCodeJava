package Test;

import java.io.*;

public class Test_IO {
    public static void main(String[] args){
        try {
//            DataInputStream fp = new DataInputStream(new FileInputStream("test.txt"));
            DataOutputStream fp = new DataOutputStream(
                                        new BufferedOutputStream(
                                                new FileOutputStream("test.txt")));
            fp.writeInt(1233);
            fp.flush();
            fp.close();
            DataInputStream ip = new DataInputStream(new FileInputStream("test.txt"));
            int x = ip.readInt();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
