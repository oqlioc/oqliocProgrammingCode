#pragma once
#include <iostream>
#include "main.h"
using namespace std;

Oper::Oper() {
		
		this->num1 = new int;
		this->num2 = new int;
		this->op = new char;
		this->res = new float;

		cout << " ù��° ���� �Է� " ;
		cin >> *num1;

		cout << " ������ �Է� " ;
		cin >> *op;

		cout << " �ι�° ���� �Է� " ;
		cin >> *num2;

}

Oper::Oper(const Oper &t) {  // ���������

		this->num1 = new int;
		this->num2 = new int;
		this->op = new char;
		this->res = new float;

		cout << " ���� ������ ���� �Է�" ;
		cin >> *num1 >> *op >> *num2;

		
		*(this->num1) = *(t.num1);
		*(this->num2) = *(t.num2);
		*(this->op) = *(t.op);
		*(this->res) = *(t.res);
}

Oper::~Oper() { delete num1, 
			delete num2,
			delete res;
			delete op; 
}
	

void Oper::setOper(int num1 = NULL, int num2 = NULL, char op = NULL, float res = NULL) {
		*(this->num1) = num1;
		*(this->num2) = num2;
		*(this->op) = op;
		*(this->res) = res;
}

int Oper::getOper() {
		return *num1;
		return *num2;
		return *op;	
		return (float)*res;
}

void Oper::Operator() {

	switch (*op) {
	case '+' : *res = *num1 + *num2;
		break;
	case '-' : *res = *num1 - *num2;
		break;
	case '*' : *res = *num1 * *num2;
		break;
	case '/' : *res = (float)*num1 / *num2;
		break;
	default : " ERR ";
		break;
	}
}

void Oper::print() {
	cout << " Result : " << *res << endl;
}