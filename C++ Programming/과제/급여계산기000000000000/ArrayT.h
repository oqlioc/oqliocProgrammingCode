#pragma once
#include <iostream>
#include <string>
#include "ArrayR.h"
#include "R.h"
#include "T.h"

#include "Data .h"
#include "ArrayT.h"
using namespace std;

class ArrayT
{
	RegularWorker atw[100];
	int flag;
	string data;
	int yearData;
	int payData;

public:

	ArrayT()
	{
		flag = 0;
	}


	void setRegularWorker(RegularWorker tw);

	void getRegularWorker();

	void searchRegularWorker(string s_idNumber);

	void deleteRegularWorker(string d_idNumber);

	void modifyRegularWorker(string m_idNumber);

};
