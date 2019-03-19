package duck;

interface SoundBehavior
{
	void sound();
}

class Quack implements SoundBehavior
{
	@Override
	public void sound()
	{
		System.out.println("²Ð");
	}
}

class Squeaz implements SoundBehavior
{
	@Override
	public void sound()
	{
		System.out.println("Âï");
	}
}

class Mute implements SoundBehavior
{
	@Override
	public void sound() 
	{
		System.out.println("....?");
	}
}