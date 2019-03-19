#include <iostream>
using namespace std; // std �̸��� ���̺귯���� �ִ� ��� �Լ����� ���� �ҽ� �������� �����´�.

namespace A {
   void name() {
      std::cout << "A�� name()�� ȣ��!" << std::endl; //using namespace std �� ���Ǿ��ߴٴ� ����
   }	

   void score() {
	   cout << "A�� score()�� ȣ��!" << endl;
   }
}

namespace B {
   void name() {
      cout << "B�� name()�� ȣ��!" << std::endl;			// using std::cout�� �����ϸ� cin�� endl��
															// std::cin , std::endl �� ����ؾ���
   }

   void score() {
	   cout << "B�� score()�� ȣ��!" << endl;
   }
}

using namespace A;  // �Լ��� ���� �Ͽ����� �̸��� A�� ���̺귯�� ������ �Լ� ���Ǹ� ���

void main()
{
   A::name();  // �Լ� A���� ������ name�� ����
   B::name();  // �Լ� B���� ������ name�� ����

   name();  // A�� B�߿� using namespace A(�Լ� A�� ���Ǹ� ����ϰڴ�.)�� ���� A �Լ��� ȣ�� 

   using B::score; // �Լ� B�� score�� ����
   score();
}
