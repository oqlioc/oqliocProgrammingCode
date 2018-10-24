#include <iostream>
using namespace std;

/*	
	목적 :
	순수가상함수
	가상함수
*/

class A {
	int a;  // 1
public:

	A(int a)
	{
		this->a = a;

	}
	void dispA() { cout << "A::" << a << endl; }
};

class B : virtual public A{
	int a;  // 2
public:
	B(int a, int b) : A(a)
	{
		this->a = b;

	}
	void dispB() { cout << "B::" << a << endl; }
};

class C : virtual public A{
	int a;  // 3
public:
	C(int a, int c) : A(a)
	{
		this->a = c;

	}
	void dispC() { cout << "C::" << a << endl; }
};

class D : public B, public C{
	int a;  // 4
public:

	D(int a, int b, int c, int d) : B(a, b), C(a, c), A(a)
	{
		this->a = d;

	}
	void dispD() { cout << "D::" << a << endl; }
};

void main()
{
	D dd( 1, 2, 3, 4 );

	dd.dispD();
	dd.dispC();
	dd.dispB();
	dd.dispA();
}