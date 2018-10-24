#include <iostream>
using namespace std;

/*
	연사자함수
	1. 객체화 객체, 객체와 데이터를 가지고 연산처리를 할수 있게 해주는 함수
	2. operator연산자 이름()
	3. 멤버함수와 외부함수를 만들수있는데
		기본적으로 멤버함수로 만들어야한다.
		만들수없는경우 외부함수로 만들되
		멤버함수처럼 접근할수있는 friend로 제공한다.
	4. 연산자 본연의 의미를 바꾸어서는 안된다.
	5. 새로운 연산자를 만들지 않는다.

	***연산자함수로 만들수없는 함수를 조사해오기

	operator function :
	( 객체 + 객체 ), ( 객체 + data ) 를 구현하기위해서

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

	// 깊은 대입연산자 함수
	A& operator= (const A &aa)
	{
		if (this == &aa) return *this;

		*this->a = *aa.a;

		return *this;
	}

	/*
	// 얕은 대입연산자 함수
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