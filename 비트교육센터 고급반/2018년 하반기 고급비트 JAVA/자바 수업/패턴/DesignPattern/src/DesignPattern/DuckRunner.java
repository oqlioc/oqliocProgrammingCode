package DesignPattern;
//=================================================//
interface FlyBehavior {
	void fly();
}
class canFly implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("ÈÎ ÈÎ");
	}
}
class cantfly implements FlyBehavior {
	@Override
	public void fly() {
	System.out.println("Á¶¿ë");	
	}
}
//=================================================//
interface SounBehavior{
	void sound();
}
class Quack implements SounBehavior {
	@Override
	public void sound() {
	System.out.println("…ˆ");	
	}
}
class squeaz implements SounBehavior {
	@Override
	public void sound() {
	System.out.println("Âï");	
	}
}
//=================================================//
abstract class Duck {
	FlyBehavior flyBehavior;
	SounBehavior sounBehavior;
	
	public abstract void name();
	
	public void fly() {
		flyBehavior.fly();
	}
	public void sound() {
		sounBehavior.sound();
	}
	public void swim() {
		System.out.println("Ã·º¡");
	}
}
//=================================================//
class MallarDuck extends Duck{
	
	public MallarDuck() {
		flyBehavior = new canFly();
		sounBehavior = new Quack();
	}
	
	@Override
	public void name() {
		System.out.println("Mallard duck");
	}

}
//=================================================//
class HouseDuck extends Duck{
	@Override
	public void name() {
		System.out.println("House duck");
	}
	@Override
	public void sound() {
	System.out.println("²Ð");
	}
	@Override
	public void fly() {
		System.out.println("ÈÎ");
	}
}
//=================================================//
class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new canFly();
		sounBehavior = new squeaz();
	}
	
	@Override
	public void name() {
		System.out.println("Rubberduck");
	}
}
//=================================================//
public class DuckRunner {
	public static void main(String[] args) {
		
		MallarDuck mallard = new MallarDuck();
		mallard.name();
		mallard.sound();
		mallard.swim();
		
		RubberDuck rubber = new RubberDuck();
		rubber.name();
		rubber.sound();
		rubber.swim();
		rubber.fly();
	}
}