#include <iostream>
using namespace std;

/*
	템블릿 : 기능은 같고 데이터 타입이 다를경우
			하나로 여러개를 만족시켜주는 형대 (다형성)
	1. 템플릿 함수
	2. 템플릿 클래스
*/

/*
void change(int &a, int &b)
{
	int tmp;
	tmp = a;
	a = b;
	b = tmp;
}

void change(float &a, float &b)
{
	float tmp;
	tmp = a;
	a = b;
	b = tmp;
}

void change(char &a, char &b)
{
	char tmp;
	tmp = a;
	a = b;
	b = tmp;
}
*/
template<typename T>
void change(T &a, T &b)
{
	T tmp;
	tmp = a;
	a = b;
	b = tmp;
}

void main()
{
	int a = 3, b = 4;
	float c = 3.4f, d = 4.7f;
	char e = 'A', f = 'B';

	change(a, b);
	cout << a << "\t" << b << endl;

	change(c, d);
	cout << c << "\t" << d << endl;

	change(e, f);
	cout << e << "\t" << f << endl;
}