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
		System.out.println("목욕");
	}

	@Override
	protected void Ride()
	{
		System.out.println("거미줄쏴서");
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
		System.out.println("세수");
	}

	@Override
	protected void Ride()
	{
		System.out.println("날아서");
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
