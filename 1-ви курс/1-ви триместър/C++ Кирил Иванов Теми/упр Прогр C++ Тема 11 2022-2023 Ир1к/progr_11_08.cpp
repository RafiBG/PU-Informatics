// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_08.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  int const Len = 15;
  int ar[Len];
  for (auto &ref : ar) {
    ref = rand() % 51 - 20;
    cout << "  " << ref;
  }
  cout << endl << "Нечетни елементи:\n";
  for (auto &ref : ar)
    if(ref % 2)
      cout << "  " << ref;
  cout << "\n  (край на нечетните елементи)\n" << endl;
}
