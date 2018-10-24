#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"
#include "Data .h"
#include "ArrayT.h"
using namespace std;

void Data::setPay(int pay) {
	this->pay = pay;
}
int Data::getPay()const {
	return pay;
}
void Data::setName(string name) {
	this->name = name;
}
string Data::getName()const {
	return name;
}
void Data::setIdNumber(string idNumber) {
	this->idNumber = idNumber;
}
string Data::getIdNumber()const {
	return idNumber;
}
void Data::setPosition(string position) {
	this->position = position;
}
string Data::getPosition()const {
	return position;
}
void Data::setDepart(string depart) {
	this->depart = depart;
}
string Data::getDepart()const {
	return depart;
}
void Data::setGender(string gender) {
	this->gender = gender;
}
string Data::getGender()const {
	return gender;
}
void Data::setEmail(string email) {
	this->email = email;
}
string Data::getEmail()const {
	return email;
}
void Data::setBank(string  bank) {
	this->bank = bank;
}
string Data::getBank()const {
	return  bank;
}

void Data::setAccount(string accont) {
	this->account = accont;
}
string Data::getAccount()const {
	return  account;
}

void Data::setAddress(string address) {
	this->address = address;
}
string Data::getAddress()const {
	return  address;
}

void Data::setYear(int year) {
	this->year = year;
}
int Data::getYear()const {
	return  year;
}

void Data::setAge(int age) {
	this->age = age;
}
int Data::getAge()const {
	return  age;
}
void Data::setTime(int time) {
	this->time = time;
}
int Data::getTime()const {
	return time;
}
void Data::setEmpType(string EmpType) {
	this->EmpType = EmpType;
}
string Data::getEmpType()const {
	return EmpType;
}