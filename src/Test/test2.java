package Test;

public class test2 {

    interface kkl{
        void func();
    }

    static class MyEception extends Exception{
        private int detile;
        MyEception(int a ){
            detile = a;
        }
        public  String toString(){
            return "MyEception["+detile+"]";
        }
    }

    static void compute(int a)throws MyEception{
        System.out.println("Called compute("+a+").");
        if (a>10) throw new MyEception(a);
        System.out.println("Normal exit");
    }

    class people{}

    class student extends people implements kkl{
        @Override
        public void func() {

        }
    }


    public static void main(String[] args){
        try{
            compute(1);
            compute(20);
        }
        catch (MyEception e){
            System.out.println("Exception caught"+e);
        }
    }
}
