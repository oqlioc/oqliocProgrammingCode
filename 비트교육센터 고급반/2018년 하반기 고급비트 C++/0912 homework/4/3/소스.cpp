#include <iostream>
using namespace std;


class Oper {

private:
	int *num1;
	int *num2;
	float *res;
	int fournum;

public:
	Oper(){ this->num1 = num1,
			this->num2 = num2, 
			this->res = res,
			this->fournum = fournum; }
		
	void scan(int *num1, int *num2) {  
		cout << " 정수 입력 ";
		cin >> *num1 >> *num2;
	}

	void fouroper(int *num1, int *num2, float *res) {
		cout << " 1 : +  ||  2 : -  ||  3 : *  ||  4 : /  ||";
		cin >> fournum;
    
		switch(fournum) {
			case 1 : *res = *num1 + *num2;
				break;
			case 2 : *res = *num1 - *num2;
				break;
			case 3 : *res = *num1 * *num2;
				break;
			case 4 : *res = (float)*num1 / *num2;
				break;
			default : " ERR ";
				break;
		}
	}

	void print(float *res) {
		cout << *res << endl;
	}
};

void main()
{
	int num1, num2;
	float res;

	Oper *p = new Oper;
	
	p -> scan(&num1, &num2);
	p -> fouroper(&num1, &num2, &res);
	p -> print(&res);
}
