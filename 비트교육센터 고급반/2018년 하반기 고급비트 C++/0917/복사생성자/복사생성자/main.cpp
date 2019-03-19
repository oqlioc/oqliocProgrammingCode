#include <iostream>
using namespace std;
/*

	복사생성자 호출시긱
	1. 객체 생성시 객체를 인자로 줄 경우
	2. 객체 생성시 객체를 대입 할 경우
	3. 메소드의 매개변수로 객체를 선언 할 경우
	4. 메소드에서 객체를 리턴 할 경우

	필드를 포인터로 안쓸시 디폴트값으로 매개변수 그대로 복사
	포인터 쓰면 복사 x

	A aa;   'A bb(aa)';    / 'A cc = aa'; (  aa ->대입 cc )

	A disp('A aa') {
		A aa;
		return 'aa';
	}

	복사 생성자 : field copy 
	- 얕은 복사 ( 프로그램이 알아서 해줌. 필드를 포인터 사용 x 해당 )
	- 깊은 복사(deep copy) ( 개발자 몫 )
	
*/

/*
class A {

	int a;
	int b;
public:

	A(int a = 0) { //생성자
		this->a = a;
		this->b = a;
	}
	
//	A(A &t) {	// default 복사 생성자
//		this->a = t.a;
//		this->b = t.b;
//	}

	//소멸자
	//복사생성자 - 객체를 생성한 시점에서 필드 값을 카피
	//대입연산자 함수 - 객체를 생성한 후에 필드 값을 카피 
	int getA()const { return a; }
	int getB()const { return b; }

};

void main()
{

	A aa(90);
	cout << aa.getA() << " \t " << aa.getB() << endl;

	A bb(aa);	// 복사생성자
	cout << bb.getA() << " \t " << bb.getB() << endl;

	
}
*/

// ========== pointer 복사 생성자
/*
class A {

	int *a;
	int *b;

public:

	A(int a = 0) {
		this->a = new int;
		this->b = new int;
		*(this->a) = a;
		*(this->b) = a;
	}

	A(const A &t) {	// A aa의 동적 메모리 할당 복사  // 접근은 할수있지만 t로 aa값을 읽기만하고 값은 건드리지못하게
		this->a = new int;
		this->b = new int;
		*(this->a) = *(t.a);
		*(this->b) = *(t.a);
	}	//깊은 복사

	~A() {
		delete []a; 
		delete []b; 
		
		cout << "소멸자 호출" << endl;
	}
	
	int getA()const { return *a; }
	int getB()const { return *b; }

};

void main()
{

	A aa(90);
	cout << aa.getA() << " \t " << aa.getB() << endl;

	A bb(aa);	// 복사생성자
	cout << bb.getA() << " \t " << bb.getB() << endl;

}
*/

// =================================================

class A {

public:
	A() { cout << "생성자" << endl; }
	A(const A &aa) { cout << "복사생성자" << endl; }
	void setObject(A aa) {}
	A getObject() {
		A aa; 
		return aa; 
	}
	~A() { cout << "소멸자" << endl; }
};

void main()
{
	A aa;
	A bb(aa);
	A cc = bb;

	aa.setObject(bb);
	bb.setObject(cc);
	cc.setObject(aa);

	aa.getObject();
	bb.getObject();
	cc.getObject();
}
/*
생
복
복

복
소
복
소
생
소

생
복
소
소
생
복
소
소
생
복
소
소

소
소
소

*/