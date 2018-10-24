#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"
#include "Data .h"
#include "ArrayT.h"
using namespace std;

class Data {
	string name;
	int age;
	string idNumber;//사원번호
	string position;
	string depart;
	string gender;
	string EmpType;
	string email;
	string bank;
	string account;
	string address;
	int year;
	int time;
	int pay;

public:

	void setPay(int pay);
	int getPay()const;
	void setName(string name);
	string getName()const;
	void setIdNumber(string idNumber);
	string getIdNumber()const;
	void setPosition(string position);
	string getPosition()const;
	void setDepart(string depart);
	string getDepart()const;
	void setGender(string gender);
	string getGender()const;
	void setEmail(string email);
	string getEmail()const;
	void setBank(string  bank);
	string getBank()const;

	void setAccount(string accont);
	string getAccount()const;

	void setAddress(string address);
	string getAddress()const;

	void setYear(int year);
	int getYear()const;

	void setAge(int age);
	int getAge()const;
	void setTime(int time);
	int getTime()const;
	void setEmpType(string EmpType);
	string getEmpType()const;

};