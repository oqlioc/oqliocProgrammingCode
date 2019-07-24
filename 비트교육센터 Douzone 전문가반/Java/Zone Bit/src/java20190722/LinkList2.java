package java20190722;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LinkList2 {

    static void func1(AbstractList a) {

    }

    public static void main(String[] args) {
        AbstractList Llist1 = new LinkedList<>();
        LinkedList Llist2 = new LinkedList<>();
        ArrayList Alist3 = new ArrayList<>();

        func1(Llist1);
        func1(Llist2);
        // func1(Llist3);

        Llist1.add("1");
        Llist1.add("2");
        Llist1.add("3");

        System.out.println(Llist1);

        // ArrayList Alist1 = new ArrayList<>(Llist1);
        // ArrayList Alist2 = new ArrayList<>(Llist2);

        Queue queue = (Llist2);
    }
}