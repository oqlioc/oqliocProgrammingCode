package starcraft;
// 다양한 구성 요소 별로 '객체의 집합'을 생성해야 할 때 유용하다. 이 패턴을 사용하여 상황에 알맞은 객체를 생성할 수 있다.
// 추상 팩토리 패턴은 많은 수의 연관된 서브 클래스를 특정 그룹으로 묶어 한번에 교체할 수 있도록 만든 디자인 패턴
// 많은 구성요소 만들어진 하나의 큰 틀을 수정할 때 틀 전체를 수정하는게 아니라 구성요소 하나식 수정할 수 있도록 한다.
//
//
//

interface Weapon   // 유닛 부품중 하나인 웨폰을 인터페이스로 생성
{
	public void Use();
}//interface Weapon
class MachineGun implements Weapon  // 각 유닛에게 맞는 무기 생성
{

	@Override
	public void Use()
	{
		System.out.println("Marine Ready Complete");
	}
	
}//MachineGun 마린무기
class FlameThrower implements Weapon
{
	@Override
	public void Use()
	{
		System.out.println("Firebat Ready Complete");
	}
	
}//FlameThrower 파벳무기
class Curer implements Weapon
{
	@Override
	public void Use()
	{
		System.out.println("Medic Ready Complete");
	}
	
}//Curer 메딕무기
//class Weapon

interface Clothes    // 유닛 부품중 하나인 클로즈을 인터페이스로 생성
{
	public void Suit();
}//interface Clothes
class Spacesuit implements Clothes    // 유닛에 맞는 클로즈 생성
{
	@Override
	public void Suit()
	{
		System.out.println("You want a piece of me, boy!");	
	}
}//Spacesuit 마린 보호구
class CBR implements Clothes
{
	@Override
	public void Suit()
	{
		System.out.println("Need a light?");	
	}
}//CBR 파벳 보호구
class NursingWear implements Clothes
{
	@Override
	public void Suit()
	{
		System.out.println("Prepped and ready!");	
	}
}//NursingWear 메딕 보호구
//class Suit

interface AbstactFactory    // 유닛에 넣을 부품 정리 , 인터페이스로 생성
{
	public Weapon weapon();
	public Clothes clothes();
}// AbstactFactory
class Marine implements AbstactFactory     // 마린이라는 유닛에 부품 장착
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
	
}//Marine 무기 보호구 장착
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
	
}//Firebat 무기 보호구 장착
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
	
}//Medic 무기 보호구 장착
//유닛 Class

class BarrackM    // 배럭이라는 곳에서 마린생성
{
	public static AbstactFactory marine()
	{
		return new Marine();
	}
}//BarrackM 마린 생산
class BarrackF
{
	public static AbstactFactory firebat()
	{
		return new Firebat();
	}
}//BarrackF 파벳 생산
class BarrackC
{
	public static AbstactFactory medic()
	{
		return new Medic();
	}
}//BarrackC 메딕 생산
/*
class Barrack
{
	public static AbstactFactory barrack()
	{
		switch(System.getProperty("os.name"))
		{
		case "M":
			//마린
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
		//마린
		AbstactFactory m = BarrackM.marine();
		Weapon mm = m.weapon();
		Clothes mmm = m.clothes();
		mm.Use();
		mmm.Suit();
		
		//파이어벳
		AbstactFactory f = BarrackF.firebat();
		Weapon ff = f.weapon();
		Clothes fff = f.clothes();
		ff.Use();
		fff.Suit();
		
		//메딕
		AbstactFactory c = BarrackC.medic();
		Weapon cc = c.weapon();
		Clothes ccc = c.clothes();
		cc.Use();
		ccc.Suit();
	}

}//Main