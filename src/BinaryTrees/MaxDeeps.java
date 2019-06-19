package BinaryTrees;

public class MaxDeeps {

    public static int maxDepth(TreeNode root){

        if(root==null) return 0;
        int L_depth,R_depth;
        L_depth = maxDepth(root.left);
        R_depth = maxDepth(root.right);

        return (L_depth>R_depth?L_depth:R_depth)+1;
    }

    public static void main(String[] args){
        TreeNode t = TreeNode.buildTreeByLine(
                "3 9 20 n n 15 7 31 25 n n n n 27 35 n n n n");
        System.out.print(t.preTravers());
        System.out.println();
        System.out.print(maxDepth(t));
    }
}
