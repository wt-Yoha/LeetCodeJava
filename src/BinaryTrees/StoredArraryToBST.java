package BinaryTrees;

public class StoredArraryToBST {

    public static TreeNode stroredArraryToBST(int[] nums){
        return stroredArraryToBST(nums,0,nums.length-1);
    }

    public static TreeNode stroredArraryToBST(int[] nums,int l,int h) {
        if(l>h||nums==null) return null;
        int mid = (h-l)/2+l;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = stroredArraryToBST(nums,l,mid-1);
        t.right = stroredArraryToBST(nums,mid+1,h);
        return t;
    }

    public static void main(String[] args){
        int[] nums = {-10,-3, 0, 5, 9};
        TreeNode t = stroredArraryToBST(nums);

        System.out.println(t.preTravers());
        System.out.println(t.orderTravers());
    }
}
