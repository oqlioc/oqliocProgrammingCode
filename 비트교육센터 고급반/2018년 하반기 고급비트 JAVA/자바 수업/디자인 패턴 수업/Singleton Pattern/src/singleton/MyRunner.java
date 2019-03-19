package singleton;

public class MyRunner
{

	public static void main(String[] args)
	{
		Thread t1 = new Thread()
		{

			@Override
			public void run()
			{
				MySingleton.getInstance();
				System.out.println("Thread : t1");
				super.run();
			}
			
		};
		Thread t2 = new Thread()
		{
			@Override
			public void run()
			{
				MySingleton.getInstance();
				System.out.println("Thread : t2");
				super.run();
			}
		};
		Thread t3 = new Thread()
		{
			@Override
			public void run()
			{
				MySingleton.getInstance();
				System.out.println("Thread : t3");
				super.run();
			}
		};
		t1.start();
		t2.start();
		t3.start();
		/*
		MySingleton mySingleton;
		mySingleton = MySingleton.getInstance();
		MySingleton.getInstance();
		MySingleton.getInstance();
		*/
	}

}
