#include <iostream>
using namespace std;
/*

	��������� ȣ��ñ�
	1. ��ü ������ ��ü�� ���ڷ� �� ���
	2. ��ü ������ ��ü�� ���� �� ���
	3. �޼ҵ��� �Ű������� ��ü�� ���� �� ���
	4. �޼ҵ忡�� ��ü�� ���� �� ���

	�ʵ带 �����ͷ� �Ⱦ��� ����Ʈ������ �Ű����� �״�� ����
	������ ���� ���� x

	A aa;   'A bb(aa)';    / 'A cc = aa'; (  aa ->���� cc )

	A disp('A aa') {
		A aa;
		return 'aa';
	}

	���� ������ : field copy 
	- ���� ���� ( ���α׷��� �˾Ƽ� ����. �ʵ带 ������ ��� x �ش� )
	- ���� ����(deep copy) ( ������ �� )
	
*/

/*
class A {

	int a;
	int b;
public:

	A(int a = 0) { //������
		this->a = a;
		this->b = a;
	}
	
//	A(A &t) {	// default ���� ������
//		this->a = t.a;
//		this->b = t.b;
//	}

	//�Ҹ���
	//��������� - ��ü�� ������ �������� �ʵ� ���� ī��
	//���Կ����� �Լ� - ��ü�� ������ �Ŀ� �ʵ� ���� ī�� 
	int getA()const { return a; }
	int getB()const { return b; }

};

void main()
{

	A aa(90);
	cout << aa.getA() << " \t " << aa.getB() << endl;

	A bb(aa);	// ���������
	cout << bb.getA() << " \t " << bb.getB() << endl;

	
}
*/

// ========== pointer ���� ������
/*
class A {

	int *a;
	int *b;

public:

	A(int a = 0) {
		this->a = new int;
		this->b = new int;
		*(this->a) = a;
		*(this->b) = a;
	}

	A(const A &t) {	// A aa�� ���� �޸� �Ҵ� ����  // ������ �Ҽ������� t�� aa���� �б⸸�ϰ� ���� �ǵ帮�����ϰ�
		this->a = new int;
		this->b = new int;
		*(this->a) = *(t.a);
		*(this->b) = *(t.a);
	}	//���� ����

	~A() {
		delete []a; 
		delete []b; 
		
		cout << "�Ҹ��� ȣ��" << endl;
	}
	
	int getA()const { return *a; }
	int getB()const { return *b; }

};

void main()
{

	A aa(90);
	cout << aa.getA() << " \t " << aa.getB() << endl;

	A bb(aa);	// ���������
	cout << bb.getA() << " \t " << bb.getB() << endl;

}
*/

// =================================================

class A {

public:
	A() { cout << "������" << endl; }
	A(const A &aa) { cout << "���������" << endl; }
	void setObject(A aa) {}
	A getObject() {
		A aa; 
		return aa; 
	}
	~A() { cout << "�Ҹ���" << endl; }
};

void main()
{
	A aa;
	A bb(aa);
	A cc = bb;

	aa.setObject(bb);
	bb.setObject(cc);
	cc.setObject(aa);

	aa.getObject();
	bb.getObject();
	cc.getObject();
}
/*
��
��
��

��
��
��
��
��
��

��
��
��
��
��
��
��
��
��
��
��
��

��
��
��

*/