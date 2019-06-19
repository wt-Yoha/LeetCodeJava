package Others;

import java.util.ArrayList;
import java.util.List;

public class YanghuiTrangle {

    static List<List<Integer>> generate(int numsRows){
        if(numsRows==0) return null;
        List<List<Integer>> L = new ArrayList<>();
        List<Integer> t = new ArrayList<>();

        t.add(1);
        L.add(t);
        if(numsRows==1) return L;
        t = new ArrayList<>();
        t.add(1);
        t.add(1);
        L.add(t);
        if(numsRows==2) return L;

        for(int i=2;i<numsRows;i++){
            List<Integer> l = L.get(i-1);
            t = new ArrayList<>();
            t.add(1);
            for(int j=1;j<l.size();j++){
                t.add(l.get(j-1)+l.get(j));
            }
            t.add(1);
            L.add(t);
        }

        return L;
    }

    public static void main(String[] args){
        System.out.print(generate(6).toString());
    }

}
