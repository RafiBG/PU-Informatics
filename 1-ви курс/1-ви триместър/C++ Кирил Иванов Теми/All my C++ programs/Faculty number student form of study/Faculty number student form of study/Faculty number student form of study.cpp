#include <iostream>
#include <string>
#include <vector>
#include <conio.h>
#include <sstream>
using namespace std;

int main()
{
    system("chcp 1251 > nul");
    string last_fourth_num;
    cout << "Моля въведете факултетен номер: ";
    cin >> last_fourth_num;
    int digits = last_fourth_num.length();
    if (digits = 8) 
    {
        //cout << "The fourt digit is : " << last_fourth_num[4];
        int num = last_fourth_num[4] - '0';
        if (num == 1)
        {
            cout << "Редовна форма";
        }
        else if(num == 2)
        {
            cout << "Задочна форма";
        }
    }
   return 0;
}