#include <iostream>
using namespace std;

void input(int *a, char *x, int *b)
{
	cout << " ù��° ���� �Է� , ���� �Է�, �ι�° ���� �Է�";
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
