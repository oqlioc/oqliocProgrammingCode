#include <iostream>
using namespace std;

/*
	얕은 대입 연산사 : 
	객체를 생성한 이후에 객체를 복사할때 사용
*/

class A
{
	int a;
public:
	A(int a = 0) { this->a = a; }
	void setA(int a) { this->a = a; }
	int getA() { return a; }

	A& operator= ( const A &bb)  // cc.operator= ( bb.operator= ( aa ) );
	{
		if (this == &bb) return *this;

		this->a = bb.a;

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

	cc = bb = aa; // 대입 연산자 함수 호출
			 // bb.operator=(aa);

	cout << aa.getA() << endl;
	cout << bb.getA() << endl;
	cout << cc.getA() << endl;
}