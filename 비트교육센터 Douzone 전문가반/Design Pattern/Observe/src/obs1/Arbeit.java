package obs1;

public class Arbeit implements Customer {
	
	Observable observable;
	
	public Arbeit() {};
	
	@Override
	public void Updata() {
		System.out.println("알바: 책 또 추가됨!?");
	};
	
}
