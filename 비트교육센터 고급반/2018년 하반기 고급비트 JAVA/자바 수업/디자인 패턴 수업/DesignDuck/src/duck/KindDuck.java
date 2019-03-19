package duck;

class MallardDuck extends Duck
{

	public MallardDuck()
	{
		flyBehavior = new canFly();
		soundBehavior = new Quack();
	}
	@Override
	public void name()
	{
		System.out.println("Mallard Duck");
	}

}

class HouseDuck extends Duck
{

	public HouseDuck() 
	{
		flyBehavior = new canFly();
		soundBehavior = new Quack();
	}
	
	@Override
	public void name()
	{
		System.out.println("House Duck");
	}

}

class RubberDuck extends Duck
{
	
	public RubberDuck()
	{
		flyBehavior = new cantFly();
		soundBehavior = new Squeaz();
	}
	@Override
	public void name()
	{
		System.out.println("Rubber Duck");
	}
	
}