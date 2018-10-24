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

void TemporaryWorker::setName(string name) { this->data.setName(name); }
string TemporaryWorker::getName()const { return data.getName(); }

void TemporaryWorker::setIdNumber(string idNumber) { this->data.setIdNumber(idNumber); }
string TemporaryWorker::getidNumber()const { return data.getIdNumber(); }

void TemporaryWorker::setPosition(string position) { this->data.setPosition(position); }
string TemporaryWorker::getPosition()const { return data.getPosition(); }

void TemporaryWorker::setDepart(string depart) { this->data.setDepart(depart); }
string TemporaryWorker::getDepart()const { return data.getDepart(); }

void TemporaryWorker::setGender(string gender) { this->data.setGender(gender); }
string TemporaryWorker::getGender()const { return data.getGender(); }

void TemporaryWorker::setEmail(string email) { this->data.setEmail(email); }
string TemporaryWorker::getEmail()const { return data.getEmail(); }

void TemporaryWorker::setBank(string  bank) { this->data.setBank(bank); }
string TemporaryWorker::getBank()const { return data.getBank(); }

void TemporaryWorker::setAccount(string account) { this->data.setAccount(account); }
string TemporaryWorker::getAccount()const { return  data.getAccount(); }

void TemporaryWorker::setAddress(string address) { this->data.setAddress(address); }
string TemporaryWorker::getAddress()const { return  data.getAddress(); }

void TemporaryWorker::setYear(int year) { this->data.setYear(year); }
int TemporaryWorker::getYear()const { return  data.getYear(); }

void TemporaryWorker::setAge(int age) { this->data.setAge(age); }
int TemporaryWorker::getAge()const { return  data.getAge(); }

void TemporaryWorker::setTime(int time) { this->data.setTime(time); }
int TemporaryWorker::getTime()const { return data.getTime(); }

void TemporaryWorker::setEmpType(string EmpType) { this->data.setEmpType(EmpType); }
string TemporaryWorker::getEmpType()const { return data.getEmpType(); }

void TemporaryWorker::setPay(int pay) { this->data.setPay(pay); }
int TemporaryWorker::getPay()const { return data.getPay(); }

void TemporaryWorker::setPayt(int pay) {
	this->calc.calc(pay, data.getTime());
	payt = pay;
}
int TemporaryWorker::getPayr() const {
	//   void setPayr(int pay);
	return payt;
}