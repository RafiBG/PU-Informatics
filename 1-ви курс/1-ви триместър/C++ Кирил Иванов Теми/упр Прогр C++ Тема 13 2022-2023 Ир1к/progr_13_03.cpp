// Програмиране с езика C++ за И, редовно, първи курс
// Тема 13. Двумерни масиви
// Файл progr_13_03.cpp
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned)time(NULL));
  const int rows = 5, columns = 7;
  int tabl[rows][columns];
  for(auto & r : tabl)
    for(auto & elm : r)
      elm = rand() % 9 * 2 - 7;
  for(auto & r : tabl) {
    for(auto elm : r)
      cout << setw(4) << elm;
    cout << endl;
  }
}
