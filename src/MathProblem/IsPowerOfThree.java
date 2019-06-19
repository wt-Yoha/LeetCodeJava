package MathProblem;

public class IsPowerOfThree {

    private static boolean isPowerOfThree(int n){
        double x = Math.log10(n)/Math.log10(3);
        int y = (int)x;
        if(x-y<0.0000000000001) {
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args){
        System.out.print(isPowerOfThree(1162261468));
    }
}
