package DesignProblem;

class Solution{
    int[] origin;

    Solution(int[] nums){
            origin = nums.clone();
    }

    public int[] reset(){
        return origin;
    }

    public int[] shruff(){
        int[] d = origin.clone();
        for(int i=0;i<d.length;i++){
            int t = d[i];
            int len = (int)(Math.random()*10);
            d[i] = d[(i+len)%d.length];
            d[(i+len)%d.length] = t;
        }
        return d;
    }

}

public class ShruffAnArrary {
    public static void Print(int[] n){
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] n = {1,2,3};
        Solution obj = new Solution(n);
        int[] p1 = obj.reset();
        int[] p2 = obj.shruff();
        Print(n);
        Print(p1);
        Print(p2);

    }
}
