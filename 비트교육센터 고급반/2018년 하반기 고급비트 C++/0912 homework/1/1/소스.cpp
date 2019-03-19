#include <iostream>
using namespace std; // std 이름의 라이브러리에 있는 모든 함수명을 현재 소스 범위내에 가져온다.

namespace A {
   void name() {
      std::cout << "A의 name()을 호출!" << std::endl; //using namespace std 를 정의안했다는 가정
   }	

   void score() {
	   cout << "A의 score()를 호출!" << endl;
   }
}

namespace B {
   void name() {
      cout << "B의 name()을 호출!" << std::endl;			// using std::cout만 정의하면 cin과 endl을
															// std::cin , std::endl 로 사용해야함
   }

   void score() {
	   cout << "B의 score()를 호출!" << endl;
   }
}

using namespace A;  // 함수를 선언 하였을때 이름이 A인 라이브러리 내부의 함수 정의를 사용

void main()
{
   A::name();  // 함수 A에서 선언한 name가 실행
   B::name();  // 함수 B에서 선언한 name가 실행

   name();  // A와 B중에 using namespace A(함수 A의 정의를 사용하겠다.)로 인해 A 함수로 호출 

   using B::score; // 함수 B의 score가 실행
   score();
}
