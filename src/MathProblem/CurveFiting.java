package MathProblem;

import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;

import java.util.ArrayList;

public class CurveFiting {

    public static Double[] curFit(double[] Xi,double[] Yi,int N){
        int len = Xi.length;
        String[] tempt;
        Double[] ans_return = new Double[N];
        ArrayList<Double> ans_tempt = new ArrayList<>();
        DoubleMatrix2D A = new DenseDoubleMatrix2D(len,N);
        DoubleMatrix2D B = new DenseDoubleMatrix2D(len,1);
        DoubleMatrix2D ans;
        Algebra f = new Algebra();

        for(int i=0;i<len;i++){
            B.set(i,0,Yi[i]);
            for(int j=0;j<N;j++){
                A.set(i,j,Math.pow(Xi[i],j*1.0));
            }
        }//Set the original matirx

        DoubleMatrix2D A_t = A.viewDice();
        DoubleMatrix2D A_t_A = f.mult(A_t,A);
        DoubleMatrix2D A_t_B = f.mult(A_t,B);

        ans = f.solve(A_t_A,A_t_B);

        tempt = ans.toString().split("\n");

        for(String i : tempt){
            try{
                ans_tempt.add(Double.parseDouble(i));
            }
            catch(Exception e){
                continue;
            }
        }
        ans_tempt.toArray(ans_return);
        return ans_return;
    }


    public static double[] sin(double[] Xi){
        double[] Yi = new double[Xi.length];
        int k=0;
        for(double x : Xi){
            Yi[k++] = 1+2*x+3*Math.pow(x,2.0)+Math.random();
        }
        return Yi;
    }


    public static void main(String[] args){
        int N = 3;
        double[] Xi = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        double[] Yi = sin(Xi);
        Double[] ans = curFit(Xi,Yi,N);

        System.out.println("The fitting poly fuction is:");
        for(int i=0;i<N;i++){
            if(Math.abs(ans[i])>0.00001) {
                if (i == 0)
                    System.out.format("%.2f", ans[i]);
                else if (i == 1)
                    System.out.format("+%.2fX", ans[i]);
                else
                    System.out.format("+%.2fX^%d", ans[i], i);
            }
        }

    }
}
