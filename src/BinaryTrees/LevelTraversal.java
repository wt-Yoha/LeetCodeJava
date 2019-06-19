package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class LevelTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root){
        Queue q = new Queue();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        TreeNode newline,p;

        q.add(root);
        newline = root;

        while(!q.isEmpty()){
            p = (TreeNode)q.delet();
            if(p==newline){
                l = new ArrayList<>();
                ans.add(l);
                newline = null;
            }
            l.add(p.val);
            if(p.left!=null){
                q.add(p.left);
                if(newline==null) newline = p.left;
            }
            if(p.right!=null){
                q.add(p.right);
                if(newline==null) newline = p.right;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        TreeNode t = TreeNode.buildTreeByLine(
                "1 2 3 n n 4 5 n 7 8 9"
        );

        List<List<Integer>> L;

        System.out.print(t.orderTravers());
        System.out.println();

        L = levelOrder(t);

        for(List<Integer> line : L){
            System.out.println(line.toString());
        }

    }
}
