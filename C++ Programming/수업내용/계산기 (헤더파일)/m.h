#pragma once

using namespace std;

void m(int &a, char &x, int &b, float &c)
{

	switch (x)
	{
	case '+': c = a + b;
		break;
	case '-': c = a - b;
		break;
	case '*': c = a * b;
		break;
	case '/': c = (float)a / b;
		break;
	}
}