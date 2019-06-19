package Test;
/*
   测试反射机制
   getDeclaedconstructor 取出所有的构造器
   getConstructor 仅得到 public 标识的构造器
   getMehod 和 getDelaredMethod 类似
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class No_{
    abstract void func();
}

class No_1 extends No_{
    void func(){
        System.out.println("This is in No.1");
    }
}

class No_2 extends No_{
    @Override
    void func() {
        System.out.println("This is in No.2");
    }
}


public class Test_Reflect {
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args){
        StringBuilder s = new StringBuilder("No_0");
//        No_ n;
        for(int i=1;i<3;i++)
            try {
                s.setCharAt(s.length() - 1, (char) ('0' + i));
                Class cl = Class.forName("Test." + s.toString());
                Method m = cl.getDeclaredMethod("func");
//                n = (No_) cl.getConstructor().newInstance();
//                n.func();
                Constructor c = cl.getDeclaredConstructor();
                Object se = c.newInstance();
                m.invoke(se);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
    }
}
