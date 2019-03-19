#pragma once
#include <iostream>
#include "admin.h"
using namespace std;

Admin::Admin(UserDB* root) {   // constructor

		this->root = root;//menu에서 UserDB를 가리키는 포인터의 주소를 받아서 필드에 초기화 해주기
		adminID = "admin";
		pass = 0000;
		count = 0;
	
}

bool Admin:: loginID(string adminID) {
	if (this->adminID == adminID)
		return true;
	else return false;
}

bool Admin:: loginPass(int pass) {
	if (this->pass == pass)
		return true;
	else return false;

}// 관리자 로그인 

void Admin:: adminMode() {

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

// 0. 노드 생성하기
void Admin:: createNode() {

	p = new UserDB;	//UserDB의 주소를 알고 있는 p로 객체 만들어 주기
	root->next = p;
	++count;	//맨 처음 노드 만들기 위한 카운트 변수
	new1 = p;	//p를 new1으로 바꾸주기, 새로 만들었다는 의미에서...

	if (count == 1) {	//노드 처음 생성 시
		head = new1;	//처음노드를 헤드로 가리키기
		cur = head;		//커서를 헤드로 옮기기
		setUserDB();	//노드에 데이터 넣기

	}
	else {
		cur = head;
		while (cur->next != NULL)	//마지막 노드까지 커서 옮기기
		{
			cur = cur->next;
		}
		cur->next = new1;
		setUserDB();	//노드에 데이터 넣기
	}
}

void Admin:: setUserDB() { // 1. 사용자 추가
	int num;
	

	cout << "사원 이름을 입력하세요:";
	cin >> name;
	setUserName(name);

	cout << "1. 정규직 2. 비정규직" << endl;
	cin >> num;
	if (num == 1) {
		setUserSalaryF(position);
	}
	else if (num == 2) {
		setUserSalaryP(position);
	}

	cout << "직급(정규직: 사원, 대리, 팀장, 과장, 차장, 부장, 이사, 사장 / 비정규직 : 인턴, 계약직, 파견)을 입력하세요:";
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

	
	cout << "*사용자가 추가되었습니다.*" << endl;


}// 사용자 등록


void Admin:: setUserName(string name) {
	new1->setName(name);
}

void Admin:: setUserPosition(string position) {
	new1->setPosition(position);
}

void Admin:: setUserDepartment(string department) {
	new1->setDepartment(department);
}

void Admin:: setUserNum(int userNum) {
	new1->setNum(userNum);
}

void Admin:: setUserPass(int pass) {
	new1->setPass(pass);
}

void Admin:: setUserSalaryF(string salary) {
	if (salary == ("사원")) {
		new1->setSalary(150);
	}
	else if (salary == ("대리")) {
		new1->setSalary(200);
	}
	else if (salary == ("팀장")) {
		new1->setSalary(250);
	}
	else if (salary == ("과장")) {
		new1->setSalary(300);
	}
	else if (salary == ("차장")) {
		new1->setSalary(400);
	}
	else if (salary == ("부장")) {
		new1->setSalary(500);
	}
	else if (salary == ("이사")) {
		new1->setSalary(700);
	}
	else if (salary == ("사장")) {
		new1->setSalary(1000);
	}
}

void Admin:: setUserSalaryP(string salary) {
	if (salary == ("인턴")) {
		new1->setSalary(120);
	}
	else if (salary == ("계약직")) {
		new1->setSalary(200);
	}
	else if (salary == ("파견")) {
		new1->setSalary(250);
	}
}

void Admin:: setUserAge(int age) {
	new1->setAge(age);

}

void Admin:: search() {
	int number;
	int checking_ID;
	cout << "1.전체조회 2.개인조회";
	cin >> number;

	switch (number)
	{
	case 1:
		cur = head;
		cout << "전체 사원 리스트" << endl;

			if (cur == NULL) {	//노드가 하나도 없을 시
				cout << "아무 것도 없습니다." << endl;
				return;
			}
		cout<<"\n" << "사원번호" << "\t" << "이름" << "\t" << "나이" << "\t" << "부서" << "\t" << "직급" << "\t" << "급여" << "\t" << "비밀번호" << endl;
		while (cur != NULL)	//전체출력
		{
			cout << "=========================================================================================================" << endl;
			cout << cur->getNum() << "\t" << "\t" << cur->getName() << "\t" << cur->getAge() << "\t" << cur->getDepartment() << "\t" << cur->getPosition() << "\t" << cur->getSalary() << "\t" << cur->getPass() << endl;
			cur = cur->next;
		}
		break;

	case 2:
		cout << "조회할 ID 입력해주세요";
		cin >> checking_ID;
		cur = head;

		while (cur != NULL)
		{
			if (checking_ID == cur->getNum())
			{
				cout << "사원번호" << "\t" << "이름" << "\t" << "나이" << "\t" << "부서" << "\t" << "직급" << "\t" << "급여" << "\t" << "비밀번호" << endl;
				cout << cur->getNum() << "\t" << "\t" << cur->getName() << "\t" << cur->getAge() << "\t" << cur->getDepartment() << "\t" << cur->getPosition() << "\t" << cur->getSalary() << "\t" << cur->getPass() << endl;
			}
			cur = cur->next;
		}
		break;
	default: cout << "잘못 입력"; break;
	}
}

void Admin:: deleteUser() {

	int checking_ID;	//삭제 하고 싶은 번호 받기
	cur = head;

	if (cur == NULL)	//노드가 하나도 없을 시
	{
		cout << "지울 노드가 없습니다." << endl;
		return;
	}
	cout << "삭제하고 싶은 ID를 입력하시오";
	cin >> checking_ID;

	while (cur != NULL)
	{
		if (checking_ID == head->getNum())	//가장 앞에 있는 노드 삭제 시
			{

				if (cur->next == NULL)	//가장 앞에 있고 노드가 하나 밖에 없을 경우 카운트 값 0으로 만들기.(노드를 다시 생성하는 경우 처음부터 만들기 위해서)
				{
					count = 0;
				}

				head = cur->next;	//앞 노드 사라지니, 헤드는 다음 노드로
				del = cur;
				del->next = NULL;
				delete(del);
				return;
			}

			if (checking_ID == cur->next->getNum()) {	//이어져 있는 노드 삭제 시

				del = cur->next;	//삭제하고 싶은 노드 잡고
				cur->next = del->next;	//전 노드와 건너편에 있는 노드 이어주기
				del->next = NULL;
				delete(del);
				return;
			}

			cur = cur->next;

	}
}

void Admin:: update() {
	int number;
	int checking_ID;
	cout << "수정할 ID를 입력하세요." << endl;
	cin >> checking_ID;
	cur = head;

	while (cur != NULL)
	{
		if (checking_ID == (cur->getNum()))
		{
			cout << "사원 이름을 입력하세요:";
			cin >> name;
			cur->setName(name);

			cout << "직급을 입력하세요:";
			cin >> position;
			cur->setPosition(position);

			cout << "부서를 입력하세요:";
			cin >> department;
			cur->setDepartment(department);

			cout << "사원번호를 입력하세요:";
			cin >> userNum;
			cur->setNum(userNum);

			cout << "비밀번호를 입력하세요:";
			cin >> password;
			cur->setPass(password);

			cout << "급여를 입력하세요:";
			cin >> salary;
			cur->setSalary(salary);

			cout << "나이를 입력하세요:";
			cin >> age;
			cur->setAge(age);

			cout << "*사용자가 수정되었습니다.*" << endl;
		}
		cur = cur->next;
	}

}
/*
UserDB Admin:: *getP() {
		return p;
	}
	*/