#include <iostream>
using namespace std;

/*
���� ����(�ʵ� ����Ʈ X)

��������� ȣ��ñ�
	1. ��ü ������ ��ü�� ���ڷ� �� ���
	2. ��ü ������ ��ü�� ���� �� ���
	3. �޼ҵ��� �Ű������� ��ü�� ���� �� ���
	4. �޼ҵ忡�� ��ü�� ���� �� ���

	��ü�� ������ ������ �ʵ���ü�� �����ҷ���

*/
class A
{
	int *a;
	int *b;
public:
	//������
	A(int a = 0) {
		this->a = new int;
		this->b = new int;
		*(this->a) = a;
		*(this->b) = a;
	}

	//�Ҹ���
	~A() { delete a; delete b;}
	//���������
	
	A(const A &aa) {
		this->a = new int;
		this->b = new int;
		*(this->a) = *(aa.a);
		*(this->b) = *(aa.a);
	}
	
	//���Կ������Լ�
	int getA()const { return *a; }
	int getB()const { return *b; }

};

void main()
{
	A aa(90);
	cout << aa.getA()  << "\t" << aa.getB() << endl;

	A bb(aa);  // ����������Լ� ȣ��
	cout << bb.getA() << "\t" << bb.getB() << endl;
}