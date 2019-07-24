package java20190722;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Spliterator;

public class LinkList1 {

    public static void main(String[] args) {
        LinkedList<Shape> list = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Shape("Circle" + i, i));
        }

        Spliterator<Shape> split = list.spliterator();

        ArrayList<Spliterator<Shape>> arr = new ArrayList<>();
        
        arr.add(split);

        int arrCount = 0;

        while (true) {
            arrCount++;
            arr.add(arrCount, arr.get(0).trySplit());

            if (arr.get(0).estimateSize() == 0) {
                break;
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).estimateSize());
        }

        int totalSize = arr.size();
        int halfsize = totalSize / 2;

        new Thread(new Runnable(){
        
            @Override
            public void run() {
                for (int i = 0; i < halfsize; i++) {
                    while (arr.get(i).tryAdvance((value) -> printDetaile(value)));
                    }
                }
            }
        ).start();

        new Thread(() -> {
            for (int i = halfsize; i < totalSize; i++) {
                while (arr.get(i).tryAdvance((value) -> printDetaile(value)));
            }
        }).start();
        

        // split.tryAdvance((value) -> printDetaile(value));

        // while (split.tryAdvance((value) -> printDetaile(value)));
        

        // for (Shape item : list) {
        //     printDetaile(item);
        // }
    }

    static void printDetaile(Shape s){
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("Name : " + s.name);
        System.out.println("Size : " + s.size);
    }
}

class Shape{
    String name;
    int size;

    public Shape(String name, int size) {
        this.name = name;
        this.size = size;
    }

}