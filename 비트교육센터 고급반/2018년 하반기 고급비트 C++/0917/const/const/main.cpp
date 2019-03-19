#pragma once
#include <iostream>
using namespace std;
// 
/*
const field : �� �ݷ��ʱ�ȭ�� �ؾ���
const method : �޼ҵ峻���� �ʵ��� ���� ��ȣ�ϴ� ����
const object : ��ü �ȿ� �ִ� ������ ��ȣ ����

*/
class A {
	const int a;
	// a�� ���� �ִ� ��� : �ݷ� �ʱ�ȭ
	int b;
public:
	A(int aa) :a(aa), b(aa){ // �ݷ��ʱ�ȭ - const�� ���� �ֱ� ���� ���   ������ ���� ���� �ִ´�.
		//b = aa; / b(aa)
	}

	void setB(int bb) { b = bb; }

	int getA()const {
		return a;
	}

	int getB()const {
		return b;
	}

	int getB() {	// normal object �� �� �޼ҵ带 �Ѵ� �θ����ִ�.  �� ���� �̸��� 2�� �� ��� ���α׷��� �˾Ƽ� �����.
		return 100;
	}
};

void main()
{

	A aa(90);  // const object�� const method�� �θ��� �ִ�.


	cout << aa.getA() << endl;
	cout << aa.getB() << endl;

	int a(30); // int a = 30;
	cout << a << endl;

	aa.setB(89);
	cout << aa.getB() << endl;
	
}