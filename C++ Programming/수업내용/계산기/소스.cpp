#include <iostream>
using namespace std;

void input(int *a, char *x, int *b)
{
	cout << " 첫번째 숫자 입력 , 연산 입력, 두번째 숫자 입력";
	cin >> *a >> *x >> *b;
}

void print(float c)
{
	cout << c << endl;
}

void m(int *a, char *x, int *b, float *c)
{

	switch (*x)
	{
	case '+': *c = *a + *b;
		break;
	case '-': *c = *a - *b;
		break;
	case '*': *c = *a * *b;
		break;
	case '/': *c = *a / *b;
		break;
	}
}

void main()
{
	int a = 0, b = 0;
	float c = 0;
	char x;

	input(&a, &x, &b);
	m(&a, &x, &b, &c);

	print(c);
}
