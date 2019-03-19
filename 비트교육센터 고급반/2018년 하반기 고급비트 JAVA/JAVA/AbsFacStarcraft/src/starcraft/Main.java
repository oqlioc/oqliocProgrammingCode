package starcraft;
// �پ��� ���� ��� ���� '��ü�� ����'�� �����ؾ� �� �� �����ϴ�. �� ������ ����Ͽ� ��Ȳ�� �˸��� ��ü�� ������ �� �ִ�.
// �߻� ���丮 ������ ���� ���� ������ ���� Ŭ������ Ư�� �׷����� ���� �ѹ��� ��ü�� �� �ֵ��� ���� ������ ����
// ���� ������� ������� �ϳ��� ū Ʋ�� ������ �� Ʋ ��ü�� �����ϴ°� �ƴ϶� ������� �ϳ��� ������ �� �ֵ��� �Ѵ�.
//
//
//

interface Weapon   // ���� ��ǰ�� �ϳ��� ������ �������̽��� ����
{
	public void Use();
}//interface Weapon
class MachineGun implements Weapon  // �� ���ֿ��� �´� ���� ����
{

	@Override
	public void Use()
	{
		System.out.println("Marine Ready Complete");
	}
	
}//MachineGun ��������
class FlameThrower implements Weapon
{
	@Override
	public void Use()
	{
		System.out.println("Firebat Ready Complete");
	}
	
}//FlameThrower �ĺ�����
class Curer implements Weapon
{
	@Override
	public void Use()
	{
		System.out.println("Medic Ready Complete");
	}
	
}//Curer �޵񹫱�
//class Weapon

interface Clothes    // ���� ��ǰ�� �ϳ��� Ŭ������ �������̽��� ����
{
	public void Suit();
}//interface Clothes
class Spacesuit implements Clothes    // ���ֿ� �´� Ŭ���� ����
{
	@Override
	public void Suit()
	{
		System.out.println("You want a piece of me, boy!");	
	}
}//Spacesuit ���� ��ȣ��
class CBR implements Clothes
{
	@Override
	public void Suit()
	{
		System.out.println("Need a light?");	
	}
}//CBR �ĺ� ��ȣ��
class NursingWear implements Clothes
{
	@Override
	public void Suit()
	{
		System.out.println("Prepped and ready!");	
	}
}//NursingWear �޵� ��ȣ��
//class Suit

interface AbstactFactory    // ���ֿ� ���� ��ǰ ���� , �������̽��� ����
{
	public Weapon weapon();
	public Clothes clothes();
}// AbstactFactory
class Marine implements AbstactFactory     // �����̶�� ���ֿ� ��ǰ ����
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
//���� Class

class BarrackM    // �跰�̶�� ������ ��������
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
/*
class Barrack
{
	public static AbstactFactory barrack()
	{
		switch(System.getProperty("os.name"))
		{
		case "M":
			//����
			AbstactFactory m = BarrackM.marine();
			Weapon mm = m.weapon();
			Clothes mmm = m.clothes();
			mm.Use();
			mmm.Suit();
		case "F":
			return new MacFac();
		case "C":
			
		}
		return null;
	}
}
*/
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