#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"
#include "CalcR.h"
#include "CalcT.h"
#include "Data .h"
#include "ArrayT.h"
using namespace std;

void ArrayT::setRegularWorker(RegularWorker tw)
{
	atw[flag] = tw;
	flag++;
}

void ArrayT::getRegularWorker()
{
	int i;

	for (i = 0; i < flag; i++) {

		data = atw[i].getName() + "\t" + atw[i].getidNumber() + "\t" + atw[i].getGender() + "\t"
			+ atw[i].getDepart() + "\t" + atw[i].getPosition() + "\t" + atw[i].getEmpType() + "\t"
			+ atw[i].getAddress() + "\t" + atw[i].getBank() + "\t"
			+ atw[i].getAccount();

		yearData = atw[i].getYear();
		payData = atw[i].getPay();

		cout << data << "\t" << yearData << "\t" << payData << endl;
	}
}

void ArrayT::searchRegularWorker(string s_idNumber)
{
	int i;

	for (i = 0; i < flag; i++)
	{
		if (atw[i].getidNumber().compare(s_idNumber) == 0)
		{
			data = atw[i].getName() + "\t" + atw[i].getidNumber() + "\t" + atw[i].getGender() + "\t"
				+ atw[i].getDepart() + "\t" + atw[i].getPosition() + "\t" + atw[i].getEmpType() + "\t"
				+ atw[i].getAddress() + "\t" + atw[i].getBank() + "\t"
				+ atw[i].getAccount();

			yearData = atw[i].getYear();
			payData = atw[i].getPay();

			cout << data << "\t" << yearData << "\t" << payData << endl;
			break;
		}
	}
}

void ArrayT::deleteRegularWorker(string d_idNumber)
{
	int i;

	for (i = 0; i < flag; i++)
	{
		if (atw[i].getidNumber().compare(d_idNumber) == 0)
		{
			atw[i] = atw[i + 1];
			break;
		}
	}
	flag--;
}

void ArrayT::modifyRegularWorker(string m_idNumber)
{
	int i;
	string s_data;
	int i_data;

	for (i = 0; i < flag; i++)
	{
		if (atw[i].getidNumber().compare(m_idNumber) == 0)
		{
			//¼öÁ¤


			cout << "======Ragular Input========" << endl;

			cout << "Name Input : " << endl;
			cin >> s_data;
			atw[i].setName(s_data);

			cout << "IdNumber Input" << endl;
			cin >> s_data;
			atw[i].setIdNumber(s_data);

			cout << "Position Input" << endl;
			cin >> s_data;
			atw[i].setPosition(s_data);

			cout << "Gender Input" << endl;
			cin >> s_data;
			atw[i].setGender(s_data);

			cout << "Depart Input" << endl;
			cin >> s_data;
			atw[i].setDepart(s_data);

			cout << "Email Input" << endl;
			cin >> s_data;
			atw[i].setEmail(s_data);

			cout << "Bank Input" << endl;
			cin >> s_data;
			atw[i].setBank(s_data);

			cout << "Account Input" << endl;
			cin >> s_data;
			atw[i].setAccount(s_data);

			cout << "Address Input" << endl;
			cin >> s_data;
			atw[i].setAddress(s_data);

			cout << "Age Input" << endl;
			cin >> i_data;
			atw[i].setAge(i_data);

			cout << "Pay Input" << endl;
			cin >> i_data;
			atw[i].setPay(i_data);
			break;
		}
	}
}