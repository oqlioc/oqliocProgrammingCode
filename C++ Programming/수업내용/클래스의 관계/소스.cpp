#include <iostream>
#include <string>
using namespace std;
/*
	1. has ~ a (포함 오브젝트)

	2. is ~ a (상속)

*/
class A
{
	string name;
public:
	A() { cout << "A::" << endl; }
	A(string name) { this->name = name; }

	void setName(string name) { this->name = name; }
	string getName()const { return name; }
};
class B
{
	A name; // has ~ a
	int age;
public:
	B(string n, int age) : name(n)
	{
		cout << "B::" << endl;
		//this->name.setName(name);
		this->age = age;
	}

	void setAge(int age) { this->age = age/10; }
	int getAge()const { return age; }

	void setName(string name) { this->name.setName(name); }
	string getName() const { return name.getName(); }
};
void main()
{
	B bb("superman", 900);
	//bb.setName("superman");
	bb.setAge(900);

	cout << bb.getName() << endl;
	cout << bb.getAge() << endl;
}