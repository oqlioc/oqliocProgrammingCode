#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)
#include <iostream>
#include<string>
#include <cstring>
using namespace std;

class Mystring
{
	char *str;
	int len;
public:
	Mystring() {
		this->str = new char;
		len = 0;
	}
	~Mystring() { delete str; }

	Mystring(const char *a) {
		len = strlen(a) + 1;
		this-> str = new char[len];
		strcpy(this->str, a);
	}

	Mystring(int num, char a) {
		this->len = num + 1;
		str = new char[this->len];
		for (int i = 0; i < num; i++) {
			str[i] = a;
		}
		str[num] = NULL;
	}

	Mystring(const Mystring& a) {
		this->len = a.len;
		this->str = new char[len];
		strcpy(this->str, a.str);
	}
	
	Mystring& operator+=(const Mystring &a) {
		char *cpy;
		cpy = new char[strlen(this->str) + 1];
		strcpy(cpy, this->str);

		len = strlen(this->str) + strlen(a.str) + 1;
		this->str = new char[len];

		strcpy(this->str, strcat(cpy, a.str));
		str[len - 1] = NULL;
		return *this;
	}

	Mystring& operator=(const Mystring &a) {
		delete this->str;

		len = strlen(a.str) + 1;
		str = new char[len];
		strcpy(str, a.str);

		return *this;
	}
	/*
	Mystring& operator=(const char *a) {
		len = strlen(a) + 1;

		str = new char[len];
		strcpy(str, a);

		return *this;
	}*/
	char& operator[](int num) {
		
		return str[num];
	}


	Mystring& operator+(const Mystring &a) {
		char *cpy;
		cpy = new char[strlen(this->str) + 1];
		strcpy(cpy, this->str);

		len = strlen(this->str) + strlen(a.str) + 1;
		this->str = new char[len];

		strcpy(this->str, strcat(cpy, a.str));
		str[len - 1] = NULL;
		return *this;
	}

	Mystring(const Mystring &a, int b) {
		
		this->len = b + 1;
		this->str = new char[this->len];

		for (int i = 0; i < b; i++) {
			str[i] = a.str[i];
		}

		str[b - 1] = NULL;

	}

	Mystring(const Mystring &str6, const Mystring &str10) {
	
		this->len = strlen(str6.str) + 1;
		this->str = new char[this->len];
		strcpy(this->str, str6.str);
		str[strlen(str6.str) - strlen(str10.str)] = NULL;
	}
	
	Mystring(const char *five6, const char *five10) {

		this->len = strlen(five6) + 1;
		this->str = new char[this->len];
		strcpy(this->str, five6);
		str[strlen(five6) - strlen(five10)] = NULL;
	}


	//cout << " 입력한 문자열은 \"" << eight << "\" 입니다 " << endl;



	friend ostream& operator<< (ostream &out, const Mystring &a);
	friend istream& operator>> (istream &in, Mystring &a);
};



ostream& operator<< (ostream &out, const Mystring &a)
{
	out << a.str;

	return out;
}

istream& operator>> (istream &in, Mystring &a)
{
	a.len = strlen(a.str) + 1;
	a.str = new char[a.len];
	
	a.str[a.len - 1] = NULL;
	in >> a.str;

	return in;
}

void main()
{
	Mystring one("lottery winner!");//생성자함수호출
	cout << one << endl;  //출력연산자함수호출

	Mystring two(20, '$');//생성자함수호출
	cout << two << endl;//출력연산자함수호출

	Mystring three(one); // 복사생성자호출
	cout << three << endl; //출력연산자함수호출

	one += "oops"; // +=연산자함수호출 ( strcat함수 )
	cout << one << endl;//문자열결합 

	two = "sorry!that was";//대입연산자함수 호출 
	cout << two << endl;

	three[0] = 'p';//[]첨자연산자함수 호출 
	cout << three << endl;

	Mystring four;
	four = two + three;
	cout << four << endl;

	char alls[] = "all's well that ends well";
	Mystring five(alls, 20); //생성자호출
	cout << five << "!\n";


	Mystring six(alls + 6, alls + 10);  //생성자
	cout << six << ",";


	Mystring seven(&five[6], &five[10]);  //생성자
	cout << seven << "...\n";
	
	
	Mystring eight;
	cout << "문자열 입력하세요 :";
	
	cin >> eight;  // >>연산자호출
	cout << " 입력한 문자열은 \"" << eight << "\" 입니다 " << endl;

}