package test;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

class List {
	int value;
	int count;

	public List(int value, int count) {
		this.value = value;
		this.count = count;
	}

	public int getValue() {
		return value;
	}

	public int getCount() {
		return count;
	}
}

//Particle 프로그램. 누가 생성이되거나 누가 제거가되는 작업.
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<List> list = new LinkedList<>();

		int value = 0;
		Random random = new Random();

		while (true) {
			System.out.println("그만 할려면 99입력");

			if (sc.nextInt() == 99)
				break;

			// 갱신, 즉 필요없는걸 제거한다.
			// size만큼 본다.
			if (list.size() != 0) {
				for (int i = 10; i > 0; i--) {
					if (random.nextInt(2) == 0) {
						list.remove();
					}
				}
			} else {
				for (int i = 0; i < 10; i++) {
					list.add(new List(value, 0));
					value++;
				}
			}

			for (int i = 0; i < list.size(); i++) {
				list.get(i).count = list.get(i).count + 1;
			}

			// 생성
			// 위에서 제거된 만큼 재 생성
			if (list.size() != 10) {
				for (int i = list.size(); i < 10; i++) {
					list.add(new List(value, 0));
					value++;
				}
			}

			for (List item : list) {
				System.out.printf("" + "%2d" + " ", item.getValue());
			}
			System.out.println("");

			for (List item : list) {
				System.out.printf("" + "%2d" + " ", item.getCount());
			}
			System.out.println("");
			
			System.out.println("---------------------------------------");
		}
	}
}