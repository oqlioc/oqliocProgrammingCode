package factorymethod;

import java.util.Date;

interface Item
{
	public void use();
}

class MpPotion implements Item
{
	public void use()
	{
		System.out.println("User :: MP ȸ��");
	}
}

class HpPotion implements Item
{
	public void use()
	{
		System.out.println("User :: HP ȸ��");
	}
}

class ��������ռ� implements Item
{
	public void use()
	{
		System.out.println("Server :: ������� �ϼ��Ǿ���!");
	}
}

abstract class ItemCreator
{
	public Item createItem()
	{
		Item item;
		searchDB();
		item = create();
		printLog();
		
		return item;
	}
	
	protected abstract void printLog();
	protected abstract Item create();
	protected abstract void searchDB();
}

class Mpcreator extends ItemCreator
{

	@Override
	protected void printLog()
	{
		System.out.println("MP_Potion Create Log:: " + new Date().getTime());
	}

	@Override
	protected Item create()
	{
		return new MpPotion();
	}

	@Override
	protected void searchDB()
	{
		System.out.println("������ ���̽����� MP���ǿ� ���� ������ �޾ƿ´�.");
	}
	
}


class Hpcreator extends ItemCreator
{

	@Override
	protected void printLog()
	{
		System.out.println("HP_Potion Create Log:: " + new Date().getTime());
	}

	@Override
	protected Item create()
	{
		return new HpPotion();
	}

	@Override
	protected void searchDB()
	{
		System.out.println("������ ���̽����� HP���ǿ� ���� ������ �޾ƿ´�.");
	}
	
}

class Swordcreator extends ItemCreator
{

	@Override
	protected void printLog()
	{
		System.out.println("��_��_�� Combination Log:: " + new Date().getTime());
	}

	@Override
	protected Item create()
	{
		return new ��������ռ�();
	}

	@Override
	protected void searchDB()
	{
		System.out.println("������ ���̽����� '�����'�� ���� ������ �޾ƿ´�.");
	}
	
}

public class Main
{

	public static void main(String[] args)
	{
		ItemCreator creator = new Mpcreator();
		Item item = creator.createItem();
		item.use();
		
		creator = new Hpcreator();
		item = creator.createItem();
		item.use();
		
		creator = new Swordcreator();
		item = creator.createItem();
		item.use();
	}

}
