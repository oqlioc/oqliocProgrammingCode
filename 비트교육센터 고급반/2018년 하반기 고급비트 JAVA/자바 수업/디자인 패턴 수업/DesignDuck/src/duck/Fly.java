package duck;

interface FlyBehavior
{
	void fly();
}

class canFly implements FlyBehavior
{
	@Override
	public void fly()
	{
		System.out.println("�� ��");
	}
}

class cantFly implements FlyBehavior
{
	@Override
	public void fly()
	{
		System.out.println("....?");
	}
}