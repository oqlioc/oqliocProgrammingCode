package statepattern;

//
// if~else �Ǵ� switch~case ���� �̿��Ͽ� ���¸� ���ϰ� ����ְ� ����� �� �ִ�.
// ���°� �������� ���� ������ �б⹮�� �� �� ������ �ٸ� ���¸� ����ֱ� ���� �����ؾ� �� �κ��� ����ϴ�
// Strategy Pattern(���� ����)�� ���� �����ϴ�. ���� ������ ��� ���� ���濡 �������� ������, ������Ʈ ������ ��� �� State���� ������ ��Ģ�� ������ ��ȭ�Ѵ�
//State ��ü�� �ϳ��� �����ص� ������ٴ� Ư���� ���ϰ� �ִ�. ���� State ��ü���� �̱��� ������ �����Ͽ� �����ϸ� �� �� ȿ�������� �ڵ带 ������ �� ���� ���̴�.
//

interface ThanosAdv
{
	public void Behavior();
	public void GetStone();
}//��Ȳ�� �������̽��� �и���Ŵ. ������ �´� ��Ȳ���� �����ϰ� ������ �� �ֱ� ������ ���� ������ ȿ����.


class Nidavellir implements ThanosAdv		// ������ ��Ȳ����  ThanosAdv �������̽����� ��ӹ޴´�.
{

	@Override
	public void Behavior()
	{
		System.out.println("�ϴٺ������� ���� �����̵� �л�");
	}

	@Override
	public void GetStone()
	{
		System.out.println("���Ǵ�Ƽ ��Ʋ�� ����");
	}
}

class PowerStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("�������� ������� ����� ���� ȸ��");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("�Ŀ� ������ ���Ǵ�Ƽ ��Ʋ���� ����");
	}
}
class SpaceStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("�丣 �� �� ��ũ�� �ο� �� ��Ű�� ���̰�(?) �Լ� �μ�");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("�����̽� ������ ���Ǵ�Ƽ ��Ʋ���� ����");
	}
}
class RealityStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("�ݷ��� ã�ư��� ���� ���� �� �������̶� ����");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("����Ƽ ������ ���Ǵ�Ƽ ��Ʋ���� ����");
	}
}
class SoulStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("�ҿ����ܿ��� ����� ������ ��ħ");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("�ҿ� ������ ���Ǵ�Ƽ ��Ʋ���� ����");
	}
}
class TimeStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("������� ���� ��  ���̾�� ���̱� ���� ��Ʈ�������� ������ �ѱ�");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("Ÿ�� ������ ���Ǵ�Ƽ ��Ʋ���� ����");
	}
}
class MindStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("������� ���� ��  �����Ӹ��� ����");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("���ε� ������ ���Ǵ�Ƽ ��Ʋ���� ����");
	}
}

class AllgetStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("�丣���� ��ġ�°� ���� �� ��� ������ ��");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("���Ǵ�Ƽ ��Ʋ�� �ڻ�");
	}
}

class Thanos
{
	@SuppressWarnings("unused")
	private ThanosAdv adv;	//��������
	
	public Thanos(ThanosAdv adv)
	{
		this.adv = adv;		//�ʱ�ȭ
	}
	
	public void Place(String s) // ���ο� ��Ȳ�̳� ���¸� ����� ������ ���� ���� �߰��� �� �ִ�.
	{
		switch (s)
		{
			case "Power":
				System.out.println("�༺ : �������");
				this.adv = new PowerStone();
				break;
			case "Space":
				System.out.println("�༺ : �ƽ��������� �����Լ�");
				this.adv = new SpaceStone();
				break;
			case "Real":
				System.out.println("�༺ : �����");
				this.adv = new RealityStone();
				break;
			case "Soul":
				System.out.println("�༺ : �����̸�");
				this.adv = new SoulStone();
				break;
			case "Time":
				System.out.println("�༺ : Ÿ��ź");
				this.adv = new TimeStone();
				break;
			case "Mind":
				System.out.println("�༺ : ����");
				this.adv = new MindStone();
				break;
			case "Rest":
				System.out.println("�༺ : �ٸ� �༺");
				this.adv = new AllgetStone();
				break;
			default:
				break;
		}
	}
	
	public void Behavior()
	{
		adv.Behavior();
	}
	
	public void GetStone()
	{
		adv.GetStone();
	}
}

public class Main
{

	public static void main(String[] args)
	{
		Thanos thanos = new Thanos(new Nidavellir());
		thanos.Behavior();
		thanos.GetStone();
		
		thanos.Place("Power");
		thanos.Behavior();
		thanos.GetStone();

		thanos.Place("Space");
		thanos.Behavior();
		thanos.GetStone();

		thanos.Place("Real");
		thanos.Behavior();
		thanos.GetStone();

		thanos.Place("Soul");
		thanos.Behavior();
		thanos.GetStone();

		thanos.Place("Time");
		thanos.Behavior();
		thanos.GetStone();

		thanos.Place("Mind");
		thanos.Behavior();
		thanos.GetStone();

		thanos.Place("Rest");
		thanos.Behavior();
		thanos.GetStone();
	}
}
