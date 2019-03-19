package singleton;

public class MySingleton
{
	private static MySingleton myInstance = null;
	
	private MySingleton()
	{
		System.out.println("생성사 호출");
	}
	
	// synchromized -> 규칙없이 사용되던 쓰레드를 호출했던 순서대로 사용
	// 퍼포먼스 유지가 너무 큼
	public static MySingleton getInstance()
	{
		System.out.println("Instance 메소드 호출");
		if(myInstance == null)	// 생성자 호출이 여러번 되는것을 막기위해서
		{
//			myInstance = new MySingleton();
			synchronized (MySingleton.class)
			{
				if(myInstance == null)
				{
					myInstance = new MySingleton();
				}
				return myInstance;
			}
		}
		else
		{
			return myInstance;	
		}
	}
}
