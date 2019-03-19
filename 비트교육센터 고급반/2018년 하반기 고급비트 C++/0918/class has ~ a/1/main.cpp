#include <iostream>
#include <string>
using namespace std;

class A {

	string name;

public:

	A() {
		cout << "A::" << endl;
	}

	A(string name) { 
		this->name = name; 
	}

	void setName(string name) {
		this->name = name;
	}

	string getName()const {
		return name;
	}

};

class B {
	
	A name; // has ~ a
	int age;

public:
	B(string name, int age) : name(name) {
		cout << "B::" << endl;
		//this->name.setName(name);
		this->age = age;

	}

	void setAge(int age) {
		this->age = age;
	}

	int getAge() const {
		return age;
	}

	void setName(string name) {
		this->name.setName(name);
	}

	string getName() const {
		return name.getName();
	}
};

void main()
{
	A name;

	name.setName("Batman");
	cout << name.getName() << endl;
	
	B bb("Joker", 900);

//	bb.setName("Superman");
//	bb.setAge(900);

	cout << bb.getName() << endl;
	cout << bb.getAge() << endl;

//	B cc("Joker", 900);
}