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
		System.out.println("User :: MP 회복");
	}
}

class HpPotion implements Item
{
	public void use()
	{
		System.out.println("User :: HP 회복");
	}
}

class 집행검조합서 implements Item
{
	public void use()
	{
		System.out.println("Server :: 집행검이 완성되었다!");
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
		System.out.println("데이터 베이스에서 MP포션에 대한 정보를 받아온다.");
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
		System.out.println("데이터 베이스에서 HP포션에 대한 정보를 받아온다.");
	}
	
}

class Swordcreator extends ItemCreator
{

	@Override
	protected void printLog()
	{
		System.out.println("집_행_검 Combination Log:: " + new Date().getTime());
	}

	@Override
	protected Item create()
	{
		return new 집행검조합서();
	}

	@Override
	protected void searchDB()
	{
		System.out.println("데이터 베이스에서 '집행검'에 대한 정보를 받아온다.");
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
