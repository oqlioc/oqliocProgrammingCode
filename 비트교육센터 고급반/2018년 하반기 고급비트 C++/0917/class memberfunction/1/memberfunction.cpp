#pragma once
#include "class.h"

void Test::setA(int a) {   // Test::   setA는 Test클래스 소속 (Test::를 안쓰면 외부함수로 처리)
		this->a = a;
}

int Test::getA()const {  // a값 변경불가 (getA(a)) a값을 넣지않는이상, const는 외부함수에서 사용불가
		return a;
}
