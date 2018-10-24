#include <iostream>
#include "input.h"
#include "print.h"
#include "m.h"
using namespace std;

void main()
{
	int a = 0, b = 0;
	float c = 0;
	char x;

	input(a, x, b);
	m(a, x, b, c);

	print(c);
}