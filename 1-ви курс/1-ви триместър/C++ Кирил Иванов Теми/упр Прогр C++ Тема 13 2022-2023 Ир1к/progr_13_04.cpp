// Програмиране с езика C++ за И, редовно, първи курс
// Тема 13. Двумерни масиви
// Файл progr_13_04.cpp
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned)time(NULL));
  const int rowsNum = 5, columnsNum = 10, width = 5;
  int tabl[rowsNum][columnsNum];
  for (auto& row : tabl)
    for (auto& elm : row)
      elm = rand() % 46 - 15;
  for (auto& r : tabl) {
    for (auto elm : r)
      cout << setw(width) << elm;
    cout << endl;
  }
  cout << "\n\n\n";
  int num[columnsNum] = { 0 };
  for (auto& r : tabl) {
    for (int c = 0; c < columnsNum; ++c)
      if (r[c] % 2) cout << setw(width) << r[c];
      else {
        ++num[c];
        cout << setw(width) << "...";
      }
    cout << endl;
  }
  cout << "Броеве на многоточията в колоните:\n";
  for (auto elm : num)
    cout << setw(width) << elm;
  cout << endl;
}
