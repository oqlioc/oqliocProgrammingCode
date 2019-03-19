#include <iostream>
using namespace std;
/*
	������ �Լ�
	1. ��ü�� ��ü, ��ü�� �����͸� ������ ����ó���� �� �� �ְ� ���ִ� �Լ�
	2. operator�����ڱ�ȣ()
	3. ����Լ��� �ܺ��Լ��� ���� �� �ִµ� �⺻������ ����Լ��� �������Ѵ�.
	   ���� �� ���� ��� �ܺ� �Լ��� ����� ����Լ��� �����Ҽ��ְ� friend�� �ٿ��ش�.
	4. ������ ������ �ǹ̸� �ٲپ�� �ȵȴ�.
	5. ���ο� �����ڸ� ������ �ʴ´�.
	
	������ �Լ��� ��������� �Լ� ã�Ƽ� ����
*/
class A{

	int *a;

public:

	//A(int a = 0) { this->a = a; } // ������
	A(int a = 0) {		// ������
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
	
	//���� ���� ������ �Լ�
	A& operator=(const A &aa) {  //default�� ����
		
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

	cc.operator=(bb.operator=(aa)); //cc = bb = aa; // ���� ������ �Լ� ȣ�� , default�� �⺻���� = �������
			 // bb.operator=(aa)

	cout << aa.getA() << endl;
	cout << bb.getA() << endl;
	cout << cc.getA() << endl;
}
