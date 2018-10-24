#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"
#include "data .h"
#include "ArrayT.h"
using namespace std;

int main()
{

	RegularWorker *rw;
	TemporaryWorker *tw;
	ArrayR arw;
	ArrayT atw;

	string MemberNum;
	int adminMenuNum;
	int usernum;
	int inputnum;
	string yn;

	string s_data;
	int i_data;

	do {

		cout << "Insert ID Number : " << endl;
		cin >> MemberNum;

		if (MemberNum.compare("000") == 0)
		{
			cout << "<Administrator Mode>" << endl;
			cout << "■ * * * * * * * ■" << endl;
			cout << "*  Select Menu  *" << endl;
			cout << "*  1. Input     *" << endl;
			cout << "*  2. Output    *" << endl;
			cout << "*  3. Search    *" << endl;
			cout << "*  4. Delete    *" << endl;
			cout << "*  5. Modify    *" << endl;
			cout << "■ * * * * * * * ■" << endl;
			cout << "Menu num : " << endl;

			cin >> adminMenuNum;

			switch (adminMenuNum) {
			case 1:
				// 입력
				cout << "<INPUT>" << endl;
				cout << "1. Ragular 2. Temporary" << endl;
				cin >> inputnum;
				switch (inputnum) {
				case 1: {

					// 정규직 입력
					do {
						// 입력을 할때마다 객체를 생성해줌
						rw = new RegularWorker();
						cout << "======Ragular Input========" << endl;

						cout << "Name Input : " << endl;
						cin >> s_data;
						rw->setName(s_data);

						cout << "IdNumber Input" << endl;
						cin >> s_data;
						rw->setIdNumber(s_data);

						cout << "Position Input" << endl;
						cin >> s_data;
						rw->setPosition(s_data);

						cout << "Gender Input" << endl;
						cin >> s_data;
						rw->setGender(s_data);

						cout << "Depart Input" << endl;
						cin >> s_data;
						rw->setDepart(s_data);

						cout << "Email Input" << endl;
						cin >> s_data;
						rw->setEmail(s_data);

						cout << "Bank Input" << endl;
						cin >> s_data;
						rw->setBank(s_data);

						cout << "Account Input" << endl;
						cin >> s_data;
						rw->setAccount(s_data);

						cout << "Address Input" << endl;
						cin >> s_data;
						rw->setAddress(s_data);

						cout << "Age Input" << endl;
						cin >> i_data;
						rw->setAge(i_data);

						cout << "Pay Input" << endl;
						cin >> i_data;
						rw->setPay(i_data);

						arw.setRegularWorker(*rw);

					} while (1);
				}
				}
			}
		}
	} while (1);

	delete rw, tw;
	return 1;
}