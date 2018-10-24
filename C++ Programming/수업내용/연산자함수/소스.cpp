#include <iostream>
using namespace std;
/*
	operator function : 
	( °´Ã¼ + °´Ã¼ ), ( °´Ã¼ + data ) ¸¦ ±¸ÇöÇÏ±âÀ§ÇØ¼­

*/

class A
{
	int a;
public:
	A(int num) : a(num) {}
	void setA(int a) { this->a = a; }
	int getA() { return a; }

	/*
	int operator + (const A &bb)
	{
		return this->a + bb.a;
	}
	*/
	//friend int operator+ (const A&aa, const A&bb);
	friend int operator+ (int aa, const A &bb);
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

int operator+ (int aa, const A&bb)
{
	return 10 + bb.a;
}

void main()
{
	A aa(3);
	A bb(4);

	// cout << aa.getA() + bb.getA() << endl;
	//cout << aa+bb << endl;
	// aa + bb;  ->  aa. + (bb);  ->  aa.operator+(bb);  -> operator+(aa, bb);

	//cout << aa + 10 << endl;  // 13
	cout << 10 + aa << endl;  // 13
}