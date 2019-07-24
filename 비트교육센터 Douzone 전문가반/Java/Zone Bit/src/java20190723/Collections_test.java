package java20190723;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

class A1 {

    int n;
    String s;
    
    public A1(int n, String s) {
		super();
		this.n = n;
		this.s = s;
	}
	public void output() {
        System.out.println("N : " + n + " S : " + s);
    }
}

public class Collections_test {
    public static void main(String[] args) {

        LinkedList<A1> list = new LinkedList<A1>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            list.add(new A1(random.nextInt(100), "호랑이" + i));
        }

        for (A1 item : list) {
            item.output();
        }

        System.out.println("-------------------------------");
        // 예제 1번
        // static 이다
        // Collections.sort(list, new Comparator<A>() {
        // @Override
        // public int compare(A1 o1, A1 o2) { // 퀵정렬
        // if (o1.n > o2.n) {
        // return +1; // 양수의 대명사를 +1이라고 한다
        // }else{
        // return -1;
        // }
        // }
        // });

        // 예제 2번
        // 삼항연산
        // Collections.sort(list, new Comparator<A>() {
        // @Override
        // public int compare(A1 o1, A1 o2) { // 퀵정렬
        // return o1.n > o2.n ? +1 : -1; // 1번의 삼항연산
        // }
        // });

        // 예제 3번
        // Collections.sort(list, new Comparator<A>() {
        // @Override
        // public int compare(A1 o1, A1 o2) { // 퀵정렬
        // return o1.n - o2.n; // 결과 값 기준을 양수 음수
        // }
        // });

        // 예제 4번
        // 람다식
        // Collections.sort(list, (A1 o1, A1 o2) -> {return o1.n - o2.n;}); // 람다식

        // 예제 5번
        // 람다식
        Collections.sort(list, (A1 o1, A1 o2) -> o1.n - o2.n); // 람다식

        for (A1 item : list) {
            item.output();
        }
    }
}