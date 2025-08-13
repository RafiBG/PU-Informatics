// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_02_demo.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > null");
  int const LenR = 3, LenC = 4;
  int tabl[LenR][LenC] = { { 11, 22, 33, 44 },
                           { -1, -2, -3, -4 },
                           {  6,  7,  8,  9 } };
  cout << "typeid(tabl).name() -> " << typeid(tabl).name() << endl;
  cout << "typeid(tabl[0]).name() -> " << typeid(tabl[0]).name() << endl;
  cout << "typeid(& tabl[1]).name() -> " << typeid(&tabl[1]).name() << endl;
  int (*rowU)[LenC] = &tabl[2];
  rowU = tabl + 2;
  cout << "typeid(rowU).name() -> " << typeid(rowU).name() << endl;
  cout << "typeid(tabl + 2).name() -> " << typeid(tabl + 2).name() << endl;

  for (int c = 0; c < LenC; ++c) cout << "__" << tabl[2][c];
  cout << endl;
  for (int elm : tabl[2]) cout << "__" << elm;
  cout << endl;
  int * p = tabl[2];
  for (int i = 0; i < LenC; ++i) cout << "__" << p[i];
  cout << endl;
  rowU = tabl + 2;
  for (int elm : *rowU) cout << "__" << elm;
  cout << endl;
  cout << "------------\n";
  int (*mU[LenR])[LenC] = { tabl, tabl + 1, tabl + 2 };
  for(auto ar : mU)
  {
    for (int num : *ar) cout << "  " << num;
    cout << endl;
  }
}
