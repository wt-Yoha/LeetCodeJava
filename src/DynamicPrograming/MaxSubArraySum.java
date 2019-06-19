package DynamicPrograming;

public class MaxSubArraySum {

    public static int masSubSum(int[] nums){
        if(nums==null) return 0;

        int maxsum=Integer.MIN_VALUE,sum_tempt=0,max=nums[0];
        boolean flag = true;

        for(int i=0;i<nums.length;i++){
            if(sum_tempt+nums[i]>=0){
                sum_tempt += nums[i];
                flag = false;
            }
            else{
                sum_tempt = 0;
            }
            if(sum_tempt>maxsum)
                maxsum = sum_tempt;
            if(flag&&nums[i]>max)
                max = nums[i];
        }

        if(flag)
            maxsum = max;

        return maxsum;
    }

    public static void main(String[] args){
//        int[] n = {-2,1,-3,4,-1,2,1,-5,4};
        int[] n = {-5,-2,-3};
//        int[] n = {1,-1,-2};
        System.out.print(masSubSum(n));
    }
}
