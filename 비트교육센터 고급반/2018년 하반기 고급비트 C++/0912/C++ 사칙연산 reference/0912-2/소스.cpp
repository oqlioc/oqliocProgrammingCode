#include <iostream>
using namespace std;
void scan(int &num1, int &num2)
{
    cout << " 정수 입력 ";
    cin >> num1 >> num2;
}
 
void print(float res)
{
    cout << res << endl;
}
 
void fouroper(int &num1, int &num2, float &res)
{
    int fournum;
    cout << " 1 : +  ||  2 : -  ||  3 : *  ||  4 : /  ||";
    cin >> fournum;
    
    switch(fournum)
    {
    case 1 : res = num1 + num2;
        break;
    case 2 : res = num1 - num2;
        break;
    case 3 : res = num1 * num2;
        break;
    case 4 : res = (float)num1 / num2;
        break;
 
    default : " ERR ";
        break;
    }
}
 
void main()
{
    int num1, num2;
    float res;
 
    scan(num1, num2);
    fouroper(num1, num2, res);
 
    print(res);
    
}
