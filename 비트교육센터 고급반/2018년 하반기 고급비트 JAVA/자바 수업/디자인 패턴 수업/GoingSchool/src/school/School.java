package school;

abstract class SschoolStudent
{
	public void Sschool()
	{
		Wake();
		Wash();
		Ride();
		if(!Tardy())
		{
			Chek();
		}
	}
	
	
	
	protected void Wake()
	{
		System.out.println("Wake.....");
	}
	protected void Chek()
	{
		System.out.println("Hello Chek");
	}
	protected boolean Tardy()
	{
		return false;
	}
	abstract protected void Wash();
	abstract protected void Ride();
}

class SpiderMan extends SschoolStudent
{
	boolean Tardy;
	
	public SpiderMan(boolean Tardy)
	{
		this.Tardy = Tardy;
	}
	
	@Override
	protected void Wash()
	{
		System.out.println("���");
	}

	@Override
	protected void Ride()
	{
		System.out.println("�Ź��ٽ���");
	}
	
	protected boolean Tardy()
	{
		return tardy;
	}
}

class SuperMan extends SschoolStudent
{
	@Override
	protected void Wash()
	{
		System.out.println("����");
	}

	@Override
	protected void Ride()
	{
		System.out.println("���Ƽ�");
	}
}

public class School
{

	public static void main(String[] args)
	{
		SschoolStudent A = new SpiderMan();
		A.Sschool();
		A = new SuperMan();
		A.Sschool();
	}

}
