#pragma once
#include<iostream>
#include<string>
#include"admin.h"
#include"user.h"
using namespace std;

class Menu {

	UserDB *userdb;   //데이터클래스
	Admin *admin;   //관리자
	User *user;      //사원
	UserDB* root;	//연결고리 노드
	UserDB* cur;
	string adminID; //관리자용 아이디
	int adminPass;   //관리자용 패스워드

	int userNum;   //사원용 사원번호
	int userPass;   //사원용 패스워드

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
	cout << "   |\t==== 급여관리 프로그램====\t|   " << endl;
	cout << "| " << "1. 관리자 모드" << "\t" << "2. 사용자 모드" << "\t" << "3. 종료 |" << endl;
	cin >> a;

	switch (a) {

	case 1:
	{
	cout << "관리자ID를 입력하세요 =>";
	cin >> adminID;

	if (admin.loginID(adminID)) {

	cout << "비밀번호를 입력하세요 =>";
	cin >> adminPass;

	if (admin.loginPass(adminPass)) {


	cout << "=== Login Success ===" << endl;
	// 관리자 로그인모드
	admin.adminMode();

	}


	else {
	cout << "비밀번호가 틀렸습니다." << endl; continue;
	}
	}
	else {
	cout << "관리자ID가 틀렸습니다." << endl; continue;
	}
	}break;

	case 2:
	{
	cout << "사원번호를 입력하세요:";
	cin >> userNum;
	if (user->loginID(userNum)) {

	cout << "비밀번호를 입력하세요 =>";
	cin >> userPass;
	if (user->loginPass(userPass)) {


	cout << "=== User Login Success ===" << endl;
	// 사용자모드
	user->userSearch();

	}


	else {
	cout << "비밀번호가 틀렸습니다." << endl; continue;
	}

	}
	else {
	cout << "사원번호가 존재하지 않습니다. " << endl;
	}

	} break;

	case 3 :
	exit(-1);
	break;

	default:cout << "잘못된 입력입니다." << endl; break;

	}


	}*/


};