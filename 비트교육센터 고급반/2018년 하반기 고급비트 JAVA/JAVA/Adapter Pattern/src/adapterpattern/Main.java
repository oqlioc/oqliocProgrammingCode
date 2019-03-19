package adapterpattern;

interface Chicken
{
	public void getMeat();
	public void getName();
	public int getWeight();
}

interface Pigeon 
{
	public void getName();
	public int getWeight();
}

class KoreanChicken implements Chicken
{
	int weight;
	
	public KoreanChicken(int weight) 
	{
		this.weight = weight;
	}
	
	@Override
	public void getMeat()
	{
		int gd = 0;
		
		switch(weight/10)
		{
			case 3: gd = 3;
			break;
			case 4: gd = 4;
			break;
			case 5: gd = 5;
			break;
			case 6: gd = 6;
			break;
			case 7: gd = 7;
			break;
		}
		System.out.println("�� ���� " + gd +"ȣ ���Դϴ�.");
	}

	@Override
	public void getName()
	{
		System.out.println("�������~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public int getWeight()
	{
		
		return weight;
	}
	
}

class YongdusanPigeon implements Pigeon
{

	int weight;
	
	public YongdusanPigeon(int weight) 
	{
		this.weight = weight;
	}
	
	@Override
	public void getName()
	{
		System.out.println("������������");
		
	}

	@Override
	public int getWeight()
	{
		return weight;
	}
	
}

class ChickenFactory
{
	public void makeMeat(Chicken c)
	{
		c.getMeat();
		c.getName();
	}
}

class PGAdapter implements Chicken
{
	
	Pigeon p;
	
	public PGAdapter(Pigeon p)
	{
		this.p = p;
	}

	@Override
	public void getMeat() 
	{
		int gd = 0;
		
		switch(p.getWeight()/10)
		{
			case 3: gd = 3;
			break;
			case 4: gd = 4;
			break;
			case 5: gd = 5;
			break;
			case 6: gd = 6;
			break;
			case 7: gd = 7;
			break;
		}
		System.out.println("�� ���� " + gd +"ȣ ���Դϴ�.");
	}

	@Override
	public void getName() 
	{
		p.getName();
	}

	@Override
	public int getWeight() 
	{
		return p.getWeight();
	}
	
}

public class Main
{

	public static void main(String[] args)
	{
		ChickenFactory cf = new ChickenFactory();
		KoreanChicken k = new KoreanChicken(45);
		
		Pigeon p = new YongdusanPigeon(55);
		PGAdapter pga = new PGAdapter(p);
		
		cf.makeMeat(k);
		cf.makeMeat(pga);
	}

}
