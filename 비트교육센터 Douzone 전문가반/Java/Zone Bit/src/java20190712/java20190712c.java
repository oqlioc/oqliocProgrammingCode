package java20190712;

interface game{
	void st();
	void pl();
	void en();
	void p();
}

 class wkdrl implements game{
	 
	Ai a;
	 
	public wkdrl(Ai a) {
		this.a = a;
	};
	
	public void st() {
		a.func01();
		System.out.println("��� �뱹�� ����");
	};
	
	public void pl() {
		a.func01();
		System.out.println("��� �뱹�� ����");
	};
	
	public void en() {
		a.func01();
		System.out.println("��� �뱹�� ����");
	};
	
	public void p() {  // ���丮�� �Լ�
		this.st();
		this.pl();
		this.en();
	}
}

class qkenr implements game{
	 
	Ai a;
	 
	public qkenr(Ai a) {
		this.a = a;
	};
	
	public void st() {
		a.func01();
		System.out.println("�ٵ� �뱹�� ����");
	};
	
	public void pl() {
		a.func01();
		System.out.println("�ٵ� �뱹�� ����");
	};
	
	public void en() {
		a.func01();
		System.out.println("�ٵ� �뱹�� ����");
	};
	
	public void p() {  // ���丮�� �Լ�
		this.st();
		this.pl();
		this.en();
	}
}
 
interface Ai {
	void func01();
}

class dkfvkrh implements Ai{
	public void func01() {
		System.out.println("�� �̸��� ���İ�");
	};
}

class qpxkrh implements Ai{
	public void func01() {
		System.out.println("�� �̸��� ��Ÿ��");
	};
}

//abstract class doslajf{
//	abstract void func01();
//	
//	void func02() {
//		System.out.println("�θ��Լ�222222");
//	};
//}
//
//class ro extends doslajf{
//
//	@Override
//	void func01() {
//		System.out.println("�ڽ��Լ�111111");
//	}
//	
//	void func03() {
//		System.out.println("�θ��Լ�333333");
//	}
//	
//}

interface doslajf{
	void func01();
	void func02();
}

class ro implements doslajf{

	@Override
	public void func01() {
		System.out.println("�ڽ��Լ�111111");
	}

	@Override
	public void func02() {
		System.out.println("�ڽ��Լ�222222");
	}	
}

public class java20190712c {

	public static void main(String[] args) {
		
		wkdrl a1 = new wkdrl(new dkfvkrh());
		wkdrl a2 = new wkdrl(new qpxkrh());
		
		qkenr b1 = new qkenr(new dkfvkrh());
		qkenr b2 = new qkenr(new qpxkrh());
		
		a1.p();
		System.out.println("-----------------------");
		a2.p();
		System.out.println("-----------------------");
		b1.p();
		System.out.println("-----------------------");
		b2.p();
		
		ro r = new ro();
		r.func01();
	}
}


