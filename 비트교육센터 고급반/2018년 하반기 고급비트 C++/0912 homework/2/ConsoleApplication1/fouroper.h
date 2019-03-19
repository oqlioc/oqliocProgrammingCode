#include <iostream>
using namespace std;

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