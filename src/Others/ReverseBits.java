package Others;

public class ReverseBits {
    static int reverseBits(int n){
        int r = 0;
        for(int i=0;i<32;i++){
            r <<= 1;
            r |= n&1;
            n >>>= 1;
        }
        return r;
    }

    public static void main(String[] args){
        System.out.print(reverseBits(214748368));
    }
}
