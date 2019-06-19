import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allResult = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = nums.length - 1;
            int k = i + 1;
            int target = -nums[i];
            while (k < j) {
                if (nums[k] + nums[j] == target) {
                    List<Integer> oneResult = new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j]));
                    allResult.add(oneResult);
                    while (k < j && nums[k] == nums[k + 1]) k++;
                    while (k < j && nums[j] == nums[j - 1]) j--;
                    k++;
                    j--;
                } else if (nums[k] + nums[j] < target) {
                    k++;
                } else {
                    j--;
                }
            }
        }
        return allResult;
    }


    public static void main(String[] args) {
        /*
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(3);

        b.add(2);
        b.add(-1);
        b.add(0);

        l.add(a);
        l.add(b);

        System.out.println(l);

        System.out.println(checkOneResult(2, 11, 3, l));*/

        int[] nums = {-1, 0, 1, 2, 2, 0, 0, -1, -4};
//        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
//        Integer[] a = {1, 2, 3};
//        ArrayList<Integer> x = new ArrayList<Integer>(Arrays.asList(a));
//        System.out.println(x);
        /*
        -4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0

        -4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1
           -2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5
              1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0

        */
//        int[] nums = {0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(threeSum(nums));

    }
}