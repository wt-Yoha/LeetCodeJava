package Java_web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Detect_Available_IP {
    private static StringBuilder res = new StringBuilder();

    private synchronized static void add(String s) {
        res.append(s);
    }

    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String local = host.getHostAddress();
        ArrayList<Thread> tl = new ArrayList<>();

        for (int i = 2; i <= 255; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                String address = local.substring(0, 11) + String.valueOf(finalI);
                if (isConnected(address, finalI - 1))
                    res.append(address+"\n");
//                    add(address + "\n");
            });
                tl.add(t);
                t.start();
            }

            for (Thread t : tl) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("如下地址可以链接：\n" + res.toString());
        }

    private static boolean isConnected(String address, int n){
            boolean res = true;
            try {
                Process p = Runtime.getRuntime().exec("ping " + address);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.length() != 0 && line.equals("请求超时。")) {
                        res = false;
                        break;
                    }
                }
                System.out.println("已完成第" + n + "个 ip 测试");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }


}
