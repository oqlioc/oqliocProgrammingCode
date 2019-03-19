
#pragma once

#include<iostream>
#include<string>
#include"admin.h"
using namespace std;

class User { // 로그인과 조회

	Admin *admin;
	int userNum;
	int pass;
	int checking_ID;

	UserDB *p;   //menu에서 받은 데이터클래스의 주소 저장 필드
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
	// 사용자 로그인
	*/
	void userSearch();
	/*{

	cout << "본인의 사원번호를 입력해주세요 :";
	cin >> checking_ID;

	for (int i = 0; i < 100; i++)
	{
	if (checking_ID == (admin->userdb[i].getNum()))
	{
	cout << "\n"<<admin->userdb[i].getNum() << "\t" << admin->userdb[i].getName() << "\t" << admin->userdb[i].getAge() << "\t" << admin->userdb[i].getDepartment() << "\t" << admin->userdb[i].getPosition() << "\t" << admin->userdb[i].getSalary() << "\t" << admin->userdb[i].getPass() << endl;
	break;
	}
	else {
	cout << "사원번호가 존재하지 않습니다." << endl;
	break;
	}
	}

	}
	// 사용자 조회(본인)
	*/


};