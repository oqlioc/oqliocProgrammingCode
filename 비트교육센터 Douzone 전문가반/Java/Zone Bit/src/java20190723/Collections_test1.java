package java20190723;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

class A2 {

    int n1, n2;
    String s;

    public A2(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public void output() {
        System.out.println("N1 : " + n1 + " N2 : " + n2);
    }
}

public class Collections_test1 {
    public static void main(String[] args) {

        LinkedList<A2> list = new LinkedList<A2>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            list.add(new A2(random.nextInt(100), random.nextInt(100)));
        }

        for (A2 item : list) {
            item.output();
        }

        System.out.println("-------------------------------");

        Collections.sort(list, new Comparator<A2>() {
            @Override
            public int compare(A2 o1, A2 o2) { // 퀵정렬
                int R1 = o1.n1 * o1.n2;
                int R2 = o2.n2 * o2.n2;

                if (R1 > R2) {
                    return +1; // 양수의 대명사를 +1이라고 한다
                } else {
                    return -1;
                }
            }
        });

        for (A2 item : list) {
            item.output();
        }
    }
}