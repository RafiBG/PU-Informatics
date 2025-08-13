// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_04.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  int const Len = 10;
  int ar[Len];
  for (int i = 0; i < Len; ++i) ar[i] = rand() % 8 * 2 - 5;
  cout << "Първи масив:\n";
  for (int elm : ar) cout << "  " << elm;
  cout << endl;
  int num = 0;
  for (int elm : ar) if (elm < 0) ++num;
  const int negLen = num;
  int *arNeg = new int[negLen];
  for (int pos = 0, i = 0; i < Len; ++i)
    if (ar[i] < 0)
      arNeg[pos++] = ar[i];
  cout << "Втори масив:\n";
  for (int i = 0; i < negLen; ++i) cout << "  " << arNeg[i];
  cout << endl;
  delete[] arNeg;
  arNeg = NULL;
}
