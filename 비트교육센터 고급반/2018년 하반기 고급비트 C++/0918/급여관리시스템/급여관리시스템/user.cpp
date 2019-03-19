#pragma once
#include <iostream>
#include "user.h"
using namespace std;

User:: User(UserDB* root){  
		this->cur = root;	//menu에서 UserDB를 가리키는 포인터의 주소를 받아서 필드에 초기화 해주기
		head = root;
	}

bool User:: loginID(int userNum) {

	cur = head->next;
	while (cur != NULL) {

		if (this->userNum == cur->getNum())
			return true;

	}return false;

}

bool User:: loginPass(int pass) {
	cur = head->next;
	while (cur != NULL) {

		if (this->pass == cur->getPass())
			return true;

	}return false;

}
// 사용자 로그인

void User:: userSearch() {

	cout << "본인의 사원번호를 입력해주세요 :";
	cin >> checking_ID;
	cur = head->next;

	while (cur != NULL)
	{
		if (checking_ID == (cur->getNum()))
		{
			cout << "\n"<<cur->getNum() << "\t" << cur->getName() << "\t" << cur->getAge() << "\t" << cur->getDepartment() << "\t" << cur->getPosition() << "\t" << cur->getSalary() << "\t" << cur->getPass() << endl;
			break;
		}
		else {
			cout << "사원번호가 존재하지 않습니다." << endl;
			break;
		}
	}

}
// 사용자 조회(본인)