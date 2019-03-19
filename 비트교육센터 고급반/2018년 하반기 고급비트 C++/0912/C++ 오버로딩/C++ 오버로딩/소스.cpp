/*
#include <iostream>
using namespace std;

//명시적 오버라이딩
void change(int &a, int &b)
{
	int tmp = a;
	a = b;
	b = tmp;
}

void change(char &c, char &d)
{
	char tmp = c;
	c = d;
	d = tmp;
}

void change(float &e, float &f)
{
	float tmp = e;
	e = f;
	f = tmp;
}

void main()
{
	int a = 10, b = 20;
	char c = 'A', d = 'B';
	float e = 3.7, f = 4.5;

	change(a, b);
	change(c, d);
	change(e, f);

	cout << a << "\t" << b << endl;
	cout << c << "\t" << d << endl;
	cout << e << "\t" << f << endl;
}
*/



#include <iostream>
using namespace std;
/*

명시적 - 기능과 데이터 타입이 달라짐
암시적 - 기능은 똑같고 데이터 값만 바꿀수가 있음.
 생성자
암시적 오버로딩 ( 디폴트 인자값(초기화값) = 사용자가 값을 안주면 기본 인자값으로 사용 )

디폴트 인자값을 준 기준으로 뒤에 있는 매개변수는
무조건 초기화를 해주어야 한다.

디폴트 인자값준 횟수 + 1개 만큼 호출가능
함수선언부에 디폴트 인자값을 사용하고
함수정의부에는 사용을 하면 안된다.

void out(int a = 0, int b = 0); // 이러한 함수 문법을 암시적 오버로딩 이라함.
out(10, 20); / 10 20
out(10); / 10 0
out(); / 0 0


*/

void output(int a = 0, int b = 0, int c = 0); // 함수선언

void main()
{
	int a = 10, b = 20, c = 30;

	output();
	output(a);
	output(a, b);
	output(a, b, c);


}

void output(int a = 0, int b = 0, int c = 0) // 함수정의
{
	cout << a << b << c << endl;
}