#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"
#include "Data .h"
#include "ArrayT.h"
using namespace std;

class RegularWorker
{

	Data data;
	int payr;
	int pay;

public:
	void setName(string name);
	string getName()const;

	void setIdNumber(string idNumber);
	string getidNumber()const;

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

	void setAccount(string account);
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

	void setPay(int pay);
	int getPay()const;

	void setPayr(int pay);

	int getPayr() const;
};