package AdapterPattern;

interface chicken {
	public void getMeat();

	public void getName();

	public int getWeight();
}

interface pigeon {
	public void getName();

	public int getWeight();
}

class KoreanChicken implements chicken {

	int weight;

	public KoreanChicken(int weight) {
		this.weight = weight;
	}

	@Override
	public void getMeat() {
		int gd = 0;

		switch (weight / 10) {
		case 3:
			gd = 3;
			break;
		case 4:
			gd = 4;
			break;
		case 5:
			gd = 5;
			break;
		case 6:
			gd = 6;
			break;
		case 7:
			gd = 7;
			break;
		default:
			break;
		}

		System.out.println("�� ���� " + gd + "ȣ ���Դϴ�.");
	}

	@Override
	public void getName() {
		System.out.println("������~~~��������");
	}

	@Override
	public int getWeight() {
		return weight;
	}

}

class Yongdusanougeon implements pigeon {
	int weight;

	public Yongdusanougeon(int weight) {
		this.weight = weight;
	}

	@Override
	public void getName() {
		System.out.println("�������� ....������");
	}

	@Override
	public int getWeight() {
		return weight;
	}
}

class ChickenFactory {
	public void makeMeat(chicken c) {
		c.getMeat();
		c.getName();
	}
}

class PGAdapter implements chicken {
	pigeon p;

	public PGAdapter(pigeon p) {
		this.p = p;
	}

	@Override
	public void getMeat() {
		int gd = 0;

		switch (p.getWeight() / 10) {
		case 3:
			gd = 3;
			break;
		case 4:
			gd = 4;
			break;
		case 5:
			gd = 5;
			break;
		case 6:
			gd = 6;
			break;
		case 7:
			gd = 7;
			break;
		default:
			break;
		}
		System.out.println("�� ���� " + gd + "ȣ ���Դϴ�.");
	}

	@Override
	public void getName() {
		p.getName();
	}

	@Override
	public int getWeight() {
		return p.getWeight();
	}

}

public class main {

	public static void main(String[] args) {

		ChickenFactory cf = new ChickenFactory();
		KoreanChicken k = new KoreanChicken(45);
		pigeon p = new Yongdusanougeon(55);
		PGAdapter pga = new PGAdapter(p);

		cf.makeMeat(k);

		cf.makeMeat(pga);
	}
}