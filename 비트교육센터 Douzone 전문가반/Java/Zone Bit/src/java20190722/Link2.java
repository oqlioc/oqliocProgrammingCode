package java20190722;

import java.util.LinkedList;

interface A {
    void func1();
}

class B implements A {
    @Override
    public void func1() {
        System.out.println("B Func1 Call.");
    }

    public void func2() {
        System.out.println("B Func2 Call.");
    }
}

class C implements A {
    @Override
    public void func1() {
        System.out.println("C Func1 Call.");
    }

    public void func3() {
        System.out.println("C Func3 Call.");
    }
}

class D {
    public void func1(LinkedList<A> list) {
        System.out.println("D Func1 Call.");

        for (A item : list) {
            item.func1();
        }

        System.out.println("----------------------------------");

        // 캐스팅하여 B의 func2 사용하기
        ((B) list.get(0)).func2();

        System.out.println("----------------------------------");

        // 객체 타입이 무엇인지 판별
        // 앞쪽은 판별하고자 하는 객체
        // 뒤쪽은 비교하고자 하는 객체
        for (A item : list) {
            if (item instanceof B) {
                B b = (B) item;
                b.func2();
            }

            if (item instanceof C) {
                C c = (C) item;
                c.func3();
            }
        }

        System.out.println("----------------------------------");

    }
}

public class Link2 {

    public static void main(String[] args) {
        LinkedList<A> list = new LinkedList<>();

        list.add(new B());
        list.add(new C());
        list.add(new B());
        list.add(new C());

        System.out.println("----------------------------------");

        D d = new D();
        d.func1(list);

    }
}
