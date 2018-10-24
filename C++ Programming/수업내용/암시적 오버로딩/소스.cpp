#include <iostream>
#include <stdio.h>
using namespace std;
/*
	암시적 오버로딩( 디폴트인자값 )
	:디폴트 인자값을 준 기준으로 뒤에 있는 매개변수는
	무족건 초기화를 해주어야한다.

	디폴트인자값 갯수 + 1개 만큼 호출가능
	함수선언부에 디폴트인자값을 사용하고
	함수정의부에는 사용을 하면 안된다.
*/
void output(int a = 0, int b = 0, int c = 0); //함수선언

void main()
{
	int a = 10;
	int b = 20;
	int c = 30;

	output();
	output(a);
	output(a, b);
	output(a, b, c);

}

void output(int a, int b, int c) // 함수 정의
{
	cout << a << b << c << endl;
}