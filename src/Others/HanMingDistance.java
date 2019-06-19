package Others;

import static Others.CoutOne.hanmingWeight;

public class HanMingDistance {

    public static int hanmingDistance(int x,int y){
        return hanmingWeight(x^y);
    }

    public static void main(String[] args){
        System.out.print(hanmingDistance(1,4));
    }
}
