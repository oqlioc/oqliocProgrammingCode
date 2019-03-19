package caffee;

//Decorator Pattern

abstract class Coffee
{
	String name = "None";

	public String getName() {
		return name;
	}
	public abstract Double getCost();
}

class Espresso extends Coffee
{
	public Espresso()
	{
		name = "Espresso";
	}
	
	@Override
	public Double getCost()
	{
		return 0.99;
	}
	
}

class DarkRoast extends Coffee
{
	public DarkRoast()
	{
		name = "DarkRoast";
	}
	
	@Override
	public Double getCost()
	{
		return 1.09;
	}
	
}

abstract class Ingredient extends Coffee
{
	@Override
	public abstract String getName();
}

class Mocha extends Ingredient
{
	Coffee myCoffee;
	
	public Mocha(Coffee myCoffee)
	{
		this.myCoffee = myCoffee;
	}
	@Override
	public Double getCost()
	{
		return myCoffee.getCost() + 0.5;
	}
	@Override
	public String getName()
	{
		return myCoffee.getName() + " +Mocha";
	}
	
}

class Whiping extends Ingredient
{
	Coffee myCoffee;
	
	public Whiping(Coffee myCoffee)
	{
		this.myCoffee = myCoffee;
	}
	@Override
	public Double getCost()
	{
		return myCoffee.getCost() + 0.2;
	}
	@Override
	public String getName()
	{
		return myCoffee.getName() + " +Whiping";
	}
	
}

public class Starbuks
{
	public static void main(String[] args)
	{
//		Coffee espresso = new Espresso();
//		Coffee darkroast = new DarkRoast();
		Coffee darkroast = new Mocha(new DarkRoast());
		Coffee espresso = new Whiping(new Espresso());
		Coffee dark = new DarkRoast();
		dark = new Mocha(dark);
		dark = new Whiping(dark);
		
		System.out.println(espresso.getName());
		System.out.println(espresso.getCost() + "$");
		
		System.out.println(darkroast.getName());
		System.out.println(darkroast.getCost() + "$");
		
		System.out.println(dark.getName());
		System.out.println(dark.getCost() + "$");
		
	}

}
