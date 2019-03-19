#include <iostream>
using namespace std;
/*
	operator function // 멤버함수, 외부함수 창조가능
					  // 객체 + 객체, 객체 + 데이터 등 연산처리를 할 수 있게 해줌
	:

*/
class A {

	int a;
public:

	A(int num) :a(num) {}
	void setA(int a) { this->a = a; }
	int getA()const { return a; }

	/*int operator+(const A &bb) {
		return this->a + bb.a;
	};*/
	
	int operator+(int num) {
		return this->a + num;
	};

	//friend int operator+(const A &aa, const A &bb);
	friend int operator+(int num, const A &aa);
};

/*
int operator+(const A &aa, const A &bb)
{
	//return aa.getA() + bb.getA();
	//return aa.a + bb.a;
}
*/

int operator+(int num, const A &aa) {

	
	return num + aa.a;
}

void main()
{

	A aa(3);
	A bb(4);

	//cout << aa.getA() + bb.getA() << endl;
	//cout << aa + bb << endl;  // aa.operator+(bb);  operator+(aa, bb);

	cout << aa + 10 << endl;  // 13;
	cout << 10 + aa << endl;

}