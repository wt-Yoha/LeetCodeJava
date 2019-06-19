package MathProblem;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n){
        ArrayList<String> s = new ArrayList<>();
        String f = "Fizz", b = "Buzz";
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0)
                s.add(f+b);
            else if(i%3==0)
                s.add(f);
            else if(i%5==0)
                s.add(b);
            else
                s.add(i+"");
        }
        return s;
    }

    public static void main(String[] args){
        System.out.print(fizzBuzz(15));
    }
}
