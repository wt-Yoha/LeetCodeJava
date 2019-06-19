package BinaryTrees;

public class IsVaildBST {

    static class Tag{
        int max;
        int min;
        boolean isBST;
        Tag(int max,int min,boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }


    public static Tag infoOfBST(TreeNode t){
        Tag lable;
        if(t==null) return null;

        Tag lTag = infoOfBST(t.left);
        Tag rTag = infoOfBST(t.right);

        if(lTag==null&&rTag==null) {
            lable = new Tag(t.val, t.val, true);
        }
        else if(lTag==null){
            if(t.val<rTag.min&&rTag.isBST)
                rTag.min = t.val;
            else
                rTag.isBST = false;
            lable = rTag;
        }
        else if(rTag==null){
            if(t.val>lTag.max&&lTag.isBST)
                lTag.max = t.val;
            else
                lTag.isBST = false;
            lable = lTag;
        }
        else{
            if(lTag.isBST&&rTag.isBST&&t.val>lTag.max&&t.val<rTag.min)
                lable = new Tag(rTag.max,lTag.min,true);
            else{
                lTag.isBST = false;
                lable = lTag;
            }
        }
        return lable;
    }

    private static boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return infoOfBST(root).isBST;
    }

    private static boolean isValidBST2(TreeNode root){
        String[] dataString = root.orderTravers().split(" ");
        int cur=Integer.MIN_VALUE,k;

        for(String ds : dataString){
            k = Integer.parseInt(ds);
            if(k>cur)
                cur = k;
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        TreeNode t = TreeNode.buildTreeByLine(
                "5 3 8 2 4 6 9 1 n n n n 7 n n n n n n"
        );

//        TreeNode t = TreeNode.buildTreeByLine(
//                "1 2 3 n n 4 5 n n n n"
//        );

        System.out.print(t.preTravers());
        System.out.println();
        System.out.println(t.orderTravers());
        System.out.print(isValidBST2(t));

    }
}
