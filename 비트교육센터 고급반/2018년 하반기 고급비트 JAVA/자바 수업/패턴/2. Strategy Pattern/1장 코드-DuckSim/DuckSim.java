interface FlyBehavior {
	public void fly();
}

interface SoundBehavior{
	public void sound();
}

class CanFly implements FlyBehavior{
	@Override
	public void fly() {
		System.out.println("훨 훨");
	}	
}

class NoCanFly implements FlyBehavior{
	@Override
	public void fly() {
		System.out.println("...");
	}	
}

class CanSound implements SoundBehavior{
	@Override
	public void sound() {
		System.out.println("꿱");
	}	
}

class SqueakSound implements SoundBehavior{

	@Override
	public void sound() {
		System.out.println("찍");
	}	
}

class NoCanSound implements SoundBehavior{
	@Override
	public void sound() {
		System.out.println("...");
	}
}

class MetalSound implements SoundBehavior{
	@Override
	public void sound() {
		System.out.println("깽!");
	}
	
}
abstract class Duck{
	FlyBehavior flyBehavior;
	SoundBehavior soundBehavior;
	
	abstract public void name();
	public void fly() {
		flyBehavior.fly();
	}
	public void sound() {
		soundBehavior.sound();
	}
	public void swim() {
		System.out.println("참방참방");
	}

}
class MallardDuck extends Duck{

	public MallardDuck() {
		flyBehavior = new CanFly();
		soundBehavior = new CanSound();
	}
	
	@Override
	public void name() {
		System.out.println("MallardDuck!");
	}
	
}
class HomeDuck extends Duck {

	public HomeDuck() {
		flyBehavior = new CanFly();
		soundBehavior = new CanSound();
	}
	@Override
	public void name() {
		System.out.println("HomeDuck!");
	}
	
}

class RubberDuck extends Duck{

	public RubberDuck() {
		flyBehavior = new NoCanFly();
		soundBehavior = new SqueakSound();
	}
	@Override
	public void name() {
		System.out.println("RubberDuck!");
	}

	
}

class WoodDuck extends Duck{

	public WoodDuck() {
		flyBehavior = new NoCanFly();
		soundBehavior = new NoCanSound();
	}
	@Override
	public void name() {
		System.out.println("WoodenDuck!");
		
	}
	
}

class MetalDuck extends Duck {
	public MetalDuck() {
		flyBehavior = new NoCanFly();
		soundBehavior = new MetalSound();
	}
	@Override
	public void name() {
		System.out.println("MetalDuck!");
	}
	
}
public class DuckSim {
	public static void main(String[] args) {
		
		MallardDuck md = new MallardDuck();
		md.name(); 
		md.sound(); 
		md.swim(); 
		md.fly();

		HomeDuck hd = new HomeDuck();
		hd.name(); 
		hd.sound(); 
		hd.swim(); 
		hd.fly(); 

		RubberDuck rd = new RubberDuck();
		rd.name(); 
		rd.sound(); 
		rd.swim(); 
		rd.fly(); 

		WoodDuck wd = new WoodDuck();
		wd.name(); 
		wd.sound(); 
		wd.swim(); 
		wd.fly(); 

		MetalDuck mdd = new MetalDuck();
		mdd.name(); 
		mdd.sound(); 
		mdd.swim(); 
		mdd.fly(); 
	}
}

