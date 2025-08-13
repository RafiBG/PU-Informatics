// Програмиране с езика C++
// Задача 6.9. Файл progr_06_09.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand((unsigned) time(NULL));
  const int Len = 10;
  int ar[Len];
  for (int &e : ar)
    cout << " " << (e = rand() % 26 - 10);
  cout << endl;
  int nextOdd = 0, predOdd = 0;
  for (int i = Len - 1; i > 1; --i)
    if (ar[i] % 2) ++nextOdd;
  for (int i = 1; i < Len; ++i) {
    if (predOdd == nextOdd)
      cout << ar[i - 1] << " ; " << ar[i] << endl;
    if (ar[i - 1] % 2) ++predOdd;
    if (ar[i + 1] % 2) --nextOdd;
  }
}
