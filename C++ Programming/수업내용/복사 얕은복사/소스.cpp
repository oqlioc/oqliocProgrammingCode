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
	int a;
public:
	//������
	A(int a = 0) {
		this->a = a;
	}

	//�Ҹ���
	//���������
	A(A &aa) {
		this->a = aa.a;
	}

	//���Կ������Լ�
	int getA()const { return a; }

};

void main()
{
	A aa(90);
	cout << aa.getA() << endl;

	A bb(aa);  // ����������Լ� ȣ��
	cout << bb.getA() << endl;
}