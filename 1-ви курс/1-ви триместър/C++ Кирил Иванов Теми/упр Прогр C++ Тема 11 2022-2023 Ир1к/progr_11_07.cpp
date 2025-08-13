// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_07.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  int const Len = 10;
  int ar[Len];
  for (auto &r : ar)
    r = rand() % 51 - 20;
  for (auto r : ar)
    cout << "  " << r;
  cout << endl;
  int iMin = 0, *pMax = ar;
  for (int i = 1; i < Len; ++i)
    if (ar[iMin] > ar[i]) iMin = i;
    else if ( * pMax < ar[i]) pMax = ar + i;
  int & min = ar[iMin], & max = * pMax;
  cout << "Минимум: " << min << "\nМаксимум: " << max << endl;
}
