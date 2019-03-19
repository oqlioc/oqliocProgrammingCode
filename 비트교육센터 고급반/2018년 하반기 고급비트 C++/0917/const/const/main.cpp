#pragma once
#include <iostream>
using namespace std;
// 
/*
const field : 꼭 콜론초기화를 해야함
const method : 메소드내에서 필드의 값을 보호하는 목적
const object : 객체 안에 있는 데이터 보호 목적

*/
class A {
	const int a;
	// a에 값을 넣는 방법 : 콜론 초기화
	int b;
public:
	A(int aa) :a(aa), b(aa){ // 콜론초기화 - const에 값을 넣기 위한 방법   생성자 생성 전에 넣는다.
		//b = aa; / b(aa)
	}

	void setB(int bb) { b = bb; }

	int getA()const {
		return a;
	}

	int getB()const {
		return b;
	}

	int getB() {	// normal object 는 두 메소드를 둘다 부를수있다.  단 같은 이름이 2개 일 경우 프로그램이 알아서 사용함.
		return 100;
	}
};

void main()
{

	A aa(90);  // const object는 const method만 부를수 있다.


	cout << aa.getA() << endl;
	cout << aa.getB() << endl;

	int a(30); // int a = 30;
	cout << a << endl;

	aa.setB(89);
	cout << aa.getB() << endl;
	
}