package DynamicPrograming;

public class RobStragy {

    public static int rob(int[] nums){
        if(nums==null) return 0;
        switch(nums.length){
            case(1): return nums[0];
            case(2): return Integer.max(nums[0],nums[1]);
            case(3): return Integer.max(nums[0]+nums[2],nums[1]);
        }
        int[] sum = new int[nums.length];

        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[0]+nums[2];

        for(int i=3;i<nums.length;i++){
            sum[i] = Integer.max(sum[i-3],sum[i-2])+nums[i];
        }

        return Integer.max(sum[nums.length-1],sum[nums.length-2]);
    }

    public static void main(String[] args){
//        int[] n = {2,7,9,3,1};
        int[] n = {1,2,3,1};
        System.out.print(rob(n));
    }
}
