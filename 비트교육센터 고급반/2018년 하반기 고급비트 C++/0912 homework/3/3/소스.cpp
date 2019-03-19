#include <iostream>
using namespace std;


class Oper {

private:
	int num1;
	int num2;
	float res;
	int fournum;

public:
	

	Oper() {   // 생성자
		cout << " 정수 입력 ";
		cin >> num1 >> num2;
	}

	void fouroper() {   // 메소드
		cout << " 1 : +  ||  2 : -  ||  3 : *  ||  4 : /  ||";
		cin >> fournum;
    
		switch(fournum) {
			case 1 : res = num1 + num2;
				break;
			case 2 : res = num1 - num2;
				break;
			case 3 : res = num1 * num2;
				break;
			case 4 : res = (float)num1 / num2;
				break;

			default : cout << " ERR " << endl;
				break;
		}
	}

	void print() {  // 메소드
		cout << res << endl;
	}
};

void main()
{
	
	Oper *p = new Oper;

	p -> fouroper();
	p -> print();
}
