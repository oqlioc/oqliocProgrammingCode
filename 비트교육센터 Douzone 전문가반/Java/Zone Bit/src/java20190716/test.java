package java20190716;

//Example 1
//class Ap{
// int num;
// 
// public Ap() {};
// 
// public void fun1() {
//    
// }
// 
// public void fun3() {
//    
// }
//}
//------------------------------------------------------
//Example 2
//class Ap{
// int num;
// 
// public Ap() {};
// 
// public void fun1() {
//    
// }
// 
// public void fun3() {
//    
// }
//}
//
//class Ba extends Ap{
// 
// public void fun2() {
//    
// }
// 
// public void fun3() {
//    
// }
//}
//------------------------------------------------------
//Example 3
//계층상속 - 상속이 연속으로 3번 함.
//class Ap{
// int num;
// 
// public Ap() {};
// 
// public void fun1() {
//    System.out.println("Apple fun1 Call.");
// }
// 
// public void fun3() {
//    System.out.println("Apple fun2 Call.");
// }
//}
//
//class Ba extends Ap{
// 
// public void fun2() {
//    System.out.println("Banana fun2 Call.");
// }
// 
// public void fun3() {
//    System.out.println("Banana fun3 Call.");
// }
//}
//
//class Or extends Ba{
// 
// public void fun2() {
//    System.out.println("Orange fun2 Call.");
// }
// 
// public void fun3() {
//    System.out.println("Orange fun3 Call.");
// }
//}
//------------------------------------------------------
//Example 4
//abstract class Ap{
// int num;
// 
// public Ap() {};
// 
// public void fun1() {
//    System.out.println("Apple fun1 Call.");
// }
// 
// public abstract void fun3();
//}
//
//class Ba extends Ap{
//
// @Override
// public void fun3() {
//    // TODO Auto-generated method stub
//    System.out.println("Banana fun3 Call.");
// }
//}
//------------------------------------------------------
//Example 5
// 1번 직접객체생성 X.
// 2번 미구현함수는 모두 구현해야함.
// 3번 구현함수는 반드시 public을 붙인다.
//interface Ap {
//	void func1();
//
//	void func2();
//}
//
//class Ba implements Ap {
//
//	@Override
//	public void func1() {
//		System.out.println("Banana fun1 Call.");
//	}
//
//	@Override
//	public void func2() {
//		System.out.println("Banana fun2 Call.");
//	}
//
//}
//------------------------------------------------------
//Example 6
//interface Ap {
//	void func1();
//}
//
//interface Ba {
//	void func2();
//}
//
//class Or implements ap, ba{
//
//	@Override
//	public void func1() {
//		System.out.println("Banana fun1 Call.");
//	}
//
//	@Override
//	public void func2() {
//		System.out.println("Banana fun2 Call.");
//	}
//	
//}
//------------------------------------------------------
//Example 7
// Java에서 다중 상속 금지
//class Ap{
//}
//class Ba{
//}
//class Or extends Ap{
//}
//------------------------------------------------------
//Example 8
//class Ap {
//}
//
//interface Ba {
//	void func1();
//}
//
//interface Or {
//	void func2();
//}
//
//class Ki extends Ap implements Ba, Or {
//
//	@Override
//	public void func2() {
//		System.out.println("Kiwi fun2 Call.");
//	}
//
//	@Override
//	public void func1() {
//		System.out.println("Kiwi fun1 Call.");
//	}
//}
//------------------------------------------------------
//Example 9
//interface Ap {
//	void func1();
//}
//
//interface Ba extends Ap {
//	void func2();
//}
//
//class Or implements Ba {
//
//	@Override
//	public void func1() {
//		System.out.println("Orange fun1 Call.");
//	}
//
//	@Override
//	public void func2() {
//		System.out.println("Orange fun2 Call.");
//	}
//
//}
//------------------------------------------------------
//Example 10
//interface Ap { // 음식 인터페이스
//	void func1();
//
//	interface Ba { // 한식 인터페이스
//		void func2();
//	}
//
//	interface Me { // 양식 인터페이스
//		void func3();
//	}
//
//	interface St { // 중식 인터페이스
//		void func4();
//	}
//}
//
//class Or implements Ap {
//
//	@Override
//	public void func1() {
//		System.out.println("Orange fun1 Call.");
//	}
//
//}
//
//class Ki implements Ap.Ba {
//
//	@Override
//	public void func2() {
//		System.out.println("Kiwi fun2 Call.");
//	}
//
//}
//------------------------------------------------------
//Example 11
//interface Ap {
//	void func1();
//
//	class Ba {
//		void func2() {
//			System.out.println("Banana fun2 Call.");
//		};
//	};
//}
//
//class Or implements Ap {
//
//	@Override
//	public void func1() {
//		System.out.println("Orange fun1 Call.");
//	}
//
//}
//
//class Ki extends Ap.Ba {
//}
//------------------------------------------------------
//Example 12
//class Ap {
//	void func1() {
//		System.out.println("Apple fun1 Call.");
//	}
//
//	class Ba {
//		void func2() {
//			System.out.println("Banana fun2 Call.");
//		}
//	}
//}
//
//public class test {
//	public static void main(String[] args) {
//		Ap a = new Ap();
//		Ap.Ba b = a.new Ba();
//
//		b.func2();
//	}
//}
//------------------------------------------------------
//Example 13
//interface Ap {
//	void func1();
//}
//
//class Ba implements Ap {
//
//	@Override
//	public void func1() {
//		System.out.println("Banana fun1 Call. 1번");
//	}
//}
//
//public class test {
//	public static void main(String[] args) {
//		Ba b = new Ba();
//		b.func1();
//
//		Ap a = new Ap() { // 익명 클래스
//
//			@Override
//			public void func1() {
//				System.out.println("Apple fun1 Call. 2번");
//			}
//
//		};
//		a.func1();
//
//		new Ap() { // 익명 객체
//
//			@Override
//			public void func1() {
//				System.out.println("Apple fun1 Call. 3번");
//
//			}
//
//		}.func1();
//	}
//}
//------------------------------------------------------
//Example 14
//interface Ap {
//	void func1();
//}
//
//class Ba {
//	void func2(Ap a) {
//		System.out.println("Banana fun1 Call. 1번");
//		a.func1();
//	};
//}
//
//public class test {
//	public static void main(String[] args) {
//
//		Ba b = new Ba();
//		b.func2(new Ap() {
//
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call. 2번");
//			}
//
//		});
//
//		b = new Ba();
//		b.func2(new Ap() {
//			
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call. 2-1번");
//			}
//			
//		});
//	}
//}
//------------------------------------------------------
//Example 15
//class Ap {
//	interface Ba {
//		void func1();
//	}
//}
//
//public class test {
//	public static void main(String[] args) {
//		Ap.Ba ab = new Ap.Ba() {  // 익명 클래스
//
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call. 1번");
//			}
//			
//		};
//		ab.func1();
//		
//		new Ap.Ba() {  // 익명 객체
//			
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call. 2번");
//			}
//		}.func1();
//	}
//}
//------------------------------------------------------
//Example 16
//interface Ap {
//	void func1();
//}
//
//class Ba implements Ap {
//
//	@Override
//	public void func1() {
//		System.out.println("Banana fun1 Call. 1번");
//	}
//
//}
//
//public class test {
//	public static void main(String[] args) {
//		Ba b = new Ba();
//		b.func1();
//		
//		new Ap() {
//
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call. 2번");
//			}
//		}.func1();
//		
//		Ba b1 = new Ba() {
//			
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call. 3번");
//			}
//		};
//		b1.func1();
//	}
//}
//------------------------------------------------------
//Example 17
//interface Ap {
//	void func1();
//}
//
//abstract class Ba implements Ap {  // interface안에 interface 똑같음
//	abstract void func2();
//}
//
//public class test {
//	public static void main(String[] args) {
//		
//		new Ba() {
//
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call.");
//			}
//
//			@Override
//			void func2() {
//				System.out.println("Banana fun2 Call.");
//			}
//			
//		}.func1();
//		
//		Ba b = new Ba() {
//
//			@Override
//			public void func1() {
//				System.out.println("Banana fun1 Call.");
//			}
//
//			@Override
//			void func2() {
//				System.out.println("Banana fun2 Call.");
//			}
//			
//		};
//		b.func1();
//		b.func2();
//	}
//}
//------------------------------------------------------
//Example 18
//class A {
//	interface B {
//		void func1();
//	}
//
//	interface C {
//		void func2();
//	}
//}
//
//public class test {
//	public static void main(String[] args) {
//
//		new A.B() {
//
//			@Override
//			public void func1() {
//				System.out.println("B fun1 Call.");
//
//			}
//		}.func1();
//		new A.C() {
//
//			@Override
//			public void func2() {
//				System.out.println("C fun2 Call.");
//			}
//		}.func2();
//
//		A.B ab = new A.B() {
//
//			@Override
//			public void func1() {
//				System.out.println("B fun1 Call.");
//			}
//		};
//		A.C ac = new A.C() {
//
//			@Override
//			public void func2() {
//				System.out.println("C fun2 Call.");
//			}
//		};
//		ab.func1();
//		ac.func2();
//	}
//}
//------------------------------------------------------
//Example 19
//class A {
//	interface B {
//		void func1();
//	}
//}
//
//class C {
//	void func2(A.B ab) {
//	}
//}
//
//public class test {
//	public static void main(String[] args) {
//		C c = new C();
//		c.func2(new A.B() {
//			
//			@Override
//			public void func1() {
//				System.out.println("B fun1 Call.");
//			}
//		});
//		
//	}
//}
//------------------------------------------------------
//Example 20
class View {
	interface OnClickListener {
		void OnClick();
	}
}

class Button {
	void SetOnClickListener(View.OnClickListener ab) {
		ab.OnClick();
	}
}

public class test {
	public static void main(String[] args) {
		Button c = new Button();
		c.SetOnClickListener(new View.OnClickListener() {
			
			@Override
			public void OnClick() {
				System.out.println("B fun1 Call.");
			}
		});
	}
}