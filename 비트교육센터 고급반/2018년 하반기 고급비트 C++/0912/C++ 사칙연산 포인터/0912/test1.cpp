#include <iostream>
using namespace std;
/*
int sum(int a, int b)
{
	int c = a + b;
	return c;
}

int minus(int a, int b)
{
	int c = a - b;
	return c;
}

int gob(int a, int b)
{
	int c = a * b;
	return c;
}

int nan(int a, int b)
{
	int c = a / b;
	return c;
}

int nam(int a, int b)
{
	int c = a % b;
	return c;
}
*/

void scan(int *a, int *b)
{
	cout << " 정수 입력 ";
	cin >> *a >> *b;
}

void print(float a)
{
	cout << a << endl;
}

void fouroper(int a, int b, float *res)
{
	int fournum;
	cout << " 1 : +  ||  2 : -  ||  3 : *  ||  4 : /  ||";
	cin >> fournum;
	
	switch(fournum)
	{
	case 1 : *res = a + b;
		break;
	case 2 : *res = a - b;
		break;
	case 3 : *res = a * b;
		break;
	case 4 : *res = (float)a / b;
		break;

	default : " ERR ";
		break;
	}
}

void main()
{
	int num1 = 0, num2 = 0;
	float res;

	scan(&num1, &num2);
	fouroper(num1, num2, &res);

	/*
	c = sum(num1, num2);
	d = minus(num1, num2);
	e = gob(num1, num2);
	f = nan(num1, num2);
	g = nam(num1, num2);
	*/

	print(res);
//	print(d);
//	print(e);
//	print(f);
//	print(g);
	
}