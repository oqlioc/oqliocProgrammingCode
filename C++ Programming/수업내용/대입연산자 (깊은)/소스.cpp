#include <iostream>
using namespace std;

/*
	�������Լ�
	1. ��üȭ ��ü, ��ü�� �����͸� ������ ����ó���� �Ҽ� �ְ� ���ִ� �Լ�
	2. operator������ �̸�()
	3. ����Լ��� �ܺ��Լ��� ������ִµ�
		�⺻������ ����Լ��� �������Ѵ�.
		��������°�� �ܺ��Լ��� �����
		����Լ�ó�� �����Ҽ��ִ� friend�� �����Ѵ�.
	4. ������ ������ �ǹ̸� �ٲپ�� �ȵȴ�.
	5. ���ο� �����ڸ� ������ �ʴ´�.

	***�������Լ��� ��������� �Լ��� �����ؿ���

	operator function :
	( ��ü + ��ü ), ( ��ü + data ) �� �����ϱ����ؼ�

*/

class A
{
	int *a;
public:
	A(int a = 0)  {
		this->a = new int;
		*(this -> a) = a;
	}
	~A() { delete a; }

	A(const A&aa) {
		this->a = new int;
		*this->a = *aa.a;
	}

	//void setA(int a) { this->a = a; }
	int getA() { return *a; }

	// ���� ���Կ����� �Լ�
	A& operator= (const A &aa)
	{
		if (this == &aa) return *this;

		*this->a = *aa.a;

		return *this;
	}

	/*
	// ���� ���Կ����� �Լ�
	A& operator= (const A &aa)
	{
		if (this == &aa) return *this;

		this->a = aa.a;

		return *this;
	}
	*/

	/*
	int operator + (const A &bb)
	{
		return this->a + bb.a;
	}
	*/

	//friend int operator+ (const A&aa, const A&bb);
	//friend int operator+ (int aa, const A &bb);

	/*
	//cout << aa + 10 << endl;  // 13

	int operator+ (int b)
	{
		return this->a + b;
	}
	*/

};

/*
//cout << aa+bb << endl;
int operator+ (const A &aa, const A &bb)
{
	return aa.a + bb.a;
}
*/

/*
int operator+ (int aa, const A&bb)
{
	return 10 + bb.a;
}
*/

void main()
{
	A aa(3);
	A bb(4);
	A cc;

	// cout << aa.getA() + bb.getA() << endl;
	//cout << aa+bb << endl;
	// aa + bb;  ->  aa. + (bb);  ->  aa.operator+(bb);  -> operator+(aa, bb);

	cc.operator=( bb.operator=( aa ) );//cc = bb = aa;

	cout << aa.getA() << endl;
	cout << bb.getA() << endl;
	cout << cc.getA() << endl;
	//cout << aa + 10 << endl;  // 13
	//cout << 10 + aa << endl;  // 13
}