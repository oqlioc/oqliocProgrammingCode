#include <iostream>
using namespace std;

class A {
	int *p;

public:
	A(int data=0) { // �Ͻ��� �������̵� 
		p = new int;
		*p = data;
	}

	void setA(int p) {
		*(this->p) = p;
	}

	int getA()const {
		return *p;
	}
	
	~A() {  // �Ҹ��� - �ܿ� �޸� ����
		delete p;
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