#include <iostream>
#include <stdio.h>
using namespace std;
/*
	����������
	1. private : �ܺο��� ���� �Ұ���
				��, friend�� ���� ����
	2. protected : ��ӹ��� �ܺο����� ���ٰ���
	3. public : �ƹ���

	Ŭ������ �������
	1. �������, �ʵ� : �ַ� private
	    
	2. �������Լ�  (����Ʈ ����) : �ַ� public
		1) ��� : ��ü���, �ʵ��ʱ�ȭ
		2) �����ε��� ����
		3) const member function�� ���������.
		4) ����Ʈ�����ڸ� ��������� �����Ұ��
		   ����Ʈ�����ڴ� �������.
		5) ��ü ������ �ڵ�ȣ��Ǿ�����.

	3. ����Լ�, �޼ҵ� : public
		: �ܺο��� �ʵ带 ����ϰ� �ϱ� ���� ���

	4. ���������  (����Ʈ ����) : 
	5. �Ҹ���  (����Ʈ ����)
		1) ��ü �Ҹ�� �ڵ�ȣ��ȴ�.
		2) ��ü ��� ����
		3) ��ü �Ҹ�� ��ü �ܿ��޸� ����
		4) �����ڿ� ���������� �Լ���տ� ~(ƿ��)�� �ٴ´�.
		5) �����ε��� �Ұ����ϴ�.
		6) const member function�� ����� ����.
		7) virtual �Լ��� �� ���� ����ض�. (�������ε��� ���ؼ�)

	6. ���Կ������Լ�  (����Ʈ ����) : 

*/
/*
	this pointer
	: �޼ҵ��� ù��° �Ű������� ����
*/
class Obj
{
private:
	int a;
	// ������ ������
public:
	// Obj() { this->a = 0; }
	Obj(int a = 0) {  // �������Լ�
		this -> a = a;
	}
	~Obj() { cout << "�Ҹ���" << endl; } // �Ҹ����Լ�

	void setA(int a)  // void setA(Obj *this, int a)
	{
		this -> a = a;
	}
	int getA() {
		return a;
	}

	// ����Ʈ ���������
	// �Ҹ����Լ�
	// ���Կ������Լ�
};

void main()  //�ܺ��Լ�
{
	// Obj *obj;   ��ü���� => ������ȣ��
	// Obj *obj1 = new Obj;   // (Obj*)malloc(sizeof(Obj));
	// Obj *obj2 = new Obj[4];

	Obj *p = new Obj;

	delete p;



	// delete obj1;
	// delete []obj2;


}// �Ҹ���ȣ��