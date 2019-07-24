package test;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class test1 {
   public static void main(String[] args) {
      int cnt = 0;
      
      boolean flag;

      LinkedList<Integer> list = new LinkedList<>();
      LinkedList<Integer> list_cnt = new LinkedList<>();
      Scanner sc = new Scanner(System.in);

      while (sc.nextLine().equals("99") != true) {
         int temp_size = list.size();
         int rm_cnt = 0;
         int temp;
         
         for (int i = 0; i < temp_size; i++) {
            flag = new Random().nextBoolean();
            
            if (flag == true) {
               list.remove(i - rm_cnt);
               list_cnt.remove(i - rm_cnt);
               rm_cnt++;
            } else {
               temp = list_cnt.get(i - rm_cnt);
               list_cnt.set(i - rm_cnt, ++temp);
            }
         }

         temp_size = list.size();
         
         for (int i = 0; i < 10 - temp_size; i++) {
            list.add(cnt);
            list_cnt.add(0);
            cnt++;
         }

         for (Integer item : list) {
            System.out.printf("%5d", item);
         } System.out.println();
         
         for (Integer item : list_cnt) {
            System.out.printf("%5d", item);
         } System.out.println();
      }
   }
}
