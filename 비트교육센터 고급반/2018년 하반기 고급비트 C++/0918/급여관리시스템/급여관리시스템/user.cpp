#pragma once
#include <iostream>
#include "user.h"
using namespace std;

User:: User(UserDB* root){  
		this->cur = root;	//menu���� UserDB�� ����Ű�� �������� �ּҸ� �޾Ƽ� �ʵ忡 �ʱ�ȭ ���ֱ�
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
// ����� �α���

void User:: userSearch() {

	cout << "������ �����ȣ�� �Է����ּ��� :";
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
			cout << "�����ȣ�� �������� �ʽ��ϴ�." << endl;
			break;
		}
	}

}
// ����� ��ȸ(����)