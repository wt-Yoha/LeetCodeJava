package MathProblem;

public class PrimeNumbers {

    public static boolean isPrime(int n){
        if(n==1||n==0) return false;
        for(int i=2;i<=(int)(Math.sqrt(n));i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static int countPrimes(int n){
        int sum=0;
        int[] table = new int[n];
        for(int i=2;i<n;i++) {
            if(table[i]!=1) sum++;
            for(int j=2;i<=(int)(Math.sqrt(n))&&j*i<n;j++)
                    table[j*i]=1;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.print(countPrimes(20));
    }
}
