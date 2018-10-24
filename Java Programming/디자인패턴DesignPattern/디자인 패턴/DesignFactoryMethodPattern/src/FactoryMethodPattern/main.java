package FactoryMethodPattern;

import java.util.Date;

interface item {
	public void use();
}

class MpPotion implements item {
	@Override
	public void use() {
		System.out.println("Mp�� ȸ���Ѵ�.");
	}
}

class HpPotion implements item {
	@Override
	public void use() {
		System.out.println("Hp�� ȸ���Ѵ�.");
	}
}

class BFsword implements item {
	@Override
	public void use() {
		System.out.println("���ݷ��� 45������ ");
	}
}

abstract class ItemCreator {
	
	public item createItem() {
		item i;
		searchDB();
		i = create();
		printLog();
		return i;
	}

	protected abstract void printLog();

	protected abstract item create();

	protected abstract void searchDB();
}

class Mpcreator extends ItemCreator {

	@Override
	protected void printLog() {

		System.out.println("Log::Mp_potion Create" + new Date().getTime());
	}

	@Override
	protected item create() {
		return new MpPotion();
	}

	@Override
	protected void searchDB() {
		// TODO Auto-generated method stub
		System.out.println("�����ͺ��̽����� Mp���ǿ� ���� ������ �޾ƿ´�.");
	}

}

class Hpcreator extends ItemCreator {

	@Override
	protected void printLog() {
		System.out.println("Log::Hp_potion Create" + new Date().getTime());
	}

	@Override
	protected item create() {
		return new HpPotion();
	}

	@Override
	protected void searchDB() {
		// TODO Auto-generated method stub

		System.out.println("�����ͺ��̽����� Hp���ǿ� ���� ������ �޾ƿ´�.");
	}

}

class BFcreator extends ItemCreator {
	@Override
	protected void printLog() {
		System.out.println("Log::BF_sword Create" + new Date().getTime());
	}

	@Override
	protected item create() {
		return new BFsword();
	}

	@Override
	protected void searchDB() {
		// TODO Auto-generated method stub

		System.out.println("�����ͺ��̽����� BF��˿� ���� ������ �޾ƿ´�.");
	}
}

public class main {

	public static void main(String[] args) {

		ItemCreator creator = new Mpcreator();
		item i = creator.createItem();
		i.use();

		creator = new Hpcreator();
		i = creator.createItem();
		i.use();
		
		creator = new BFcreator();
		i = creator.createItem();
		i.use();

	}

}