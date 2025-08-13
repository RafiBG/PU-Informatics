#include <iostream>
using namespace std;
int main()
{
    setlocale(LC_ALL, "bg");
    double mark = 5.4;  // Рафи Цигаров  Фукултетен номер : 2201261077
    if (mark >= 5.5)    // Как се очаква да напишем задачата на един ред ?
    {
        cout << "Има стипендия." << endl;
    }
    else
    {
        cout << "Няма стипендия" << endl;
    }
}