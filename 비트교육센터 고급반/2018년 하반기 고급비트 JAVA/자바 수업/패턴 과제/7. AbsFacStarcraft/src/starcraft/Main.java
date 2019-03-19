package starcraft;


interface Weapon
{
	public void Use();
}//interface Weapon
class MachineGun implements Weapon
{

	@Override
	public void Use()
	{
		System.out.println("Marine Ready Complete");
	}
	
}//MachineGun
class FlameThrower implements Weapon
{

	@Override
	public void Use()
	{
		System.out.println("Firebat Ready Complete");
	}
	
}//FlameThrower
class Curer implements Weapon
{

	@Override
	public void Use()
	{
		System.out.println("Medic Ready Complete");
	}
	
}//Curer
//class Weapon

interface Clothes
{
	public void Suit();
}//interface Clothes
class Spacesuit implements Clothes
{
	@Override
	public void Suit()
	{
		System.out.println("You want a piece of me, boy!");	
	}
}//Spacesuit
class CBR implements Clothes
{
	@Override
	public void Suit()
	{
		System.out.println("Need a light?");	
	}
}
class NursingWear implements Clothes
{
	@Override
	public void Suit()
	{
		System.out.println("Prepped and ready!");	
	}
}//class Suit

interface AbstactFactory
{
	public Weapon weapon();
	public Clothes clothes();
}// AbstactFactory
class Marine implements AbstactFactory
{

	@Override
	public Weapon weapon()
	{
		return new MachineGun();
	}

	@Override
	public Clothes clothes()
	{
		return new Spacesuit();
	}
	
}//Marine ���� ��ȣ�� ����
class Firebat implements AbstactFactory
{

	@Override
	public Weapon weapon()
	{
		return new FlameThrower();
	}

	@Override
	public Clothes clothes()
	{
		return new CBR();
	}
	
}//Firebat ���� ��ȣ�� ����
class Medic implements AbstactFactory
{

	@Override
	public Weapon weapon()
	{
		return new Curer();
	}

	@Override
	public Clothes clothes()
	{
		return new NursingWear();
	}
	
}//Medic ���� ��ȣ�� ����

class BarrackM
{
	public static AbstactFactory marine()
	{
		return new Marine();
	}
}//BarrackM ���� ����
class BarrackF
{
	public static AbstactFactory firebat()
	{
		return new Firebat();
	}
}//BarrackF �ĺ� ����
class BarrackC
{
	public static AbstactFactory medic()
	{
		return new Medic();
	}
}//BarrackC �޵� ����

public class Main
{

	public static void main(String[] args)
	{
		//����
		AbstactFactory m = BarrackM.marine();
		Weapon mm = m.weapon();
		Clothes mmm = m.clothes();
		mm.Use();
		mmm.Suit();
		
		//���̾
		AbstactFactory f = BarrackF.firebat();
		Weapon ff = f.weapon();
		Clothes fff = f.clothes();
		ff.Use();
		fff.Suit();
		
		//�޵�
		AbstactFactory c = BarrackC.medic();
		Weapon cc = c.weapon();
		Clothes ccc = c.clothes();
		cc.Use();
		ccc.Suit();
	}

}//Main