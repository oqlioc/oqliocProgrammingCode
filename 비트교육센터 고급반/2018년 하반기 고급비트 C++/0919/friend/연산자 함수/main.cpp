#include <iostream>
using namespace std;
/*
	friend
	1.class
	2.member function    �޼ҵ�(Ŭ���� �����Լ�)
	3.function   �ܺ��Լ�

*/

class A{

	int a;

public:
	void setA(int a) { this->a = a; }
	int getA()const { return a; }

	
	//friend class B; // ģ�����
	//friend void B:: dispA(); // ������ ����Լ�
	friend void disp(); // ������ �Լ�
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