// Програмиране с езика C++
// Задача 6.6. Файл progr_06_06.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  const int Len = 20;
  int ar[Len];
  for (int &e : ar)
    cout << " " << (e = rand() % 15 - 6);
  cout << endl;
  int fMax = 0, LenMax = 1;
  for (int i = 1, LenNext = 1; i <= Len; ++i)
    if (i == Len || ar[i - 1] >= ar[i]) {
      if (LenNext > LenMax) {
        LenMax = LenNext;
        fMax = i - LenNext;
      }
      LenNext = 1;
    }
    else ++LenNext;
  cout << "Една най-дълга възходяща редица:\n";
  for (int i = 0; i < LenMax; ++i)
    cout << "  " << ar[fMax + i];
  cout << endl;
}
