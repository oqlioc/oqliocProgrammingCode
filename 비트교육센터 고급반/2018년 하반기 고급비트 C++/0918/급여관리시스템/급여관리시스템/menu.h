#pragma once
#include<iostream>
#include<string>
#include"admin.h"
#include"user.h"
using namespace std;

class Menu {

	UserDB *userdb;   //������Ŭ����
	Admin *admin;   //������
	User *user;      //���
	UserDB* root;	//����� ���
	UserDB* cur;
	string adminID; //�����ڿ� ���̵�
	int adminPass;   //�����ڿ� �н�����

	int userNum;   //����� �����ȣ
	int userPass;   //����� �н�����

	int a;

public:
	Menu(); 
	/*{

	user = new User(&admin);


	menu();


	}*/
	void menu();
	/*{
	while (1) {
	cout << "   |\t==== �޿����� ���α׷�====\t|   " << endl;
	cout << "| " << "1. ������ ���" << "\t" << "2. ����� ���" << "\t" << "3. ���� |" << endl;
	cin >> a;

	switch (a) {

	case 1:
	{
	cout << "������ID�� �Է��ϼ��� =>";
	cin >> adminID;

	if (admin.loginID(adminID)) {

	cout << "��й�ȣ�� �Է��ϼ��� =>";
	cin >> adminPass;

	if (admin.loginPass(adminPass)) {


	cout << "=== Login Success ===" << endl;
	// ������ �α��θ��
	admin.adminMode();

	}


	else {
	cout << "��й�ȣ�� Ʋ�Ƚ��ϴ�." << endl; continue;
	}
	}
	else {
	cout << "������ID�� Ʋ�Ƚ��ϴ�." << endl; continue;
	}
	}break;

	case 2:
	{
	cout << "�����ȣ�� �Է��ϼ���:";
	cin >> userNum;
	if (user->loginID(userNum)) {

	cout << "��й�ȣ�� �Է��ϼ��� =>";
	cin >> userPass;
	if (user->loginPass(userPass)) {


	cout << "=== User Login Success ===" << endl;
	// ����ڸ��
	user->userSearch();

	}


	else {
	cout << "��й�ȣ�� Ʋ�Ƚ��ϴ�." << endl; continue;
	}

	}
	else {
	cout << "�����ȣ�� �������� �ʽ��ϴ�. " << endl;
	}

	} break;

	case 3 :
	exit(-1);
	break;

	default:cout << "�߸��� �Է��Դϴ�." << endl; break;

	}


	}*/


};