package SortAndSearch;

public class FirstBadVersion {
    static int[] v;

    public static boolean isBadVersion(int version){
        return v[version]==-1;
    }

    public static int firstBadVersion(int n){
        int l=0,h=n-1,mid;
        while(l<h){
            mid = (h-l)/2+l;
            if(isBadVersion(mid))
                h = mid;
            else
                l = mid+1;
        }
        return l+1;
    }

    public static void main(String[] args) {
//        int n = 100;
//        int bad = (int) (Math.random() * n);
        int n = 1;
        int bad = 0;
        v = new int[n];

        v[0] = -1;
//        for(int i=bad;i<v.length;i++)
//            v[i] = -1;

        System.out.println("The first bad one is "+bad);
        System.out.print("The test result is "+firstBadVersion(n));
    }

}
