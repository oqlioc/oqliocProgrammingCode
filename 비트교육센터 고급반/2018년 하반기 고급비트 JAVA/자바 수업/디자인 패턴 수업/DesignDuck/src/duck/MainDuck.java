package duck;

abstract class Duck
{
	FlyBehavior flyBehavior;
	SoundBehavior soundBehavior;
	
	public void fly()
	{
		flyBehavior.fly();
	}
	
	public void sound()
	{
		soundBehavior.sound();
	}
	
	public void swim() 
	{
		System.out.println("÷��");
	}
	
	public abstract void name();
}