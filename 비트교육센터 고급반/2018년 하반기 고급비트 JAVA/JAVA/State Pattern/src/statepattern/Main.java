package statepattern;

//
// if~else 또는 switch~case 문을 이용하여 상태를 편하게 집어넣고 사용할 수 있다.
// 상태가 많아짐에 따라 무수한 분기문을 볼 수 있으며 다른 상태를 집어넣기 위해 수정해야 할 부분이 상당하다
// Strategy Pattern(전략 패턴)과 많이 유사하다. 전략 패턴의 경우 전략 변경에 일정함이 없지만, 스테이트 패턴의 경우 각 State간에 일정한 규칙을 가지고 변화한다
//State 객체는 하나만 존재해도 상관없다는 특성을 지니고 있다. 따라서 State 객체들은 싱글턴 패턴을 적용하여 구현하면 좀 더 효율적으로 코드를 개선할 수 있을 것이다.
//

interface ThanosAdv
{
	public void Behavior();
	public void GetStone();
}//상황을 인터페이스로 분리시킴. 각각에 맞는 상황들을 유연하게 관리할 수 있기 때문에 유지 보수에 효율적.


class Nidavellir implements ThanosAdv		// 각각의 상황들을  ThanosAdv 인터페이스에게 상속받는다.
{

	@Override
	public void Behavior()
	{
		System.out.println("니다벨리르로 가서 난쟁이들 학살");
	}

	@Override
	public void GetStone()
	{
		System.out.println("인피니티 건틀릿 장착");
	}
}

class PowerStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("블랙오더가 쑥대밭을 만들고 스톤 회수");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("파워 스톤을 인피니티 건틀릿에 장착");
	}
}
class SpaceStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("토르 고문 후 헐크랑 싸운 뒤 로키를 죽이고(?) 함선 부숨");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("스페이스 스톤을 인피니티 건틀릿에 장착");
	}
}
class RealityStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("콜렉터 찾아간뒤 스톤 습득 후 가오겔이랑 전투");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("리얼리티 스톤을 인피니티 건틀릿에 장착");
	}
}
class SoulStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("소울제단에서 가모라를 제물로 바침");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("소울 스톤을 인피니티 건틀릿에 장착");
	}
}
class TimeStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("어벤져스와 전투 후  아이언맨 죽이기 직전 스트레인지가 스톤을 넘김");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("타임 스톤을 인피니티 건틀릿에 장착");
	}
}
class MindStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("어벤져스와 전투 후  비전머리통 뽑음");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("마인드 스톤을 인피니티 건틀릿에 장착");
	}
}

class AllgetStone implements ThanosAdv
{
	@Override
	public void Behavior()
	{
		System.out.println("토르한테 명치맞고 도망 후 농사 지으러 감");
	}
	
	@Override
	public void GetStone()
	{
		System.out.println("인피니티 건틀릿 박살");
	}
}

class Thanos
{
	@SuppressWarnings("unused")
	private ThanosAdv adv;	//상태저장
	
	public Thanos(ThanosAdv adv)
	{
		this.adv = adv;		//초기화
	}
	
	public void Place(String s) // 새로운 상황이나 상태를 만들고 싶을때 마다 쉽게 추가할 수 있다.
	{
		switch (s)
		{
			case "Power":
				System.out.println("행성 : 노바제국");
				this.adv = new PowerStone();
				break;
			case "Space":
				System.out.println("행성 : 아스가르드의 우주함선");
				this.adv = new SpaceStone();
				break;
			case "Real":
				System.out.println("행성 : 노웨어");
				this.adv = new RealityStone();
				break;
			case "Soul":
				System.out.println("행성 : 보르미르");
				this.adv = new SoulStone();
				break;
			case "Time":
				System.out.println("행성 : 타이탄");
				this.adv = new TimeStone();
				break;
			case "Mind":
				System.out.println("행성 : 지구");
				this.adv = new MindStone();
				break;
			case "Rest":
				System.out.println("행성 : 다른 행성");
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
