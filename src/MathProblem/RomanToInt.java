package MathProblem;

import java.util.HashMap;

public class RomanToInt {

    public static int romanToInt(String s){
        HashMap<Character,Integer> d = new HashMap<>();
        int sum=0,pre,cur=Integer.MIN_VALUE;

        d.put('I',1);
        d.put('V',5);
        d.put('X',10);
        d.put('L',50);
        d.put('C',100);
        d.put('D',500);
        d.put('M',1000);

        for(int i=0;i<s.length();i++){
            pre = cur;
            cur = d.get(s.charAt(i));
            sum += cur;
            if(cur>pre)
                sum -= 2*pre;
        }

        return sum;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
//        String s = "MC";
        System.out.print(romanToInt(s));
    }
}
