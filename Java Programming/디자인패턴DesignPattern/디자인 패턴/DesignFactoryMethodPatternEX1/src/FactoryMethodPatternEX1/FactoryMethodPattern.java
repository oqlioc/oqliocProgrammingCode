package FactoryMethodPatternEX1;

interface Unit {
	public int getReqMineral();

	public String getName();
}

class Marine implements Unit
{

	@Override
	public int getReqMineral() {
		return 50;
	}
	@Override
	public String getName() {
		return "���� ����";
	}

}

class Firebat implements Unit
{

	@Override
	public int getReqMineral() {
		return 50;
	}

	@Override
	public String getName() {
		return "���̾ ����";
	}

}

class vessel implements Unit
{

	@Override
	public int getReqMineral() {
		return 100;
	}

	@Override
	public String getName() {
		return "���̾�载 ����";
	}

}

class Battlecruiser implements Unit
{

	@Override
	public int getReqMineral() {
		return 400;
	}

	@Override
	public String getName() {
		return "��Ʋũ���� ����";
	}

}

class Dropship implements Unit
{

	@Override
	public int getReqMineral() {
		return 100;
	}

	@Override
	public String getName() {
		return "����� ����";
	}

}

abstract class UnitCreator
{
	public Unit createUnit() {
		Unit i;
		printUnit();
		i = create();
		requestCreateUnit();
		return i;
	}

	protected abstract Unit requestCreateUnit();

	protected abstract Unit create();

	protected abstract void printUnit();
}

class Barracks extends UnitCreator
{

	@Override
	protected Unit requestCreateUnit() {
		return null;
	}

	@Override
	protected Unit create() {
		return null;
	}

	@Override
	protected void printUnit() {
		
	}
	
}

public class FactoryMethodPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
