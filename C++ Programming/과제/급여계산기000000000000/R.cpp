#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"
#include "CalcR.h"
#include "CalcT.h"
#include "Data .h"
#include "ArrayT.h"
using namespace std;

void RegularWorker::setName(string name) { this->data.setName(name); }
string RegularWorker::getName()const { return data.getName(); }

void RegularWorker::setIdNumber(string idNumber) { this->data.setIdNumber(idNumber); }
string RegularWorker::getidNumber()const { return data.getIdNumber(); }

void RegularWorker::setPosition(string position) { this->data.setPosition(position); }
string RegularWorker::getPosition()const { return data.getPosition(); }

void RegularWorker::setDepart(string depart) { this->data.setDepart(depart); }
string RegularWorker::getDepart()const { return data.getDepart(); }

void RegularWorker::setGender(string gender) { this->data.setGender(gender); }
string RegularWorker::getGender()const { return data.getGender(); }

void RegularWorker::setEmail(string email) { this->data.setEmail(email); }
string RegularWorker::getEmail()const { return data.getEmail(); }

void RegularWorker::setBank(string  bank) { this->data.setBank(bank); }
string RegularWorker::getBank()const { return data.getBank(); }

void RegularWorker::setAccount(string account) { this->data.setAccount(account); }
string RegularWorker::getAccount()const { return  data.getAccount(); }

void RegularWorker::setAddress(string address) { this->data.setAddress(address); }
string RegularWorker::getAddress()const { return  data.getAddress(); }

void RegularWorker::setYear(int year) { this->data.setYear(year); }
int RegularWorker::getYear()const { return  data.getYear(); }

void RegularWorker::setAge(int age) { this->data.setAge(age); }
int RegularWorker::getAge()const { return  data.getAge(); }

void RegularWorker::setTime(int time) { this->data.setTime(time); }
int RegularWorker::getTime()const { return data.getTime(); }

void RegularWorker::setEmpType(string EmpType) { this->data.setEmpType(EmpType); }
string RegularWorker::getEmpType()const { return data.getEmpType(); }

void RegularWorker::setPay(int pay) {
	this->pay = pay;
}
int RegularWorker::getPay()const {
	return pay;
}

void RegularWorker::setPayr(int pay) {
	this->calc.calc(pay);
	payr = pay;
}
int RegularWorker::getPayr() const {
	//   void setPayr(int pay);
	return payr;
}