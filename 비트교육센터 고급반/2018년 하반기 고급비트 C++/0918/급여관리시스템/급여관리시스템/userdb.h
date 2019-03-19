
#pragma once
#include<iostream>
#include<string>
using namespace std;

class UserDB {

	string name;
	string position;
	string department;
	int userNum;
	int password;
	double salary;
	int age;

public:
	UserDB * next;

	UserDB();
	/*{

	}*/

	void setName(string name);
	/*{
		this->name = name;
	}*/

	string getName()const;
	/*{
		return name;
	}*/

	void setAge(int age);
	/*{
		this->age = age;
	}*/

	int getAge()const;
	/*{
		return age;
	}*/

	void setNum(int userNum);
	/*{
		this->userNum = userNum;
	}*/

	int getNum()const;
	/*{

		return userNum;
	}*/

	void setPass(int password);
	/*{
		this->password = password;
	}*/

	int getPass()const;
	/*{

		return password;
	}*/

	void setDepartment(string department);
	/*{
		this->department = department;
	}*/

	string getDepartment()const;
	/*{
		return department;
	}*/

	void setPosition(string position);
	/*{
		this->position = position;
	}*/

	string getPosition()const;
	/*{
		return position;
	}*/

	void setSalary(double salary);
	/*{
		this->salary = salary;
	}*/

	double getSalary()const;
	/*{
		return salary;
	}*/

}; // UserDB class