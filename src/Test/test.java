package Test;

import cern.colt.function.DoubleDoubleFunction;
import cern.colt.function.DoubleFunction;

class Pow2 implements DoubleDoubleFunction {
    //平方函数类
    @Override
    public double apply(double x, double y) {
        return function(x,y);
    }
    double function(double x,double y){
        return Math.pow(x,y);
    }
}

class Pow implements DoubleFunction{
    private double n = 2.0;

    Pow(){ }
    Pow(double x){ n = x;}

    double function(double argument) { return Math.pow(argument,n); }

    void setN(double x){ this.n = x; }

    @Override
    public double apply(double argument) { return function(argument); }

}


public class test {

    static void foo(){
        System.out.println(Thread.currentThread().getName());

        Thread m = Thread.currentThread();

        Thread b = new Thread(){
            Object a;

            public void run(){
                Thread.currentThread().setName("Bthread");
                System.out.println(Thread.currentThread().getName());
                m.resume();
            }
        };

//        b.start();

        System.out.println("MainThrea will suspend");

        Thread.currentThread().suspend();
    }

    public static void main(String args[]){
      Thread.currentThread().setName("MainThrea");
      foo();
      System.out.println("Back to main");
    }
}
