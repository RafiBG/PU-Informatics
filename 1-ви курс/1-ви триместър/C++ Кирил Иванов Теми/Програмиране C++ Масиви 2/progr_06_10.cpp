// Програмиране с езика C++
// Задача 6.10. Файл progr_06_10.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand((unsigned) time(NULL));
  const int Len = 10;
  int ar[Len];
  for (int &e : ar)
    cout << " " << (e = rand() % 21);
  cout << endl;
  for (int L = 0, oddL = 0, R = Len -1, oddR = 0; L < R; ++L, --R) {
    if (oddL == oddR)
      cout << ar[L] << " ; " << ar[R] << endl;
    if (ar[L] % 2) ++oddL;
    if (ar[R] % 2) --oddR;
  }
}
