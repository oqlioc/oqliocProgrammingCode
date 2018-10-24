#include <iostream>
using namespace std;

void change(int &a, int &b)
{
	int tmp;

	tmp = a;
	a = b;
	b = tmp;
}
void change(char &c, char &d)
{
	char tmp;

	tmp = c;
	c = d;
	d = tmp;
}
void change(float &e, float &f)
{
	float tmp;

	tmp = e;
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