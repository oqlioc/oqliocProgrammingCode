#include <iostream>
using namespace std;
/*
	접근 지정자
	1. private : 외부에서 접근 불가능
				 단, friend는 접근 가능
	2. default(자바)
	3. protected : 상속받은 외부에서만 접근 가능
	4. public : 아무나 접근 가능


	클래스의 구성요소
	1. 멤버변수, 필드 : 주로 private
		
	2. 생성자 함수 (디폴트) : public
		1) 기능 : 객체등록, 필드초기화
		2) 오버로딩이 가능(명시 암시 둘다 가능)
		3) const memner function로 만들 수 없다.  / const 값 고정 / 파이널 메소드 오버라이딩 금지
		4) 디폴트 생성자를 명시적으로 구현할 경우
		   디폴트 생성자는 사라진다.
		5) 객체 생성시 자동호출되어진다

	3. 멤버함수, 메소드 : public   // 외부함수와 내부함수를 이어주게함
		: 외부에서 필드를 사용하게 하기 위한 기능

	4. 복사생성자 (디폴트)

	5. 소멸자 (디폴트)
		: 객체 소멸시 자동호출되어진다.
		: 객체 등록 해제
		: 객체 소멸시 객체 잔여 메모리 정리
		: 생성자와 동일하지만 함수명앞에 ~(틸드)가 붙는다.
		: 오버로딩이 불가능하다.
		: const member function로 만들 수 없다.
		: virtual 함수로 꼭 만들어서 사용해라. (동적바인딩을 위해서)

	6. 대입연산자함수 (디폴트)

	2,4,5,6번은 default로 존재하기 때문에 항상 존재함





*/


/*
	this pointer
	: 메소드의 첫번째 매개변수로 선언
*/
class Obj
{
private:
	int a;
	// class 는 디폴트 시 private 으로 메인함수에 접근할 수 없음
	// 디폴트 생성자

public:
//	Obj() { cout << "생성자야" << endl; }
	
	//Obj() { this->a = 0; }
	
	// 동적 할당
	Obj(int a = 0) {
		this->a = a;
	}
	
	~Obj() { cout << "소멸자" << endl; } // 소멸자 함수    , 내가 사용할려고 호출했으므로 디폴트 해제

	void setA(int a){ // void setA(Obj *this, int a)
		this->a = a;
	}

	int getA() {
		return a;
	}
	// 디폴트 복사 생성자
	// 소멸자 함수
	// 대입연산자함수


};

void main()  // 외부 함수
{
	Obj obj(100); // 객체 선언 => 생성자 호출
	Obj obj2;
//	obj.setA(100);
	cout << obj.getA() << endl;
	cout << obj2.getA() << endl;

	Obj *p = new Obj; // 동적 메모리
	delete p; // 동적 메모리 호출 후 삭제 시 소멸자 호출
/*
//	int *p = (int *)malloc(sizeof(int));
//	 = int *p = new int;


//	Obj *obj2 = (Obj*)calloc(1, sizeof(Obj)); 
	Obj *obj2 = new Obj;

	delete obj2;

	// int *p1 = new int[4];
	// delete p1; 하면 int[0]만 지움
	// delete []p1;  해야 배열이 다 지워짐   */
}//소멸자 호출