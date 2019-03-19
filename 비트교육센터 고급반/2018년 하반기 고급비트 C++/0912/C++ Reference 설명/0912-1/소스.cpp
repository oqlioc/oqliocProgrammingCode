#include <iostream>
using namespace std;

/*

/*
C++ . 레퍼런스 - 참조 할 시 변경할 수 없음 / 매크로와 const를 합쳐놓음
    .  nickname 
	   선언과 동시에 닉을 부여한다.
	   이유는 한번 참조하면 바꿀수 없기 때문
& -> 변수의 주소
* -> 그 주소에 있는 값을 이용

// 레퍼런스
void main()
{
	int a = 10;
	int b = 20;

	int &aa = a; // reference variable   선언과 동시에 닉네임을 부여해야함

	cout << a << "\t" << b << "\t" << aa << endl;
	cout << &a << "\t" << &b << "\t" << &aa << endl;

	aa = 500;
	cout << a << "\t" << b << "\t" << aa << endl;

	aa = b;  // b가 가지고 있는 값을 넣는다.   &aa = a 변경 불가
	cout << a << "\t" << b << "\t" << aa << endl;

}
*/


/*
// 콜 바이 레퍼런스
void input(int &a);
void disp(int a);

void main()
{
	int a = 10;

	input(a);
	disp(a);
}

void input(int &a)
{
	a = 100;
}

void disp(int a)
{
	cout << a << endl;
}
*/



