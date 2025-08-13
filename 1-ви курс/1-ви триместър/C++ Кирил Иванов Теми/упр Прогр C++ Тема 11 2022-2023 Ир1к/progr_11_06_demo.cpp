// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_06_demo.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  long ar[] = { 11, -2, 333, 44 };
  const int Len = sizeof(ar) / sizeof(ar[0]);
  long & rElm2 = ar[2];
  cout << "ar[2] -> " << ar[2] << endl;
  cout << "rElm2 -> " << rElm2 << endl;
  for (long elm : ar)
    cout << "  " << elm;
  cout << endl;
  long (& refAr)[Len] = ar;
  for (long elm : refAr)
    cout << "  " << elm;
  cout << endl;
  for (long & elm : ar)
    elm *= 100;
  for (long elm : ar)
    cout << "  " << elm;
  cout << endl;
}
