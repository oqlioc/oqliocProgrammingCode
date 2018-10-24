#include <iostream>
using namespace std;

/*
얕은 복사(필드 포인트 X)

복사생성자 호출시기
	1. 객체 생성시 객체를 인자로 줄 경우
	2. 객체 생성시 객체를 대입 할 경우
	3. 메소드의 매개변수로 객체를 선언 할 경우
	4. 메소드에서 개체를 리턴 할 경우

	객체를 생성한 시점에 필드전체를 복사할려고

*/
class A
{
	int a;
public:
	//생성자
	A(int a = 0) {
		this->a = a;
	}

	//소멸자
	//복사생성자
	A(A &aa) {
		this->a = aa.a;
	}

	//대입연산자함수
	int getA()const { return a; }

};

void main()
{
	A aa(90);
	cout << aa.getA() << endl;

	A bb(aa);  // 복사생성자함수 호출
	cout << bb.getA() << endl;
}