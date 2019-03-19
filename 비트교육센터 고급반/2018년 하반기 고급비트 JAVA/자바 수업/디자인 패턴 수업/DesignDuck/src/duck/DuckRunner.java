package duck;

public class DuckRunner
{
	public static void main(String[] args) 
	{
		MallardDuck mallard = new MallardDuck();
		mallard.name();
		mallard.sound();
		mallard.swim();
		mallard.fly();
		
		HouseDuck house = new HouseDuck();
		house.name();
		house.sound();
		house.swim();
		house.fly();
		
		RubberDuck rubber = new RubberDuck();
		rubber.name();
		rubber.sound();
		rubber.swim();
		rubber.fly();
	}
}
