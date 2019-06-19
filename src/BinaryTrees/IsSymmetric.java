package BinaryTrees;

public class IsSymmetric {

    private static boolean isSymmetric(TreeNode root){
        return isSymmetric(root,root);
    }

    private static boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;
        if(left.val!=right.val)
            return false;
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }

    public static void main(String[] args){
//        TreeNode t = TreeNode.buildTreeByLine(
//                "1 2 2 3 4 4 3 n n n n n n n n"
//        );

        TreeNode t = TreeNode.buildTreeByLine(
                "1 2 2 n 3 3 n n n n n"
        );


        System.out.print(t.orderTravers());
        System.out.println();
        System.out.print(isSymmetric(t));
    }
}
