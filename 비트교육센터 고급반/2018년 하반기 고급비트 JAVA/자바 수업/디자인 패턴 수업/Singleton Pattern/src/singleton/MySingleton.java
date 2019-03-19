package singleton;

public class MySingleton
{
	private static MySingleton myInstance = null;
	
	private MySingleton()
	{
		System.out.println("������ ȣ��");
	}
	
	// synchromized -> ��Ģ���� ���Ǵ� �����带 ȣ���ߴ� ������� ���
	// �����ս� ������ �ʹ� ŭ
	public static MySingleton getInstance()
	{
		System.out.println("Instance �޼ҵ� ȣ��");
		if(myInstance == null)	// ������ ȣ���� ������ �Ǵ°��� �������ؼ�
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
