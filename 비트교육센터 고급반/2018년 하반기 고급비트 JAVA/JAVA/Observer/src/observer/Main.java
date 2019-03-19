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
		String []message = {" 사랑해요 팬여러분~~ "," 사생팬은 저리가~~~ "};
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
		System.out.println(name + "은  " + s + "를 들었습니다");
	}
	
}

public class Main
{

	public static void main(String[] args)
	{
		Singer BeWai = new Singer();
		SingerFan a = new SingerFan("홍길동");
		SingerFan b = new SingerFan("전우치");
		SingerFan c = new SingerFan("가나다");
		SingerFan d = new SingerFan("라마바");
		SingerFan e = new SingerFan("사아자");
		SingerFan f = new SingerFan("차카타");
		SingerFan g = new SingerFan("파하");
		SingerFan h = new SingerFan("장첸");
		SingerFan i = new SingerFan("똘마니");
		
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
