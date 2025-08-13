// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_03_demo.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > null");
  double *p = new double;
  cout << "Въведете число: ";
  cin >> *p;
  cout << "Прочетено: " << *p << endl;
  double const *pc = new const double(9876.5);
  cout << "Константа: " << *pc << endl;
  delete pc;
  pc = new const double(*p);
  cout << "Константа: " << *pc << endl;
  delete pc;
  pc = NULL;
  if (pc != NULL) cout << "Константа: " << *pc << endl;
  if (pc) cout << "Константа: " << *pc << endl;
  delete p;
  p = NULL;
  int n = 5;
  const int Len = n;
    // константа може да се инициализира с променлива
  long *ar = new long[Len] { 11, 22, 33, 44 };
  cout << "Масив от изменяеми стойности:\n";
  for (int i = 0; i < Len; ++i) cout << " " << ar[i];
  cout << endl;
  delete[] ar;
  ar = NULL;
  const int LenC = 7;
  const long *arC = new const long[LenC] { -1, -2, -3, -4 };
  cout << "Масив от константи:\n";
  for (int i = 0; i < LenC; ++i) cout << " " << arC[i];
  cout << endl;
  delete[] arC;
  arC = NULL;
}
