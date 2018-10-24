#include <iostream>
using namespace std;
/*
const field : 꼭 콜론초기화를 해야한다
const method : 메소드내에서 필드의 값을 보호하는 목적
const Object : 객체 안에 있는 데이터 보호 목적

const Object는 const method만이 호출가능
*/
class A
{
	const int a;
	int b;
public:
	A(int aa) :a(aa), b(aa){
		//b= aa;
	}
	void setB(int bb) { b = bb; }

	int getA()const {
		return a;
	}
	int getB()const { // const Object일경우 우선
		return b;
	}
	int getB() {      // 일반 Object일경우 우선
		return b;
	}
};
void main()
{
	const A aa(80);
	// aa.setB(89);

	cout << aa.getA() << endl;
	cout << aa.getB() << endl;

	
}