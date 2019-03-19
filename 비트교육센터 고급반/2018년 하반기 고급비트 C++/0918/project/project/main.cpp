#include<iostream>
#include<string>
static int c = 0;
using namespace std;

class UserDB {

   string name;
   string position;
   string department;
   int userNum;
   int password;
   double salary;
   int age;

public:

   UserDB()
   {

   }

   void setName(string name)
   {
      this->name = name;
   }
   string getName()const {
      return name;
   }


   void setAge(int age)
   {
      this->age = age;
   }
   int getAge()const {
      return age;
   }

   void setNum(int userNum)
   {
      this->userNum = userNum;
   }
   int getNum()const {

      return userNum;
   }

   void setPass(int password)
   {
      this->password = password;
   }
   int getPass()const {

      return password;
   }

   void setDepartment(string department)
   {
      this->department = department;
   }
   string getDepartment()const {
      return department;
   }

   void setPosition(string position)
   {
      this->position = position;
   }
   string getPosition()const {
      return position;
   }
   void setSalary(double salary)
   {
      this->salary = salary;
   }
   double getSalary()const {
      return salary;
   }


}; // UserDB class

class setUser {

   UserDB *userdb;
   string name;
   string position;
   string department;
   int userNum;
   int password;
   double salary;
   int age;

public:

   setUser(UserDB *userdb) {
      this->userdb = userdb;

   }
   setUser() {

      cout << "��� �̸��� �Է��ϼ���:";
      cin >> name;
      setUserName(name);

      cout << "������ �Է��ϼ���:";
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

      cout << "�޿��� �Է��ϼ���:";
      cin >> salary;
      setUserSalary(salary);

      cout << "���̸� �Է��ϼ���:";
      cin >> age;
      setUserAge(age);

      cout << "*����ڰ� �߰��Ǿ����ϴ�.*" << endl;



   }// ����� ���

   void setUserName(string name) {
      userdb[c].setName(name);
   }
   void setUserPosition(string position) {
      userdb[c].setPosition(position);
   }
   void setUserDepartment(string department) {
      userdb[c].setDepartment(department);
   }

   void setUserNum(int userNum) {
      userdb[c].setNum(userNum);
   }

   void setUserPass(int pass) {
      userdb[c].setPass(pass);
   }
   void setUserSalary(double salary) {
      userdb[c].setSalary(salary);
   }
   void setUserAge(int age) {
      userdb[c].setAge(age);

   }



};

class Admin {

   UserDB userdb[100];
   setUser setUser;
   string adminID;
   int pass;


public: Admin() {

   adminID = "admin";
   pass = 0000;

}
      bool loginID(string adminID) {
         if (this->adminID == adminID)
            return true;
         else return false;
      }
      bool loginPass(int pass) {
         if (this->pass == pass)
            return true;
         else return false;

      }// ������ �α��� 

      void adminMode() {

         int a;
         cout << "[������ ����Դϴ�.] " << endl;
         cout << "1. ����� �߰� 2. ����� ��ȸ 3. ����� ���� 4. ����� ��������" << endl;
         switch (a) {
         case 1:setUser.setUserDB(); break;
         case 2:break;
         case 3:break;
         case 4:break;
         default: break;



         }


      }// ������ Ŭ���� �޴�

      void setUserDB() {

         //userdb 

      }// ����� ���



}; // Admin class

class User { // �α��ΰ� ��ȸ

   UserDB userdb[100];
   string userID;
   int pass;

public:
   User() {
	   
	   userID = "user";
	   pass = 0000;


   }
   

   bool loginID(string userID) {
	    if (this->userID == userID)
            return true;
         else return false;
	}
   
   bool loginPass(int pass) {
         if (this->pass == pass)
            return true;
         else return false;
   }

   void userMode() { 
	 	 int b;
	     cout << "[����� ����Դϴ�.] " << endl;
         cout << " 1. ������ 2. �������� " << endl;
         switch (b) {
         case 1: break;
         case 2: break;
         default: break;
						
		 }
}


}; // User Class


class Menu {

   Admin admin;
   User user;

   string adminID;
   int adminPass;
   
	string userID;
	int userPass;
   int a;

public: Menu() {


   cout << "==== �޿����� ���α׷��Դϴ�.====" << endl;
   cout << "1. ������ ���  " << "\t" << "2. ����� ���" << endl;
   cin >> a;

   while (1) {

      switch (a) {

      case 1:
      {
         cout << "������ID�� �Է��ϼ���:";
         cin >> adminID;

         if (admin.loginID(adminID)) {

            cout << "��й�ȣ�� �Է��ϼ���";
            cin >> adminPass;

            if (admin.loginPass(adminPass)) {


               cout << "������ �α���~" << endl;
               //������ �α��θ��
               admin.adminMode();

            }


            else {
               cout << "��й�ȣ�� Ʋ�Ƚ��ϴ�." << endl; continue;
            }
         }
         else {
            cout << "������ID�� Ʋ�Ƚ��ϴ�." << endl; continue;
         }
      }break;

      case 2:
      {
         cout << "�����ID�� �Է��ϼ���:";
         cin >> userID;

         if (user.loginID(userID)) {

            cout << "��й�ȣ�� �Է��ϼ���";
            cin >> userPass;

            if (user.loginPass(userPass)) {


               cout << "����� �α���~" << endl;
               //������ �α��θ��
               user.userMode();

            }


            else {
               cout << "��й�ȣ�� Ʋ�Ƚ��ϴ�." << endl; continue;
            }
         }
         else {
            cout << "�����ID�� Ʋ�Ƚ��ϴ�." << endl; continue;
         }
      }break;

      default:cout << "�߸��� �Է��Դϴ�." << endl; break;

      }


   }


}



};

int main() {

   Menu menu;

}