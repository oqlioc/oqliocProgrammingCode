package SingletonPattern;

public class MySingleton {

	private static MySingleton mysingleton;

	private MySingleton() {
		System.out.println("������ ȣ��");
	}

	// synchronized �����ϰ� �����
	public synchronized static MySingleton getInstance() {
		System.out.println("Instance �޼ҵ� ȣ��");
		if (mysingleton == null) {
			synchronized (MySingleton.class) {
				if (mysingleton == null) {
					mysingleton = new MySingleton();
				}
				return mysingleton;
			}
		} else {
			return mysingleton;
		}
	}
}
