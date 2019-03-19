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

      cout << "급여를 입력하세요:";
      cin >> salary;
      setUserSalary(salary);

      cout << "나이를 입력하세요:";
      cin >> age;
      setUserAge(age);

      cout << "*사용자가 추가되었습니다.*" << endl;



   }// 사용자 등록

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

      }// 관리자 로그인 

      void adminMode() {

         int a;
         cout << "[관리자 모드입니다.] " << endl;
         cout << "1. 사용자 추가 2. 사용자 조회 3. 사용자 삭제 4. 사용자 정보수정" << endl;
         switch (a) {
         case 1:setUser.setUserDB(); break;
         case 2:break;
         case 3:break;
         case 4:break;
         default: break;



         }


      }// 관리자 클래서 메뉴

      void setUserDB() {

         //userdb 

      }// 사용자 등록



}; // Admin class

class User { // 로그인과 조회

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
	     cout << "[사용자 모드입니다.] " << endl;
         cout << " 1. 정규직 2. 비정규직 " << endl;
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


   cout << "==== 급여관리 프로그램입니다.====" << endl;
   cout << "1. 관리자 모드  " << "\t" << "2. 사용자 모드" << endl;
   cin >> a;

   while (1) {

      switch (a) {

      case 1:
      {
         cout << "관리자ID를 입력하세요:";
         cin >> adminID;

         if (admin.loginID(adminID)) {

            cout << "비밀번호를 입력하세요";
            cin >> adminPass;

            if (admin.loginPass(adminPass)) {


               cout << "관리자 로그인~" << endl;
               //관리자 로그인모드
               admin.adminMode();

            }


            else {
               cout << "비밀번호가 틀렸습니다." << endl; continue;
            }
         }
         else {
            cout << "관리자ID가 틀렸습니다." << endl; continue;
         }
      }break;

      case 2:
      {
         cout << "사용자ID를 입력하세요:";
         cin >> userID;

         if (user.loginID(userID)) {

            cout << "비밀번호를 입력하세요";
            cin >> userPass;

            if (user.loginPass(userPass)) {


               cout << "사용자 로그인~" << endl;
               //관리자 로그인모드
               user.userMode();

            }


            else {
               cout << "비밀번호가 틀렸습니다." << endl; continue;
            }
         }
         else {
            cout << "사용자ID가 틀렸습니다." << endl; continue;
         }
      }break;

      default:cout << "잘못된 입력입니다." << endl; break;

      }


   }


}



};

int main() {

   Menu menu;

}