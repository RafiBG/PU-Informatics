#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    /*Направете програма, подпомагаща един 
    бояджия колко кутии боя трябва да купи 
    за една стая (нека стаите са само с 4 стени).

    1 кутия е достатъчна за боядисването на 3 кв. м.
    площ. Изходът от програмата трябва да бъде цяло 
    число, показващо необходимия брой кутии.*/

    double paint_area;
    cout << "What is the area in square feet?  ";
    cin >> paint_area;
    int can_area = 300;
    int cans = ceil(paint_area / can_area);
    cout << "\n"; // Използвам ги за разтояние визуално. Знам че може и без тях.
    cout << "The number of cans of paint required is: " << cans;
    cout << "\n";
    return 0;
}

