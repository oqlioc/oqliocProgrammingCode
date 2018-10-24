#include <iostream>
#include "Test.h"
using namespace std;

/*
class Test
{
	int a;
public:
	void setA(int a);
	int getA()const;

};

void Test::setA(int a) {
	this->a = a;
}
int Test::getA()const {
	return a;
}
*/

void main()
{
	Test test;

	test.setA(90);
	cout << test.getA() << endl;
}