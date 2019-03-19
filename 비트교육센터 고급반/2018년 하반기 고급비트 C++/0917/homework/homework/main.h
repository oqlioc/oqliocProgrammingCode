#pragma once
#include <iostream>
using namespace std;

class Oper{

	int *num1;
	int *num2;
	float *res;
	char *op;

public:

	Oper();

	Oper(const Oper &t);

	~Oper();
	
	void setOper(int num1, int num2, char op, float res);

	int getOper();

	void Operator();

	void print();

};
