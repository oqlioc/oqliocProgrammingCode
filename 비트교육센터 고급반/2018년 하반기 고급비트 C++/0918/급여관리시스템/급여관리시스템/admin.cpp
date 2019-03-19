#pragma once
#include <iostream>
#include "admin.h"
using namespace std;

Admin::Admin(UserDB* root) {   // constructor

		this->root = root;//menu���� UserDB�� ����Ű�� �������� �ּҸ� �޾Ƽ� �ʵ忡 �ʱ�ȭ ���ֱ�
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

}// ������ �α��� 

void Admin:: adminMode() {

	int a;
	cout << "[������ ����Դϴ�.] " << endl;
	cout << "1. ����� �߰� 2. ����� ��ȸ 3. ����� ���� 4. ����� ��������" << endl;
	cin >> a;

	switch (a) {
	case 1:setUserDB(); break;
	case 2:search(); break;
	case 3:deleteUser(); break;
	case 4:update(); break;
	default: cout << "�߸��� �Է��Դϴ�." << endl; break;


	}


}// ������ Ŭ���� �޴�

// 0. ��� �����ϱ�
void Admin:: createNode() {

	p = new UserDB;	//UserDB�� �ּҸ� �˰� �ִ� p�� ��ü ����� �ֱ�
	root->next = p;
	++count;	//�� ó�� ��� ����� ���� ī��Ʈ ����
	new1 = p;	//p�� new1���� �ٲ��ֱ�, ���� ������ٴ� �ǹ̿���...

	if (count == 1) {	//��� ó�� ���� ��
		head = new1;	//ó����带 ���� ����Ű��
		cur = head;		//Ŀ���� ���� �ű��
		setUserDB();	//��忡 ������ �ֱ�

	}
	else {
		cur = head;
		while (cur->next != NULL)	//������ ������ Ŀ�� �ű��
		{
			cur = cur->next;
		}
		cur->next = new1;
		setUserDB();	//��忡 ������ �ֱ�
	}
}

void Admin:: setUserDB() { // 1. ����� �߰�
	int num;
	

	cout << "��� �̸��� �Է��ϼ���:";
	cin >> name;
	setUserName(name);

	cout << "1. ������ 2. ��������" << endl;
	cin >> num;
	if (num == 1) {
		setUserSalaryF(position);
	}
	else if (num == 2) {
		setUserSalaryP(position);
	}

	cout << "����(������: ���, �븮, ����, ����, ����, ����, �̻�, ���� / �������� : ����, �����, �İ�)�� �Է��ϼ���:";
	cin >> position;
	setUserPosition(position);

	cout << "�μ��� �Է��ϼ���:";
	cin >> department;
	setUserDepartment(department);

	cout << "�����ȣ�� �Է��ϼ���:";
	cin >> userNum;
	setUserNum(userNum);

	cout << "��й�ȣ�� �Է��ϼ���:";
	cin >> password;
	setUserPass(password);

	cout << "���̸� �Է��ϼ���:";
	cin >> age;
	setUserAge(age);

	
	cout << "*����ڰ� �߰��Ǿ����ϴ�.*" << endl;


}// ����� ���


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
	if (salary == ("���")) {
		new1->setSalary(150);
	}
	else if (salary == ("�븮")) {
		new1->setSalary(200);
	}
	else if (salary == ("����")) {
		new1->setSalary(250);
	}
	else if (salary == ("����")) {
		new1->setSalary(300);
	}
	else if (salary == ("����")) {
		new1->setSalary(400);
	}
	else if (salary == ("����")) {
		new1->setSalary(500);
	}
	else if (salary == ("�̻�")) {
		new1->setSalary(700);
	}
	else if (salary == ("����")) {
		new1->setSalary(1000);
	}
}

void Admin:: setUserSalaryP(string salary) {
	if (salary == ("����")) {
		new1->setSalary(120);
	}
	else if (salary == ("�����")) {
		new1->setSalary(200);
	}
	else if (salary == ("�İ�")) {
		new1->setSalary(250);
	}
}

void Admin:: setUserAge(int age) {
	new1->setAge(age);

}

void Admin:: search() {
	int number;
	int checking_ID;
	cout << "1.��ü��ȸ 2.������ȸ";
	cin >> number;

	switch (number)
	{
	case 1:
		cur = head;
		cout << "��ü ��� ����Ʈ" << endl;

			if (cur == NULL) {	//��尡 �ϳ��� ���� ��
				cout << "�ƹ� �͵� �����ϴ�." << endl;
				return;
			}
		cout<<"\n" << "�����ȣ" << "\t" << "�̸�" << "\t" << "����" << "\t" << "�μ�" << "\t" << "����" << "\t" << "�޿�" << "\t" << "��й�ȣ" << endl;
		while (cur != NULL)	//��ü���
		{
			cout << "=========================================================================================================" << endl;
			cout << cur->getNum() << "\t" << "\t" << cur->getName() << "\t" << cur->getAge() << "\t" << cur->getDepartment() << "\t" << cur->getPosition() << "\t" << cur->getSalary() << "\t" << cur->getPass() << endl;
			cur = cur->next;
		}
		break;

	case 2:
		cout << "��ȸ�� ID �Է����ּ���";
		cin >> checking_ID;
		cur = head;

		while (cur != NULL)
		{
			if (checking_ID == cur->getNum())
			{
				cout << "�����ȣ" << "\t" << "�̸�" << "\t" << "����" << "\t" << "�μ�" << "\t" << "����" << "\t" << "�޿�" << "\t" << "��й�ȣ" << endl;
				cout << cur->getNum() << "\t" << "\t" << cur->getName() << "\t" << cur->getAge() << "\t" << cur->getDepartment() << "\t" << cur->getPosition() << "\t" << cur->getSalary() << "\t" << cur->getPass() << endl;
			}
			cur = cur->next;
		}
		break;
	default: cout << "�߸� �Է�"; break;
	}
}

void Admin:: deleteUser() {

	int checking_ID;	//���� �ϰ� ���� ��ȣ �ޱ�
	cur = head;

	if (cur == NULL)	//��尡 �ϳ��� ���� ��
	{
		cout << "���� ��尡 �����ϴ�." << endl;
		return;
	}
	cout << "�����ϰ� ���� ID�� �Է��Ͻÿ�";
	cin >> checking_ID;

	while (cur != NULL)
	{
		if (checking_ID == head->getNum())	//���� �տ� �ִ� ��� ���� ��
			{

				if (cur->next == NULL)	//���� �տ� �ְ� ��尡 �ϳ� �ۿ� ���� ��� ī��Ʈ �� 0���� �����.(��带 �ٽ� �����ϴ� ��� ó������ ����� ���ؼ�)
				{
					count = 0;
				}

				head = cur->next;	//�� ��� �������, ���� ���� ����
				del = cur;
				del->next = NULL;
				delete(del);
				return;
			}

			if (checking_ID == cur->next->getNum()) {	//�̾��� �ִ� ��� ���� ��

				del = cur->next;	//�����ϰ� ���� ��� ���
				cur->next = del->next;	//�� ���� �ǳ��� �ִ� ��� �̾��ֱ�
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
	cout << "������ ID�� �Է��ϼ���." << endl;
	cin >> checking_ID;
	cur = head;

	while (cur != NULL)
	{
		if (checking_ID == (cur->getNum()))
		{
			cout << "��� �̸��� �Է��ϼ���:";
			cin >> name;
			cur->setName(name);

			cout << "������ �Է��ϼ���:";
			cin >> position;
			cur->setPosition(position);

			cout << "�μ��� �Է��ϼ���:";
			cin >> department;
			cur->setDepartment(department);

			cout << "�����ȣ�� �Է��ϼ���:";
			cin >> userNum;
			cur->setNum(userNum);

			cout << "��й�ȣ�� �Է��ϼ���:";
			cin >> password;
			cur->setPass(password);

			cout << "�޿��� �Է��ϼ���:";
			cin >> salary;
			cur->setSalary(salary);

			cout << "���̸� �Է��ϼ���:";
			cin >> age;
			cur->setAge(age);

			cout << "*����ڰ� �����Ǿ����ϴ�.*" << endl;
		}
		cur = cur->next;
	}

}
/*
UserDB Admin:: *getP() {
		return p;
	}
	*/