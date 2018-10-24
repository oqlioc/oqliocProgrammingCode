#include <iostream>
#include <stdio.h>
using namespace std;
/*
	접근지정자
	1. private : 외부에서 접근 불가능
				단, friend는 접근 가능
	2. protected : 상속받은 외부에서만 접근가능
	3. public : 아무나

	클래스의 구성요소
	1. 멤버변수, 필드 : 주로 private
	    
	2. 생성자함수  (디폴트 존재) : 주로 public
		1) 기능 : 객체등록, 필드초기화
		2) 오버로딩이 가능
		3) const member function로 만들수없다.
		4) 디폴트생성자를 명시적으로 구현할경우
		   디폴트생성자는 사라진다.
		5) 객체 생성시 자동호출되어진다.

	3. 멤버함수, 메소드 : public
		: 외부에서 필드를 사용하게 하기 위한 기능

	4. 복사생성자  (디폴트 존재) : 
	5. 소멸자  (디폴트 존재)
		1) 객체 소멸시 자동호출된다.
		2) 객체 등록 해제
		3) 객체 소명시 객체 잔여메모리 정리
		4) 생성자와 동일하지만 함수명앞에 ~(틸드)가 붙는다.
		5) 오버로딩이 불가능하다.
		6) const member function로 만들수 없다.
		7) virtual 함수로 꼭 만들어서 사용해라. (동적바인딩을 위해서)

	6. 대입연산자함수  (디폴트 존재) : 

*/
/*
	this pointer
	: 메소드의 첫번째 매개변수로 선언
*/
class Obj
{
private:
	int a;
	// 디폴드 생성자
public:
	// Obj() { this->a = 0; }
	Obj(int a = 0) {  // 생성자함수
		this -> a = a;
	}
	~Obj() { cout << "소멸자" << endl; } // 소멸자함수

	void setA(int a)  // void setA(Obj *this, int a)
	{
		this -> a = a;
	}
	int getA() {
		return a;
	}

	// 디폴트 복사생성자
	// 소멸자함수
	// 대입연산자함수
};

void main()  //외부함수
{
	// Obj *obj;   객체선언 => 생성자호출
	// Obj *obj1 = new Obj;   // (Obj*)malloc(sizeof(Obj));
	// Obj *obj2 = new Obj[4];

	Obj *p = new Obj;

	delete p;



	// delete obj1;
	// delete []obj2;


}// 소멸자호출