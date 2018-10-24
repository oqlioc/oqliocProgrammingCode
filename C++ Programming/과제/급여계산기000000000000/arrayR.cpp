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

void ArrayR::setRegularWorker(RegularWorker rw)
{
	arw[flag] = rw;
	flag++;
}

void ArrayR::getRegularWorker()
{
	int i;

	for (i = 0; i < flag; i++) {

		data = arw[i].getName() + "\t" + arw[i].getidNumber() + "\t" + arw[i].getGender() + "\t"
			+ arw[i].getDepart() + "\t" + arw[i].getPosition() + "\t" + arw[i].getEmpType() + "\t"
			+ arw[i].getAddress() + "\t" + arw[i].getBank() + "\t"
			+ arw[i].getAccount();

		yearData = arw[i].getYear();
		payData = arw[i].getPay();

		cout << data << "\t" << yearData << "\t" << payData << endl;
	}
}

void ArrayR::searchRegularWorker(string s_idNumber)
{
	int i;

	for (i = 0; i < flag; i++)
	{
		if (arw[i].getidNumber().compare(s_idNumber) == 0)
		{
			data = arw[i].getName() + "\t" + arw[i].getidNumber() + "\t" + arw[i].getGender() + "\t"
				+ arw[i].getDepart() + "\t" + arw[i].getPosition() + "\t" + arw[i].getEmpType() + "\t"
				+ arw[i].getAddress() + "\t" + arw[i].getBank() + "\t"
				+ arw[i].getAccount();

			yearData = arw[i].getYear();
			payData = arw[i].getPay();

			cout << data << "\t" << yearData << "\t" << payData << endl;
			break;
		}
	}
}

void ArrayR::deleteRegularWorker(string d_idNumber)
{
	int i;

	for (i = 0; i < flag; i++)
	{
		if (arw[i].getidNumber().compare(d_idNumber) == 0)
		{
			arw[i] = arw[i + 1];
			break;
		}
	}
	flag--;
}

void ArrayR::modifyRegularWorker(string m_idNumber)
{
	int i;
	string s_data;
	int i_data;

	for (i = 0; i < flag; i++)
	{
		if (arw[i].getidNumber().compare(m_idNumber) == 0)
		{
			//¼öÁ¤


			cout << "======Ragular Input========" << endl;

			cout << "Name Input : " << endl;
			cin >> s_data;
			arw[i].setName(s_data);

			cout << "IdNumber Input" << endl;
			cin >> s_data;
			arw[i].setIdNumber(s_data);

			cout << "Position Input" << endl;
			cin >> s_data;
			arw[i].setPosition(s_data);

			cout << "Gender Input" << endl;
			cin >> s_data;
			arw[i].setGender(s_data);

			cout << "Depart Input" << endl;
			cin >> s_data;
			arw[i].setDepart(s_data);

			cout << "Email Input" << endl;
			cin >> s_data;
			arw[i].setEmail(s_data);

			cout << "Bank Input" << endl;
			cin >> s_data;
			arw[i].setBank(s_data);

			cout << "Account Input" << endl;
			cin >> s_data;
			arw[i].setAccount(s_data);

			cout << "Address Input" << endl;
			cin >> s_data;
			arw[i].setAddress(s_data);

			cout << "Age Input" << endl;
			cin >> i_data;
			arw[i].setAge(i_data);

			cout << "Pay Input" << endl;
			cin >> i_data;
			arw[i].setPay(i_data);
			break;
		}
	}
}