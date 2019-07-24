package java20190719;

import java.util.LinkedList;

public class LinkList {

    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<String>();

        list1.add("0"); // 리스트에 추가한다
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        list1.add("9");

        System.out.println("list1 1번 ----> " + list1);

        LinkedList<String> list2 = new LinkedList<String>();
        list2 = (LinkedList<String>) list1.clone(); // 복사

        System.out.println("list2 1번 ----> " + list2);

        System.out.println("list2 2번 ----> " + list2.peek() + " -- " + list2.peekLast());

        System.out.println("-------------------------------------------------------------");  // 

        list2.remove();
        System.out.println("list2 3번 ----> " + list2);

        System.out.println("list2 4번 ----> " + list2.isEmpty());
        System.out.println("list2 5번 ----> " + list2);

        System.out.println("list2 6번 ----> " + list2.peek());
        System.out.println("list2 7번 ----> " + list2);

        System.out.println("list2 6번 ----> " + list2.poll());
        System.out.println("list2 7번 ----> " + list2);

        // list2.clear();
        // System.out.println("list2 8번 ----> " + list2);

        System.out.println("-------------------------------------------------------------");  // 

        System.out.println("list1 size()----> " + list1.size());
        System.out.println("list1 toArray().length----> " + list1.toArray().length);

        System.out.println("-------------------------------------------------------------");  // 

        String[] arr = list1.toArray(new String[list1.size()]);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }   System.out.println();
        
    }
}