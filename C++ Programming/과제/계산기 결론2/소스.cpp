#include <iostream>
using namespace std;

class rPtksrl
{
private:
	int *a, *b;
	float *c;
	char *x;

public:

	rPtksrl() {
		this->a = new int;
		this->b = new int;
		this->c = new float;
		this->x = new char;
	};
	~rPtksrl() { delete a, b, c, x; }

	rPtksrl(const rPtksrl &aa) {
		this->a = new int;
		this->b = new int;
		this->c = new float;
		this->x = new char;
		*(this->a) = *(aa.a);
		*(this->b) = *(aa.b);
		*(this->c) = *(aa.c);
		*(this->x) = *(aa.x);
	}

	/*
	int getA()const { return *a; }
	int getB()const { return *b; }
	int getX()const { return *x; }
	*/

	void input()
	{
		cout << " ù��° ���� �Է�" << endl;
		cin >> *a;
		cout << " ���� �Է�" << endl;
		cin >> *x;
		cout << " �ι�° ���� �Է�" << endl;
		cin >> *b;

	}
	void m()
	{
		switch (*x)
		{
		case '+': *c = *a + *b;
			break;
		case '-': *c = *a - *b;
			break;
		case '*': *c = *a * *b;
			break;
		case '/': *c = (float)*a / *b;
			break;
		}
	}
	void print()
	{
		cout << *c << endl;
	}

};

int main()
{
	int a, b;
	float c;
	char x;

	rPtksrl *p = new rPtksrl;

	p->input();
	p->m();
	p->print();
}