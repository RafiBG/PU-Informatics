// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_05_demo.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  long i = 12345, j = - 98;
  long & ri = i;
  cout << "i -> " << i << endl;
  cout << "j -> " << j << endl;
  cout << "ri -> " << ri << endl;
  ri = j;
  j = 22334455;
  cout << "i -> " << i << endl;
  cout << "j -> " << j << endl;
  cout << "ri -> " << ri << endl;
  long ar[] = { 1, 2, 3, 4, 555 };
  long &refAr4 = ar[4];
  cout << "ar[4] -> " << ar[4] << endl;
  cout << "refAr4 -> " << refAr4 << endl;
  cout << "---------------\n";
  for (int k = 1; k <= 2; ++ k) {
    long & ref = 1 == k ? i : j;
    cout << "ref -> " << ref << endl;
  }
  cout << "==============\n";
  long && rRV = j / 1000 % 100;
  cout << "rRV -> " << rRV << endl;
  rRV = - 20;
  cout << "rRV -> " << rRV << endl;
}
