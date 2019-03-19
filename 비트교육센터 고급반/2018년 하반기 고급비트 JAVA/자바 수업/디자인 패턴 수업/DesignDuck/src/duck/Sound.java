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
		System.out.println("��");
	}
}

class Squeaz implements SoundBehavior
{
	@Override
	public void sound()
	{
		System.out.println("��");
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