public class IncreasingTripLet {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 1, 34, 3, 1, 8, 5, 2, 2, 1};
//        int[] nums = {3, 3, 1, 8, 5, 2, 9, 1};
//        int[] nums = {1, 0, 0, 18, 0, 0, 100};
//        int[] nums = {5, 4, 3, 2, 1};
        int[] nums = {1,1,1,1,1,1};
//        int[] nums ={2,1,5,0,3};
//        int[] nums = {5, 5, 5, 4, 6, 3, 1, 2, 0, 3};
        IncreasingTripLet task = new IncreasingTripLet();
        System.out.println(task.increasingTriplet(nums));
    }
}
