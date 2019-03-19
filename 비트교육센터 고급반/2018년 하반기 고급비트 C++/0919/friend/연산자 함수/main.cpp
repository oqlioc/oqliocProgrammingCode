#include <iostream>
using namespace std;
/*
	friend
	1.class
	2.member function    메소드(클래스 내부함수)
	3.function   외부함수

*/

class A{

	int a;

public:
	void setA(int a) { this->a = a; }
	int getA()const { return a; }

	
	//friend class B; // 친구등록
	//friend void B:: dispA(); // 프렌드 멤버함수
	friend void disp(); // 프렌드 함수
};

void disp() {

		A aa;
		aa.a = 100;
		cout << aa.a << endl;

	}

void main()
{
	disp();
}