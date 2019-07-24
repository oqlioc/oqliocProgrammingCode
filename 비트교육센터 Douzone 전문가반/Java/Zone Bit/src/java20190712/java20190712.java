package java20190712;

//���� (injection) - Spring�� 3����
class Apple { 
 Fruit f;
 
 Apple(Fruit f) {
    this.f = f;
 }
 
 void func01() {
    f.func03();
 }
 
 /*void func02() {
    //ba.func03();
    or.func03();
 }*/
}

class Fruit {
 void func03() {
    System.out.println("Fruit func03 Call");
 }
}

class Banana extends Fruit{
 void func03() {
    System.out.println("Banana func03 Call");
 }
}

class Orange extends Fruit{
 void func03() {
    System.out.println("Orange func03 Call");
 }
}

/*
//3��
//class Apple{
//	
//	public Apple() {};
//
//	public Apple(int a) {};
//	
//	void func01() {
//		System.out.println("�Լ� 1�� ��!! ���");
//	};
//	void func03() {
//		System.out.println("�Լ� 3�� ��!! ���");
//	};
//	
//}
//
//class Banana extends Apple{
//	
//	void func02() {
//		System.out.println("�Լ� 2�� ��!!");
//	};
//	
//	void func03() {
//		System.out.println("�Լ� 3�� ��!! �ٳ���");
//	};
//
//	
//}
//
//class Orange extends Apple{
//	void func03() {
//		System.out.println("�Լ� 3�� ��!! ������");
//	};
//}
//
//class Kiwifruit extends Apple{
//	void func03() {
//		System.out.println("�Լ� 3�� ��!! Ű��");
//	};
//}
//
//class Dog{
//	void func01(Orange o) {
//		o.func03();
//	};
//	
//	void func01(Apple a) {
//		a.func03();
//	};
//	
//	void func02(Banana b) {
//		b.func03();
//	};
//	
//	void func03(Kiwifruit k) {
//		k.func03();
//	};
}
*/
/*
//2��
//class Apple{
//	
//	public Apple() {};
//
//	public Apple(int a) {};
//	
//	void func01() {
//		System.out.println("�Լ� 1�� ��!! ���");
//	};
//	
//	void func03() {
//		System.out.println("�Լ� 3�� ��!! ���");
//	};
//	
//	void func05() {
//		System.out.println("�Լ� 5�� ��!! ���");
//		func06();
//		func07();
//	};
//	
//	void func06() {
//		System.out.println("�Լ� 6�� ��!! ���");
//	};
//	
//	void func07() {
//		System.out.println("�Լ� 7�� ��!! ���");
//	};
//}
//
//class Banana extends Apple{
//	
//	void func02() {
//		System.out.println("�Լ� 2�� ��!!");
//	};
//	
//	void func03() {
//		System.out.println("�Լ� 3�� ��!! �ٳ���");
//	};
//
//	void func04() {
//		System.out.println("�Լ� 4�� ��!! �ٳ���");
//		super.func03();  // �Լ��� ��������.
//	};
//	
//	void func06() {
//		System.out.println("�Լ� 6�� ��!! �ٳ���");
//	};
//}
*/
//--------------------------------------------------
/*
//1��
//class Apple{
//	int num;  // �ʵ�
//	
//	public Apple() {
//		num = 0;
//		System.out.println("1��" + this.hashCode());
//	};
//	
//	public Apple(int a, int b) {
//		num = 0;
//		System.out.println("1��" + this.hashCode());
//	};
//	
//	public Apple(int num, int a, int b) {
//		this.num = 0;
//		System.out.println("1��" + this.hashCode());
//	};
//	
//	void func01() {
//		System.out.println("�Լ� 1�� ��!!");
//	};
//	
//	void func02(int a, int b) {
//		System.out.println("�Լ� 2�� ��!!" + a + b);
//	};
//	
//	int func03() {
//		System.out.println("�Լ� 3�� ��!!");
//		return 100;
//	};
//	
//	int func04(int a, int b) {
//		System.out.println("�Լ� 4�� ��!!" + a + b);
//		return 100;
//	};
//	
//	Apple func05() {
//		System.out.println("�Լ� 5�� ��!!");
//		return this;
//	};
//	
//	void func06() {
//		System.out.println("�Լ� 6�� ��!!");
//	};
//	// �Լ� �����ε� ���� ����, ���� Ÿ��, Ÿ��ĳ���� �ʼ�
//	int func06(int a) {
//		System.out.println("�Լ� 6�� ��!! int");
//		return 100;
//	};
//	int func06(char a) {
//		System.out.println("�Լ� 6�� ��!! char");
//		return 100;
//	};
//}
*/
public class java20190712 {
	public static void main(String[] args) {
		
		 /*
	      Apple a = new Apple();
	      a.func01(new Banana());
	      a.func02(new Banana());
	      */
	      // =====================
	      
	      Apple a = new Apple(new Banana());
	      a.func01();
//--------------------------------------------------		
/*		
		Dog o1 = new Dog();
		o1.func01(new Orange());
		
//		Dog b1 = new Dog();
//		b1.func02(new Banana());
//		
//		Dog k1 = new Dog();
//		k1.func03(new Kiwifruit());
*/		
//--------------------------------------------------
// 3��
/*
		int a = 0;
		Apple a1 = new Banana();
		Apple a2 = new Orange();
		Apple a3 = new Kiwifruit();
		
		a1.func03();
		
		a = (int) (Math.random() * 100);
		
		switch (a) {
		case 0:
			a1.func03();
			break;
		case 1:
			a2.func03();
			break;
		case 2:
			a3.func03();
			break;
		}
		
		Apple[] a4 = new Apple[3];
		
		a4[0] = new Orange();
		a4[1] = new Banana();
		a4[2] = new Kiwifruit();
		
		a4[a].func03();
*/		
//--------------------------------------------------
/*
// 2��
		Apple a1 = new Apple();
		Apple a2 = new Apple(0);
		
		Banana a3 = new Banana();
		
		a3.func07();
*/
//--------------------------------------------------		
/*
// 1��
		int a1 = 1;
		int b1 = 2;
		
		Apple a = new Apple();
		System.out.println("2��" + a.hashCode());
		
		System.out.println(a.num);
		
		a.func01();
		a.func02(a1, b1);
		System.out.println( a.func03() );
		System.out.println( a.func04(a1, b1) );
		a.func05();
		
		a
		.func05()
		.func05()
		.func06();  // ü�δ�
*/
	}
}