#pragma once
#include<iostream>
#include<string>
#include"userDB.h"

using namespace std;

static int c = 0;

class Admin {

	string name;
	string position;
	string department;
	int userNum;
	int password;
	double salary;
	int age;

	//관리자모드용 필드
	string adminID;
	int pass;

	//노드용 필드
	UserDB *p;	//menu에서 받은 데이터클래스의 주소 저장 필드
	UserDB *cur;
	UserDB *del;
	UserDB *new1;
	UserDB *head;
	UserDB *root;
	int count;

public: 
	//UserDB userdb[100];

	Admin(UserDB* root);
	/*{   // constructor

		adminID = "1";
		pass = 1;

	}*/

	bool loginID(string adminID);
	/*{
		if (this->adminID == adminID)
			return true;
		else return false;
	}*/

	bool loginPass(int pass);
	/*{
		if (this->pass == pass)
			return true;
		else return false;

	}// 관리자 로그인 
	*/

	void adminMode();
	/*{

		int a;
		cout << "[관리자 모드입니다.] " << endl;
		cout << "1. 사용자 추가 2. 사용자 조회 3. 사용자 삭제 4. 사용자 정보수정" << endl;
		cin >> a;

		switch (a) {
		case 1:setUserDB(); break;
		case 2:search(); break;
		case 3:deleteUser(); break;
		case 4:update(); break;
		default: cout << "잘못된 입력입니다." << endl; break;


		}


	}// 관리자 클래스 메뉴
	*/
	void createNode();

	void setUserDB();
	/*{
		int num;
		cout << "1. 정규직 2. 비정규직" << endl;
		cin >> num;


		cout << "사원 이름을 입력하세요:";
		cin >> name;
		setUserName(name);

		cout << "직급을 입력하세요:";
		cin >> position;
		setUserPosition(position);

		cout << "부서를 입력하세요:";
		cin >> department;
		setUserDepartment(department);

		cout << "사원번호를 입력하세요:";
		cin >> userNum;
		setUserNum(userNum);

		cout << "비밀번호를 입력하세요:";
		cin >> password;
		setUserPass(password);
		cout << "나이를 입력하세요:";
		cin >> age;
		setUserAge(age);
		if (num == 1) {
			setUserSalaryF(position);
		}
		else if (num == 2) {
			setUserSalaryP(position);
		}

		cout << "*사용자가 추가되었습니다.*" << endl;
		c++;


	}// 사용자 등록
	*/

	void setUserName(string name);
	/*{
		userdb[c].setName(name);
	}*/

	void setUserPosition(string position);
	/*{
		userdb[c].setPosition(position);
	}*/

	void setUserDepartment(string department);
	/*{
		userdb[c].setDepartment(department);
	}*/

	void setUserNum(int userNum);
	/*{
		userdb[c].setNum(userNum);
	}*/

	void setUserPass(int pass);
	/*{
	userdb[c].setPass(pass);
	}*/

	void setUserSalaryF(string salary);
	/*{
	if (salary == ("사원")) {
	userdb[c].setSalary(150);
	}
	else if (salary == ("대리")) {
	userdb[c].setSalary(200);
	}
	else if (salary == ("팀장")) {
	userdb[c].setSalary(250);
	}
	else if (salary == ("과장")) {
	userdb[c].setSalary(300);
	}
	else if (salary == ("차장")) {
	userdb[c].setSalary(400);
	}
	else if (salary == ("부장")) {
	userdb[c].setSalary(500);
	}
	else if (salary == ("이사")) {
	userdb[c].setSalary(700);
	}
	else if (salary == ("사장")) {
	userdb[c].setSalary(1000);
	}
	}*/

	void setUserSalaryP(string salary);
	/*{
	if (salary == ("인턴")) {
	userdb[c].setSalary(120);
	}
	else if (salary == ("계약직")) {
	userdb[c].setSalary(200);
	}
	else if (salary == ("파견")) {
	userdb[c].setSalary(250);
	}
	}*/

	void setUserAge(int age); 
	/*{
	userdb[c].setAge(age);

	}*/

	void search(); 
	/*{
	int number;
	int checking_ID;
	cout << "1.전체조회 2.개인조회";
	cin >> number;

	switch (number)
	{
	case 1:
	cout<<"\n" << "사원번호" << "\t" << "이름" << "\t" << "나이" << "\t" << "부서" << "\t" << "직급" << "\t" << "급여" << "\t" << "비밀번호" << endl;
	for (int i = 0; i < c; i++)
	{
	cout << "=========================================================================================================" << endl;
	cout << userdb[i].getNum() << "\t" << "\t" << userdb[i].getName() << "\t" << userdb[i].getAge() << "\t" << userdb[i].getDepartment() << "\t" << userdb[i].getPosition() << "\t" << userdb[i].getSalary() << "\t" << userdb[i].getPass() << endl;
	}
	break;

	case 2:
	cout << "조회할 ID 입력해주세요";
	cin >> checking_ID;

	for (int i = 0; i < 100; i++)
	{
	if (checking_ID == (userdb[i].getNum()))
	{
	cout << "사원번호" << "\t" << "이름" << "\t" << "나이" << "\t" << "부서" << "\t" << "직급" << "\t" << "급여" << "\t" << "비밀번호" << endl;
	cout << userdb[i].getNum() << "\t" << "\t" << userdb[i].getName() << "\t" << userdb[i].getAge() << "\t" << userdb[i].getDepartment() << "\t" << userdb[i].getPosition() << "\t" << userdb[i].getSalary() << "\t" << userdb[i].getPass() << endl;
	}
	}
	break;
	default: cout << "잘못 입력"; break;
	}
	}*/
	void deleteUser();
	/*{

	int checking_ID;
	cout << "삭제하고 싶은 ID를 입력하시오";
	cin >> checking_ID;

	for (int i = 0; i < 100; i++)
	{
	if (checking_ID == (userdb[i].getNum()))
	{

	for (int j = i; i < 100 - i; i++)
	{
	userdb[i] = userdb[i + 1];
	}
	--c;
	}

	}
	}*/
	void update(); 
	/*{
	int number;
	int checking_ID;
	cout << "수정할 ID를 입력하세요." << endl;
	cin >> checking_ID;

	for (int i = 0; i < 100; i++)
	{
	if (checking_ID == (userdb[i].getNum()))
	{
	cout << "사원 이름을 입력하세요:";
	cin >> name;
	userdb[i].setName(name);

	cout << "직급을 입력하세요:";
	cin >> position;
	userdb[i].setPosition(position);

	cout << "부서를 입력하세요:";
	cin >> department;
	userdb[i].setDepartment(department);

	cout << "사원번호를 입력하세요:";
	cin >> userNum;
	userdb[i].setNum(userNum);

	cout << "비밀번호를 입력하세요:";
	cin >> password;
	userdb[i].setPass(password);

	cout << "급여를 입력하세요:";
	cin >> salary;
	userdb[i].setSalary(salary);

	cout << "나이를 입력하세요:";
	cin >> age;
	userdb[i].setAge(age);

	cout << "*사용자가 수정되었습니다.*" << endl;
	}
	}
	}*/

	UserDB *getP(); // { return p; }



}; // Admin class
