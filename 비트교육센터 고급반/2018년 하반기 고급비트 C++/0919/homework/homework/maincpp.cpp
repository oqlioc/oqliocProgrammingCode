#include <iostream>
#include <string>
using namespace std;

class A {
	int a;
public:
	A(int aa = 0) :a(aa) { 
	}


	void setA(int a) { this->a = a; }
	int getA()const { return a; }

	friend ostream& operator<<(ostream &out, A &aa);
	friend istream& operator>>(istream &out, A &aa);

};

ostream& operator<<(ostream &out, A &aa)
{

	out << aa.a;
	return out;
}

istream& operator>>(istream &in, A &aa)
{

	in >> aa.a;
	return in;
}

void main()
{
	A aa(100);
	A bb;

	//cout << aa;  // cout.operator << (aa); ==> 불가능 하다. 
				 // operator<<(cout, aa);

	//cout << bb;

	cout << aa << bb;
	cin >> aa >> bb;
	cout << aa << bb;
}

