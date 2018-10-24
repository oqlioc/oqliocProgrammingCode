#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"

#include "Data .h"
#include "ArrayT.h"
using namespace std;

class ArrayR
{
	RegularWorker arw[100];
	int flag;
	string data;
	int yearData;
	int payData;

public:

	ArrayR()
	{
		flag = 0;
	}

	void setRegularWorker(RegularWorker rw);

	void getRegularWorker();

	void searchRegularWorker(string s_idNumber);

	void deleteRegularWorker(string d_idNumber);

	void modifyRegularWorker(string m_idNumber);

};