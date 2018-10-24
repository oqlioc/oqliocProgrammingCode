#define _CRT_SECURE_NO_WARNINGS//#pragma warning(disable:4996)
#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class Data
{
	string name;   //이름
	string idNumber;   //사원번호
	string position;   //직급
	string depart;   //부서
	string gender;   //성별
	string email;   //이메일
	string bank;   //은행
	string account;   //계좌
	string address;   //주소
	int age;   //나이
	int year;   //연도
	int time;   //시간
	int pay;   //급여
	int calcedpay;

public:

	int type1;
	int type2;
	int type3;
	char typ1[100];
	char typ2[100];
	char typ3[100];

	//constructor
	Data()
	{
		name = " ";
		idNumber = " ";
		position = " ";
		depart = " ";
		gender = " ";
		email = " ";
		bank = " ";
		account = " ";
		address = " ";
		age = 0;
		year = 0;
		time = 0;
		pay = 0;
		calcedpay = 0;
	}
	//destructor
	~Data() {}

	//setter
	void setName(string name)
	{
		this->name = name;
	}
	void setIdNumber(string idNumber)
	{
		this->idNumber = idNumber;
	}
	void setPosition(string position)
	{
		this->position = position;
	}
	void setDepart(string depart)
	{
		this->depart = depart;
	}
	void setGender(string gender)
	{
		this->gender = gender;
	}
	void setEmail(string email)
	{
		this->email = email;
	}
	void setBank(string bank)
	{
		this->bank = bank;
	}
	void setAccount(string account)
	{
		this->account = account;
	}
	void setAddress(string address)
	{
		this->address = address;
	}
	void setAge(int age)
	{
		this->age = age;
	}
	void setYear(int year)
	{
		this->year = year;
	}
	void setTime(int time)
	{
		this->time = time;
	}
	void setPay(int pay)
	{
		this->pay = pay;
	}
	void setCalcedPay(int calcedpay)
	{
		this->calcedpay = calcedpay;
	}



	//getter
	string getName()const
	{
		return name;
	}
	string getIdNumber()const
	{
		return idNumber;
	}
	string getPosition()const
	{
		return position;
	}
	string getDepart()const
	{
		return depart;
	}
	string getGender()const
	{
		return gender;
	}
	string getEmail()const
	{
		return email;
	}
	string getBank()const
	{
		return bank;
	}
	string getAccount()const
	{
		return account;
	}
	string getAddress()const
	{
		return address;
	}
	int getAge()const
	{
		return age;
	}
	int getYear()const
	{
		return year;
	}
	int getTime()const
	{
		return time;
	}
	int getPay()const
	{
		return pay;
	}
	virtual int getCalcedPay() const
	{
		return calcedpay;
	}

};



class RegularWorker : public Data
{

public:
	//calced payment
	virtual int getCalcedPay()const
	{
		return Data::getPay() - ((Data::getPay() / 100 * 4.5) + (Data::getPay() / 100 * 3.12) + (Data::getPay() / 100 * 0.65));
	}
};



class TemporaryWorker : public Data
{

public:
	//calced temporary payment
	virtual int getCalcedPay()const
	{
		return Data::getPay() * Data::getTime();;
	}
};

class ArrayR
{
	Data* arw[100];   //사원 수 100명 배열
	int flag;   //배열 인덱스. 객체 생성시 증가
	string data;   //문자열 데이터 
	int ageData;   //나이
	int yearData;   //년도
	int payData;   //급여
	int payrData;   //계산된 급여
	
	int typ1;
	int typ2;
	int typ3;
	int typ4;
	int typ5;
	char type1[100];
	char type2[100];
	char type3[100];
	char type4[100];
	char type5[100];
	char type6[100];
	char type7[100];


public:
	ArrayR()
	{
		flag = 0;
		ageData = 0;
		yearData = 0;
		payData = 0;
		payrData = 0;
	}

	void setWorkerData(Data* rw)   //배열에 객체 삽입
	{
		arw[flag] = rw;
		flag++;
	}

	void getWorkerData()   //정규직 모든 객체의 data 출력
	{
		FILE* fp = fopen("user.txt", "r");
		int i;

		for (i = 0; i < flag; i++)
		{
			cout << "\n";
			fscanf(fp, "%s", &type1);
			cout << " Name : " << type1 << endl;
			fscanf(fp, "%d", &typ1);
			cout << " IdNumber : " << typ1 << endl;
			fscanf(fp, "%s", &type2);
			cout << " Position : " << type2 << endl;
			fscanf(fp, "%s", &type3);
			cout << " Gender : " << type3 << endl;
			fscanf(fp, "%s", &type4);
			cout << " Depart : " << type4 << endl;
			fscanf(fp, "%s", &type5);
			cout << " Email : " << type5 << endl;
			fscanf(fp, "%s", &type6);
			cout << " Bank : " << type6 << endl;
			fscanf(fp, "%d", &typ2);
			cout << " Account : " << typ2 << endl;
			fscanf(fp, "%s", &type7);
			cout << " Address : " << type7 << endl;
			fscanf(fp, "%d", &typ3);
			cout << " Age : " << typ3 << endl;
			fscanf(fp, "%d", &typ4);
			cout << " Year : " << typ4 << endl;
			fscanf(fp, "%d", &typ5);
			cout << " Pay : " << typ5 << endl;

		}
		fclose(fp);
		
	}

	void getSearchWorkerData(string s_idNumber)   //idNumber로 검색
	{
		int i;

		for (i = 0; i < flag; i++)
		{
			if ((*arw[i]).getIdNumber().compare(s_idNumber) == 0)   //비교
			{
				data = (*arw[i]).getName() + "\t" + (*arw[i]).getIdNumber() + "\t"
					+ (*arw[i]).getGender() + "\t" + (*arw[i]).getDepart() + "\t" + (*arw[i]).getPosition()
					+ "\t" + (*arw[i]).getEmail();

				ageData = (*arw[i]).getAge();
				yearData = (*arw[i]).getYear();
				payData = (*arw[i]).getPay();
				payrData = (*arw[i]).getCalcedPay();

				cout << data << "\t" << ageData << "\t" << yearData << "\t" << payData << "\t" << payrData << endl;
				break;
			}


		}
	}

	void getDeleteWorkerData(string d_idNumber)
	{
		int i, j;

		for (i = 0; i < flag; i++)
		{
			if ((*arw[i]).getIdNumber().compare(d_idNumber) == 0)
			{
				for (j = i; j < flag; j++)
				{
					arw[j] = arw[j + 1];
				}
				//마지막 [j+1]자리 data를 초기화
				(*arw[j + 1]).setName(" ");
				(*arw[j + 1]).setIdNumber(" ");
				(*arw[j + 1]).setPosition(" ");
				(*arw[j + 1]).setGender(" ");
				(*arw[j + 1]).setDepart(" ");
				(*arw[j + 1]).setEmail(" ");
				(*arw[j + 1]).setBank(" ");
				(*arw[j + 1]).setAccount(" ");
				(*arw[j + 1]).setAddress(" ");
				(*arw[j + 1]).setAge(0);
				(*arw[j + 1]).setYear(0);
				(*arw[j + 1]).setPay(0);
				(*arw[j + 1]).setCalcedPay(0);
			}
		}
		flag--;
	}
	void getModifyWorkerData(string m_idNumber)
	{
		string s_data;
		int i_data;
		int i;

		for (i = 0; i < flag; i++)
		{
			if ((*arw[i]).getIdNumber().compare(m_idNumber) == 0)
			{
				cout << "======Ragular Input========" << endl;

				cout << "Name Input : " << endl;
				cin >> s_data;
				(*arw[i]).setName(s_data);

				cout << "IdNumber Input" << endl;
				cin >> s_data;
				(*arw[i]).setIdNumber(s_data);

				cout << "Position Input" << endl;
				cin >> s_data;
				(*arw[i]).setPosition(s_data);

				cout << "Gender Input" << endl;
				cin >> s_data;
				(*arw[i]).setGender(s_data);

				cout << "Depart Input" << endl;
				cin >> s_data;
				(*arw[i]).setDepart(s_data);

				cout << "Email Input" << endl;
				cin >> s_data;
				(*arw[i]).setEmail(s_data);

				cout << "Bank Input" << endl;
				cin >> s_data;
				(*arw[i]).setBank(s_data);

				cout << "Account Input" << endl;
				cin >> s_data;
				(*arw[i]).setAccount(s_data);

				cout << "Address Input" << endl;
				cin >> s_data;
				(*arw[i]).setAddress(s_data);

				cout << "Age Input" << endl;
				cin >> i_data;
				(*arw[i]).setAge(i_data);

				cout << "Year Input" << endl;
				cin >> i_data;
				(*arw[i]).setYear(i_data);

				cout << "Pay Input" << endl;
				cin >> i_data;
				(*arw[i]).setPay(i_data);

				break;
			}
		}
	}
};


void main()
{
	Data* data = NULL;

	ArrayR arw;

	string MemberNum;
	int adminMenuNum;
	int usernum;
	int inputnum;
	int workerNum;
	string yn;
	char ans;
	string s_data;
	int i_data;

	string s_idNumber;// 검색 이름
	string d_idNumber;// 삭제 이름
	string m_idNumber;// 수정 이름

	ofstream fout;

	fout.open("Pl.txt", ios::app);

	while (1) {

		cout << "enter the passward: " << endl;
		cin >> MemberNum;

		if (MemberNum.compare("000") == 0)
		{
			do {
				cout << "<Administrator Mode>" << endl;
				cout << "■ * * * * * * * ■" << endl;
				cout << "*  Select Menu  *" << endl;
				cout << "*  1. Input     *" << endl;
				cout << "*  2. Output    *" << endl;
				cout << "*  3. Search    *" << endl;
				cout << "*  4. Delete    *" << endl;
				cout << "*  5. Modify    *" << endl;
				cout << "*  6. Exit    *" << endl;
				cout << "■ * * * * * * * ■" << endl;
				cout << "Menu num : " << endl;

				cin >> adminMenuNum;

				switch (adminMenuNum) {
				case 1:
					cout << "**Employed Type Select**" << endl;
					cout << "1. Regular Worker" << endl;
					cout << "2. Temporary Worker" << endl;
					cin >> workerNum;
					switch (workerNum)
					{
					case 1:
						data = new RegularWorker;
						break;
					case 2:
						data = new TemporaryWorker;
						break;
					}
					cout << "======Data Input========" << endl;

					cout << "Name Input : " << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setName(s_data);

					cout << "IdNumber Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setIdNumber(s_data);

					cout << "Position Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setPosition(s_data);

					cout << "Gender Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setGender(s_data);

					cout << "Depart Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setDepart(s_data);

					cout << "Email Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setEmail(s_data);

					cout << "Bank Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setBank(s_data);

					cout << "Account Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setAccount(s_data);

					cout << "Address Input" << endl;
					cin >> s_data;
					fout << s_data << endl;
					data->setAddress(s_data);

					cout << "Age Input" << endl;
					cin >> i_data;
					fout << i_data << endl;
					data->setAge(i_data);

					cout << "Year Input" << endl;
					cin >> i_data;
					fout << i_data << endl;
					data->setYear(i_data);

					cout << "Time Input" << endl;
					cin >> i_data;
					fout << i_data << endl;
					data->setTime(i_data);


					cout << "Pay Input" << endl;
					cin >> i_data;
					fout << i_data << endl;
					data->setPay(i_data);

					arw.setWorkerData(data);

					break;
				case 2:   // 출력
					cout << "<OUTPUT>" << endl;
					cout << "[Worker Data]" << endl;
					arw.getWorkerData();

					break;

				case 3:   // 검색
					cout << "<Search>" << endl;
					cout << "Enter Search MemberNum : " << endl;
					cin >> s_idNumber;
					cout << "[Searched Information]" << endl;
					arw.getSearchWorkerData(s_idNumber);
					break;

				case 4:   // 삭제

					cout << "<Delete>" << endl;
					cout << "Enter Delete MemberNum : " << endl;
					cin >> d_idNumber;
					arw.getDeleteWorkerData(d_idNumber);
					cout << "Delete Done!" << endl;
					break;

				case 5: // 수정
					cout << "<Modify>" << endl;
					cout << "Enter Modify MemberNum : " << endl;
					cin >> m_idNumber;
					arw.getModifyWorkerData(m_idNumber);
					break;
				case 6:
					break;
				default:
					cout << "Wrong Input!" << endl;;
					break;


				}

				cout << "계속하시겠습니까" << endl;
				cin >> ans;

			} while (ans == 'Y' || ans == 'y');
		}
		else
		{

			cout << "<User Mode>" << endl;
			cout << "■ * * * * * * * ■" << endl;
			cout << "*  Select Menu  *" << endl;
			cout << "*  1. View      *" << endl;
			cout << "*  2. Exit      *" << endl;
			cout << "■ * * * * * * * ■" << endl;
			cout << " Menu num : " << endl;
			cin >> usernum;

			switch (usernum) {
			case 1:
				cout << "<User Search>" << endl;
				cout << "Enter Search MemberNum : " << endl;
				cin >> s_idNumber;
				cout << "[Searched Information]" << endl;
				arw.getSearchWorkerData(s_idNumber);
				break;

			case 2:

				break;
			}


		}
		cout << "나가시겠습니까?" << endl;
		cin >> ans;
	}while (ans == 'Y' || ans == 'y');
	cout << "BYE";
	fout.close();
	delete data;
}