package java20190722;

import java.util.Iterator;
import java.util.LinkedList;

class Ap {
    int n;
    String s;

    public Ap(int n, String s) {
        this.n = n;
        this.s = s;
    }

    void out() {
        System.out.println(n + " " + s);
    }

    @Override
    public String toString() {
        return "Ap [n  = " + n + ", s = " + s + "]";
    }

}

public class Link1 {

    public static void main(String[] args) {
        LinkedList<Ap> list = new LinkedList<>();

        System.out.println(list.size());

        list.add(new Ap(10, "호랑이"));

        Ap a1 = new Ap(20, "코끼리");
        list.add(a1);

        for (Ap item : list) {
            System.out.println(item.toString());
        }

        System.out.println("--------------------------------");

        for (int i = 0; i < 5; i++) {
            list.add(new Ap(i, "독수리" + i));
        }

        for (Ap item : list) {
            System.out.println(item.toString());
        }

        System.out.println("--------------------------------");

        list.get(3).out();

        list.set(2, new Ap(2, "맘모스"));

        System.out.println("--------------------------------");

        for (Ap item : list) {
            System.out.println(item.toString());
        }

        System.out.println("--------------------------------");

        list.remove(3);

        for (Ap item : list) {
            System.out.println(item.toString());
        }

        System.out.println("--------------------------------");

        for (int i = 0; i < 10; i++) {
            int a;
            a = (int) (Math.random() * 100);
            list.add(new Ap(a, "독수리" + a));
        }

        for (Ap item : list) {
            System.out.println(item.toString());
        }

        System.out.println("--------------------------------11");

        Iterator<Ap> iter = list.iterator();

        while (iter.hasNext()) {

            if (iter.next().n % 2 != 0) {
                iter.remove();
            }
        }

        for (Ap item : list) {
            System.out.println(item.toString());
        }

        System.out.println("--------------------------------22");

        System.out.println("sort");

        System.out.println("--------------------------------33");



    }
}