#include <iostream>
using namespace std;

/*
	�ۺ� : ����� ���� ������ Ÿ���� �ٸ����
			�ϳ��� �������� ���������ִ� ���� (������)
	1. ���ø� �Լ�
	2. ���ø� Ŭ����
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