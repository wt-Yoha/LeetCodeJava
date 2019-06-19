package Lambda_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda {

    interface HeroChecker {
        public boolean test(Hero h);
//        public int func();
    }

    static class Hero implements Comparable<Hero>{

        String name;
        float hp;
        int damage;

        public Hero(){

        }

        public Hero(String name) {
            this.name =name;

        }

        //初始化name,hp,damage的构造方法
        public Hero(String name,float hp, int damage) {
            this.name =name;
            this.hp = hp;
            this.damage = damage;
        }

        public boolean func(){
            System.out.println("lalal.");
            return this.hp>100 && this.damage<50;
//            return 0;
        }

        @Override
        public int compareTo(Hero anotherHero) {
            if(damage<anotherHero.damage)
                return 1;
            else
                return -1;
        }

        @Override
        public String toString() {
            return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
        }

    }

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
//        filter(heros, h->h.hp>100 && h.damage<50);
//        filter(heros, Hero::func);

        heros
                .stream()
                .filter(h -> h.hp > 100 && h.damage < 50)
                .forEach(h -> System.out.println(h.name));
    }

//    private static void filter(List<Hero> heros,HeroChecker checker) {
//        for (Hero hero : heros) {
//            if(checker.test(hero))
//                System.out.print(hero);
//        }
//    }
}
