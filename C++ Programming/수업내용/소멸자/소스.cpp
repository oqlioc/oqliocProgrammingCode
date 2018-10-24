#include <iostream>
using namespace std;

class A
{
	int *p;

public:
	A(int data = 0)
	{
		p = new int;
		*p = data;
	}

	~A()  // ÀÜ¿©¸Ş¸ğ¸® ÇØÁ¦
	{
		cout << "¼Ò¸êÀÚ : " << *p << endl;
		delete p;
	}

	void setA(int p) {
		*(this->p) = p;
	}
	int getA()const {
		return *p;
	}

};


void main()
{
	A aa;
	aa.setA(10);
	cout << aa.getA() << endl;

	A bb(90);
	cout << bb.getA() << endl;

}