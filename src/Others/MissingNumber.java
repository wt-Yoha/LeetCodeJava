package Others;

public class MissingNumber {

    static int missingNumber(int[] nums){
        if(nums.length==0) return 0;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }

        return nums.length*(nums.length+1)/2-sum;
    }

    public static void main(String[] args){
        int[] n = {9,6,4,2,3,5,7,0,1};
        System.out.print(missingNumber(n));
    }
}
