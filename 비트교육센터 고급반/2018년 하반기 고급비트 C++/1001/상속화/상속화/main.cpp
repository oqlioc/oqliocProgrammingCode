#include <iostream>
#include <string>
#include <cstring>
#pragma warning(disable:4996)
using namespace std;

/*

	��� -> �ڵ��� ��Ȱ��, ��������
	: �θ�Ŭ���� : �ڽ��� ����� ������ ������ �ִ�.
	: �ڽ�Ŭ���� : �ڽŸ��� ������ ����� �߰��� �ϸ�ȴ�.

	1. ��ӹ��
		1)private ���		: has ~ a	// JAVA���� �����
		  => �θ��� ����� ��� �ڽ����� ��ӵ����� private���� �ٲ۴�.

		2)protected ���	: has ~ a	// JAVA���� �����
		  => �θ��� public ����� protected�� �ٲ� ���

		3)public ���		: is ~ a
		  => �ִ� �״�� ����� �ȴ�. 
*/

//private
/*
class A {

	int a1;

protected:
	int b1;

public:
	int c1;

	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}
};


class B: A{
	int a1, b1, c1;
	int a2;

protected:
	int b2;

public:
	//int a1,b1,c1;
	int c2;

	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		this->a2 = num;
	}

	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}
};


class C: B {
	int a1, b1, c1, a2, b2, c2;
	int a3;

protected:
	int b3;

public:
	//int a1,b1,c1,a2;
	int c3;
	
	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		this->a2 = num;
	}

	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}

	void setA3(int num) {
		this->a3 = num;
	}

	void setB3(int num) {
		this->b3 = num;
	}
	
	void setC3(int num) {
		this->c3 = num;
	}

	int getA3()const {
		return a3;
	}
	
	int getB3()const {
		return b3;
	}
	
	int getC3()const {
		return c3;
	}
};

void main()
{
	C cc;
	
	cc.setA1(1);
	cc.setB1(2);
	cc.setC1(3);

	cc.setA2(4);
	cc.setB2(5);
	cc.setC2(6);
	
	cc.setA3(7);
	cc.setB3(8);
	cc.c3 = 9;


	cout << cc.getA1() << endl;
	cout << cc.getB1() << endl;
	cout << cc.getC1() << endl;
	
	cout << cc.getA2() << endl;
	cout << cc.getB2() << endl;
	cout << cc.getC2() << endl;
	
	cout << cc.getA3() << endl;
	cout << cc.getB3() << endl;
	cout << cc.getC3() << endl;
}
*/


//protected
/*
class A {

	int a1;

protected:
	int b1;

public:
	int c1;

	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}
};


class B: protected A{
	int a1;
	int a2;

protected:
	int b2;

public:
	int c2;

	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		this->a2 = num;
	}

	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}
};


class C: protected B {
	int a1, a2;
	int a3;

protected:
	int b3;

public:
	int c3;
	
	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		this->a2 = num;
	}

	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}

	void setA3(int num) {
		this->a3 = num;
	}

	void setB3(int num) {
		this->b3 = num;
	}
	
	void setC3(int num) {
		this->c3 = num;
	}

	int getA3()const {
		return a3;
	}
	
	int getB3()const {
		return b3;
	}
	
	int getC3()const {
		return c3;
	}
};

void main()
{
	C cc;
	
	cc.setA1(1);
	cc.setB1(2);
	cc.setC1(3);

	cc.setA2(4);
	cc.setB2(5);
	cc.setC2(6);
	
	cc.setA3(7);
	cc.setB3(8);
	cc.c3 = 9;


	cout << cc.getA1() << endl;
	cout << cc.getB1() << endl;
	cout << cc.getC1() << endl;
	
	cout << cc.getA2() << endl;
	cout << cc.getB2() << endl;
	cout << cc.getC2() << endl;
	
	cout << cc.getA3() << endl;
	cout << cc.getB3() << endl;
	cout << cc.getC3() << endl;
}
*/


	
//public
/*
class A {

	int a1;

protected:
	int b1;

public:
	int c1;

	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}
};

class B: public A{
	int a1;
	int a2;

protected:
	int b2;

public:
	//int a1,b1,c1;
	int c2;

	void setA1(int num) {
		this->a1 = num; // A::setA1(num);
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;  // return A::getA1();
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		this->a2 = num;
	}

	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}
};


class C: public B {
	int a1, a2;
	int a3;

protected:
	int b3;

public:
	//int a1,b1,c1,a2;
	int c3;
	
	void setA1(int num) {
		this->a1 = num;  // B::setA1(num);
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;  // return B::getA1();
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		this->a2 = num;
	}

	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}

	void setA3(int num) {
		this->a3 = num;
	}

	void setB3(int num) {
		this->b3 = num;
	}
	
	void setC3(int num) {
		this->c3 = num;
	}

	int getA3()const {
		return a3;
	}
	
	int getB3()const {
		return b3;
	}
	
	int getC3()const {
		return c3;
	}
};

void main()
{
	C cc;
	
	cc.setA1(1);
	cc.setB1(2);
	cc.c1 = 3;

	cc.setA2(4);
	cc.setB2(5);
	cc.c2= 6;
	
	cc.setA3(7);
	cc.setB3(8);
	cc.c3 = 9;


	cout << cc.getA1() << endl;
	cout << cc.getB1() << endl;
	cout << cc.getC1() << endl;
	
	cout << cc.getA2() << endl;
	cout << cc.getB2() << endl;
	cout << cc.getC2() << endl;
	
	cout << cc.getA3() << endl;
	cout << cc.getB3() << endl;
	cout << cc.getC3() << endl;
}
*/



	class A {

	int a1;

protected:
	int b1;

public:
	int c1;

	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}
};


class B: A{
	int a2;

protected:
	int b2;

public:
	int c2;

	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		setA1(num);
	}


	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}
};


class C: B {
	int a3;

protected:
	int b3;

public:
	int c3;
	
	void setA1(int num) {
		this->a1 = num;
	}

	void setB1(int num) {
		this->b1 = num;
	}
	
	void setC1(int num) {
		this->c1 = num;
	}

	int getA1()const {
		return a1;
	}
	
	int getB1()const {
		return b1;
	}
	
	int getC1()const {
		return c1;
	}

	void setA2(int num) {
		this->a2 = num;
	}

	void setB2(int num) {
		this->b2 = num;
	}
	
	void setC2(int num) {
		this->c2 = num;
	}

	int getA2()const {
		return a2;
	}
	
	int getB2()const {
		return b2;
	}
	
	int getC2()const {
		return c2;
	}

	void setA3(int num) {
		this->a3 = num;
	}

	void setB3(int num) {
		this->b3 = num;
	}
	
	void setC3(int num) {
		this->c3 = num;
	}

	int getA3()const {
		return a3;
	}
	
	int getB3()const {
		return b3;
	}
	
	int getC3()const {
		return c3;
	}
};

void main()
{
	C cc;
	
	cc.setA1(1);
	cc.setB1(2);
	cc.setC1(3);

	cc.setA2(4);
	cc.setB2(5);
	cc.setC2(6);
	
	cc.setA3(7);
	cc.setB3(8);
	cc.c3 = 9;


	cout << cc.getA1() << endl;
	cout << cc.getB1() << endl;
	cout << cc.getC1() << endl;
	
	cout << cc.getA2() << endl;
	cout << cc.getB2() << endl;
	cout << cc.getC2() << endl;
	
	cout << cc.getA3() << endl;
	cout << cc.getB3() << endl;
	cout << cc.getC3() << endl;
}