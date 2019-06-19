package Others;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidBracket {

    static boolean isValid(String s){
        if(s==null) return true;
        HashMap<Character,Character> m = new HashMap<>();
        ArrayList<Character> stack = new ArrayList<>();
        int top = -1;

        m.put('(',')');
        m.put('[',']');
        m.put('{','}');

        for(int i=0;i<s.length();i++){
            if(top==-1){
                stack.add(s.charAt(i));
                top++;
            }
            else{
                char c = stack.get(top);
                if(m.containsKey(c)&&m.get(c)==s.charAt(i)){
                    stack.remove(top--);
                }
                else{
                    stack.add(s.charAt(i));
                    top++;
                }
            }
        }
        if(top==-1)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        System.out.print(isValid("()"));
    }
}
