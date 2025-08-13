// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_01_demo.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > null");
  int ar[] = { 10, 20, 30, 40, 50 };
  int const arLen = sizeof(ar) / sizeof(ar[0]);
  for (int i = 0; i < arLen; ++i) ar[i] += 1 + i;
  for (int elm : ar) cout << "  " << elm;
  cout << endl;
  cout << "typeid(ar).name() -> " << typeid(ar).name() << endl;
  cout << "typeid(int [arLen]).name() -> " << typeid(int[arLen]).name() << endl;
  int *p = ar;
  // не може for (int elm : p), защото p е деклариран със звезда
  cout << "typeid(p).name() -> " << typeid(p).name() << endl;
  cout << "typeid(int *).name() -> " << typeid(int*).name() << endl;
  int (*arU)[arLen] = &ar;
  cout << "typeid(arU).name() -> " << typeid(arU).name() << endl;
  cout << "typeid(int(*)[arLen]).name() -> " << typeid(int (*)[arLen]).name()
      << endl;
  cout << "================\n";
  for (auto elm : ar) cout << "  " << elm;
  cout << endl;
  for (int elm : *arU) cout << "  " << elm;
  cout << endl;
  p = ar;
  for (int i = 0; i < arLen; ++i) cout << "  " << p[i];
  cout << endl;
  for (p = ar; p - ar < arLen; ++p) cout << "  " << *p;
  cout << endl;
  for (p = ar + arLen - 1; p >= ar; --p) cout << "  " << *p;
  cout << endl;
}
