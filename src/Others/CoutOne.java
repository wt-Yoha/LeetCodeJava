package Others;

public class CoutOne {

    public static int hanmingWeight(int n){
        int res = 0;
        while(n>0){
            res += n&1;
            n = n>>>1;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.print(hanmingWeight(214748364));
    }
}
