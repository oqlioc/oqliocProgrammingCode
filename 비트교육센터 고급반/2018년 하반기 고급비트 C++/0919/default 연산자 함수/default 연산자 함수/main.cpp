#include <iostream>
using namespace std;
/*
	연산자 함수
	1. 객체와 객체, 객체와 데이터를 가지고 연산처리를 할 수 있게 해주는 함수
	2. operator연산자기호()
	3. 멤버함수와 외부함수로 만들 수 있는데 기본적으로 멤버함수로 만들어야한다.
	   만들 수 없는 경우 외부 함수로 만들되 멤버함수에 접근할수있게 friend를 붙여준다.
	4. 연산자 본연의 의미를 바꾸어서는 안된다.
	5. 새로운 연산자를 만들지 않는다.
	
	연산자 함수로 만들수없는 함수 찾아서 정리
*/
class A{

	int *a;

public:

	//A(int a = 0) { this->a = a; } // 생성자
	A(int a = 0) {		// 생성자
		this->a = new int;
		*(this->a) = a;
	}

	~A() {
		delete a;
	}

	A(const A &aa) {
		this->a = new int;
		*this->a = *aa.a;
	}

	//void setA(int a) { this->a = a; }
	int getA()const { return *a; }
	
	//깊은 대입 연산자 함수
	A& operator=(const A &aa) {  //default로 존재
		
		if (this == &aa) return *this;
		*(this->a) = *aa.a;
		return *this;

	}

};

void main()
{
	A aa(10);
	A bb;
	A cc;

	cout << aa.getA() << endl;
	cout << bb.getA() << endl;

	cc.operator=(bb.operator=(aa)); //cc = bb = aa; // 대입 연산자 함수 호출 , default로 기본으로 = 들고있음
			 // bb.operator=(aa)

	cout << aa.getA() << endl;
	cout << bb.getA() << endl;
	cout << cc.getA() << endl;
}
