
#pragma once

#include<iostream>
#include<string>
#include"admin.h"
using namespace std;

class User { // �α��ΰ� ��ȸ

	Admin *admin;
	int userNum;
	int pass;
	int checking_ID;

	UserDB *p;   //menu���� ���� ������Ŭ������ �ּ� ���� �ʵ�
	UserDB *cur;
	UserDB *head;
	UserDB *root;
public:

	User(UserDB* root);
	/*{
	this->admin = admin;
	}*/

	bool loginID(int userNum);
	/*{
	for (int i = 0; i < 100; i++) {

	if (this->userNum == admin->userdb[i].getNum())
	return true;

	}return false;

	}*/

	bool loginPass(int pass);
	/*{
	for (int i = 0; i < 100; i++) {

	if (this->pass == admin->userdb[i].getPass())
	return true;

	}return false;

	}
	// ����� �α���
	*/
	void userSearch();
	/*{

	cout << "������ �����ȣ�� �Է����ּ��� :";
	cin >> checking_ID;

	for (int i = 0; i < 100; i++)
	{
	if (checking_ID == (admin->userdb[i].getNum()))
	{
	cout << "\n"<<admin->userdb[i].getNum() << "\t" << admin->userdb[i].getName() << "\t" << admin->userdb[i].getAge() << "\t" << admin->userdb[i].getDepartment() << "\t" << admin->userdb[i].getPosition() << "\t" << admin->userdb[i].getSalary() << "\t" << admin->userdb[i].getPass() << endl;
	break;
	}
	else {
	cout << "�����ȣ�� �������� �ʽ��ϴ�." << endl;
	break;
	}
	}

	}
	// ����� ��ȸ(����)
	*/


};