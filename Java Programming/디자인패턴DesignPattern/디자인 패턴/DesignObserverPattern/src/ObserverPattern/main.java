package ObserverPattern;

import java.util.ArrayList;
import java.util.Random;

interface Fan {
	public void hear(String s);
}

interface Talent {
	public void addFan(Fan o);

	public void deleteFan(Fan o);

	public void speak();

}

class Singer implements Talent {

	private ArrayList<Fan> FanList;

	public Singer() {
		FanList = new ArrayList<Fan>();
	}

	@Override
	public void addFan(Fan o) {
		FanList.add(o);
	}

	@Override
	public void deleteFan(Fan o) {
		int idx = FanList.indexOf(o);
		FanList.remove(idx);
	}

	@Override
	public void speak() {
		String[] m = { "����ؿ� �ҿ�����~~", "������� ������~~" };
		Random r = new Random();
		int idx = r.nextInt(m.length);
		for (int i = 0; i < FanList.size(); i++) {
			Fan o = FanList.get(i);
			o.hear(m[idx]);
		}
	}
}

class SingerFan implements Fan {
	private String name;

	public SingerFan(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void hear(String s) {
		System.out.println(name + "�� " + s + "�� ������ϴ�.");
	}
}

public class main {

	public static void main(String[] args) {

		Singer ����� = new Singer();
		SingerFan a = new SingerFan("���Ǽ�");
		SingerFan b = new SingerFan("ȫ��ȣ");
		SingerFan c = new SingerFan("������");
		SingerFan d = new SingerFan("����ȣ");
		SingerFan e = new SingerFan("�̼�ȭ");
		SingerFan f = new SingerFan("��̿�");
		
		�����.addFan(a);
		�����.addFan(b);
		�����.addFan(c);
		�����.speak();
		System.out.println("----------------------------------------");
		�����.addFan(d);
		�����.addFan(e);
		�����.speak();
		System.out.println("----------------------------------------");
		�����.addFan(f);
		�����.speak();
	}
}
