#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)
#include <iostream>
#include<string>
#include <cstring>
using namespace std;

class Mystring
{
	char *strr;
	int len;
public:
	Mystring() {
		this->strr = new char;
		/*len = 1;
		this->strr = new char[len];
		strr[0] = NULL;*/
		//len = 0;
	}

	Mystring(const char *str) {		// one
		len = strlen(str) + 1;
		this-> strr = new char[len];
		strcpy(this->strr, str);
	}

	Mystring(int num, char str) {		// two
		this->len = num + 1;
		strr = new char[this->len];
		for (int i = 0; i < num; i++) {
			strr[i] = str;
		}
		strr[num] = NULL;
	}

	Mystring(const Mystring& str) {		// three
		this->len = str.len;
		this->strr = new char[len];
		strcpy(this->strr, str.strr);
	}

	Mystring& operator+=(const Mystring &str) {		// one +=
		char *temp;
		temp = new char[strlen(this->strr) + 1];
		strcpy(temp, this->strr);

		len = strlen(this->strr) + strlen(str.strr) + 1;
		this->strr = new char[len];

		strcpy(this->strr, strcat(temp, str.strr));
		strr[len - 1] = NULL;
		return *this;
	}

	Mystring& operator=(const Mystring &str) {		// two =
		delete this->strr;

		len = strlen(str.strr) + 1;

		strr = new char[len];
		strcpy(strr, str.strr);

		return *this;
	}
	/*
	Mystring& operator=(const char *a) {
	len = strlen(a) + 1;

	str = new char[len];
	strcpy(str, a);

	return *this;
	}*/
	char& operator[](int num) {				// three []
		return strr[num];
	}
	/*
	Mystring operator+(const Mystring &str) {		// four +

	len = strlen(this->strr) + strlen(str.strr) + 1;
	char *copy;
	copy = new char[len];

	strcpy(copy, this->strr);
	strcat(copy, str.strr);

	return copy;
	}
	*/
	Mystring& operator+(const Mystring &str) {		// four +
		char *temp;
		temp = new char[strlen(this->strr) + 1];
		strcpy(temp, this->strr);

		len = strlen(this->strr) + strlen(str.strr) + 1;
		this->strr = new char[len];

		strcpy(this->strr, strcat(temp, str.strr));
		strr[len - 1] = NULL;
		return *this;
	}

	Mystring(const Mystring& str, int num) {		// five char alls[]

		this->len = num + 1;
		this->strr = new char[this->len];
		/*
		for (int i = 0; i < b; i++) {
		strr[i] = str.strr[i];
		}
		*/
		strncpy(this->strr, str.strr, num);
		strr[num - 1] = NULL;

	}

	Mystring(const Mystring& str6, const Mystring& str10) {		// six char alls+6, all+10
		this->len = strlen(str6.strr) + 1;
		this->strr = new char[this->len];
		strcpy(this->strr, str6.strr);
		strr[strlen(str6.strr) - strlen(str10.strr)] = NULL;
	}

	Mystring(const char *str6, const char *str10) {		// seven char alls[6], alls[10]

		this->len = strlen(str6) + 1;
		this->strr = new char[this->len];
		strcpy(this->strr, str6);
		strr[strlen(str6) - strlen(str10)] = NULL;
	}

	~Mystring() { delete[] strr; }

	friend ostream& operator<< (ostream &out, const Mystring &str);
	friend istream& operator>> (istream &in, Mystring &str);
};



ostream& operator<< (ostream &out, const Mystring &str)
{
	out << str.strr;

	return out;
}

istream& operator>> (istream &in, Mystring &str)
{

	str.strr = new char[BUFSIZ];
	in >> str.strr;
	return in;

	delete in;
}


void main()
{
	Mystring one("lottery winner!");//�������Լ�ȣ��
	cout << one << endl;  //��¿������Լ�ȣ��

	Mystring two(20, '$');//�������Լ�ȣ��
	cout << two << endl;//��¿������Լ�ȣ��

	Mystring three(one); // ���������ȣ��
	cout << three << endl; //��¿������Լ�ȣ��

	one += "oops"; // +=�������Լ�ȣ�� ( strcat�Լ� )
	cout << one << endl;//���ڿ����� 

	two = "sorry!that was";//���Կ������Լ� ȣ�� 
	cout << two << endl;

	three[0] = 'p';//[]÷�ڿ������Լ� ȣ�� 
	cout << three << endl;

	Mystring four;
	four = two + three;
	cout << four << endl;

	char alls[] = "all's well that ends well";
	Mystring five(alls, 20); //������ȣ��
	cout << five << "!\n";


	Mystring six(alls + 6, alls + 10);  //������
	cout << six << ",";


	Mystring seven(&five[6], &five[10]);  //������
	cout << seven << "...\n";


	Mystring eight;
	cout << "���ڿ� �Է��ϼ��� :";
	cin >> eight;  // >>������ȣ��
	cout << " �Է��� ���ڿ��� \"" << eight << "\" �Դϴ� " << endl;

}