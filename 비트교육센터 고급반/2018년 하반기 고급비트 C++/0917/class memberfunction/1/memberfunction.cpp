#pragma once
#include "class.h"

void Test::setA(int a) {   // Test::   setA�� TestŬ���� �Ҽ� (Test::�� �Ⱦ��� �ܺ��Լ��� ó��)
		this->a = a;
}

int Test::getA()const {  // a�� ����Ұ� (getA(a)) a���� �����ʴ��̻�, const�� �ܺ��Լ����� ���Ұ�
		return a;
}
