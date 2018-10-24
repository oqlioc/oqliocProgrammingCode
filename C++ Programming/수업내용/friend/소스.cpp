#include <iostream>
using namespace std;

/*
	friend function
	외부함수 연결
*/

class A
{
	int a;
public:
	void setA(int a) { this->a = a; }
	int getA() const { return a;	}

	friend void disp();
};

void disp()
{
	A aa;
	aa.a = 100;
	cout << aa.a << endl;

}

void main()
{
	disp();
}