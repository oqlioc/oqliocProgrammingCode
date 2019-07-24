package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

class Team {
	String name;
	int s, m, p;
	double sp;
	double sc1;
	double sc2;
	int count;

	public Team(String name, int count, int s, int m, int p, double sp, double sc1, double sc2) {
		this.name = name;
		this.count = count;
		this.s = s;
		this.m = m;
		this.p = p;
		this.sp = sp;
		this.sc1 = sc1;
	}

	public Team(String name) {
		this.name = name;
	}

	public void printScore() {
		System.out.printf(
				"[ 구단 = %3s, 경기수 = %3d, 승 = %3d, 무 = %3d, 패 = %3d, 승률 = %3.2f, 승차 = %3.2f, 1위와 승차 = %3.2f ]\n", name,
				count, s, m, p, sp, sc1, sc2);
	}

}

public class test3 {
	public static void main(String[] args) {
		LinkedList<Team> list = new LinkedList<>();
		Random random = new Random();

		list.add(new Team("롯데"));
		list.add(new Team("삼성"));
		list.add(new Team("한화"));
		list.add(new Team("엘지"));

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				for (int k = 0; k < 10; k++) {
					int num = random.nextInt(3);
					if (num == 0) {
						list.get(i).s = list.get(i).s + 1;
						list.get(j).p = list.get(j).p + 1;

						list.get(i).count = list.get(i).count + 1;
						list.get(j).count = list.get(j).count + 1;
					} else if (num == 1) {
						list.get(i).m = list.get(i).m + 1;
						list.get(j).m = list.get(j).m + 1;

						list.get(i).count = list.get(i).count + 1;
						list.get(j).count = list.get(j).count + 1;
					} else {
						list.get(i).p = list.get(i).p + 1;
						list.get(j).s = list.get(j).s + 1;

						list.get(i).count = list.get(i).count + 1;
						list.get(j).count = list.get(j).count + 1;
					}
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i).sp = (double) list.get(i).s / (list.get(i).s + list.get(i).p); // 승률
		}

		Collections.sort(list, new Comparator<Team>() {
			@Override
			public int compare(Team o1, Team o2) { // 퀵정렬
				if (o1.sp < o2.sp) {
					return +1; // 양수의 대명사를 +1이라고 한다
				} else {
					return -1;
				}
			}
		});

		for (int i = 0; i < list.size() - 1; i++) { // sc1
			for (int j = i + 1; j < list.size(); j++) {
				list.get(j).sc1 = list.get(i).s - list.get(j).s + (list.get(i).m - list.get(j).m) * 0.5;
				list.get(j).sc2 = list.get(0).s - list.get(j).s + (list.get(0).m - list.get(j).m) * 0.5;
			}
		}

		for (Team item : list) {
			item.printScore();
		}
	}
}
