package SortAndSearch;

public class MergeTwoOrderArrary {

    public static void merge(int[] nums1,int m,int[] nums2,int n){
        if(nums2==null) return;
        int i=0,j=0,jj=0,len=0;
        for(;i<m;i++){
            while(jj<n&&nums1[i]>nums2[jj]){
                jj++;
            }
            if(jj>j){
                len = jj-j;
                for(int k=m-1;k>=i;k--)
                    nums1[k+len] = nums1[k];
                for(int k=0;k<len;k++)
                    nums1[i+k] = nums2[j++];
                i += len;
                m += len;
            }
        }
        while(j<n) nums1[i++] = nums2[j++];
    }

    public static void main(String[] args){
        int[] nums1 = {2,0};
        int[] nums2 = {1};
//        int[] nums1 = {1,1,5,5,7,7,0,0,0,0,0,0};
//        int[] nums2 = {3,3,4,4,8,8};
//        int[] nums2=null;

        merge(nums1,1,nums2,1);

        for(int i : nums1){
            System.out.print(i);
        }

    }

}
