package observer;

import java.util.ArrayList;
import java.util.Random;

interface Fan
{
	public void hear(String s);
	
}

interface Talent
{
	public void addFan(Fan o);
	public void deleteFan(Fan o);
	public void speak();
	
}

class Singer implements Talent
{
	private ArrayList<Fan> FanList;
	
	public Singer()
	{
		FanList = new ArrayList<Fan>();
	}
	
	@Override
	public void addFan(Fan o)
	{
		FanList.add(o);
	}

	@Override
	public void deleteFan(Fan o)
	{
		int idx = FanList.indexOf(o);
		FanList.remove(idx);
	}

	@Override
	public void speak()
	{
		String []message = {" ����ؿ� �ҿ�����~~ "," ������� ������~~~ "};
		Random random = new Random();
		int idx = random.nextInt(message.length);
		for(int i = 0; i < FanList.size(); i++)
		{
			Fan o = FanList.get(i);
			o.hear(message[idx]);
		}
	}
	
}

class SingerFan implements Fan
{
	private String name;
	
	public SingerFan(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public void hear(String s)
	{
		System.out.println(name + "��  " + s + "�� ������ϴ�");
	}
	
}

public class Main
{

	public static void main(String[] args)
	{
		Singer BeWai = new Singer();
		SingerFan a = new SingerFan("ȫ�浿");
		SingerFan b = new SingerFan("����ġ");
		SingerFan c = new SingerFan("������");
		SingerFan d = new SingerFan("�󸶹�");
		SingerFan e = new SingerFan("�����");
		SingerFan f = new SingerFan("��īŸ");
		SingerFan g = new SingerFan("����");
		SingerFan h = new SingerFan("��þ");
		SingerFan i = new SingerFan("�ʸ���");
		
		BeWai.addFan(a);
		BeWai.addFan(b);
		BeWai.addFan(c);
		BeWai.addFan(d);
		BeWai.speak();
		System.out.println("----------------------------");
		BeWai.addFan(e);
		BeWai.addFan(f);
		BeWai.addFan(g);
		BeWai.speak();
		System.out.println("----------------------------");
		BeWai.addFan(h);
		BeWai.addFan(i);
		BeWai.speak();
		System.out.println("----------------------------");
		BeWai.deleteFan(a);
		BeWai.deleteFan(f);
		BeWai.deleteFan(d);
	}

}
