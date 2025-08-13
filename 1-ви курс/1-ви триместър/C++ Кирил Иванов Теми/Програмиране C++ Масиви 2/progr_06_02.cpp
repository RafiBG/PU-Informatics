// Програмиране с езика C++
// Задача 6.2. Файл progr_06_02.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand((unsigned) time(NULL));
  const int k = 4;
  int odd[k], pos = 0, i;
  do {
    odd[pos] = rand() % 11 - 5;
    cout << "  " << odd[pos];
    if (odd[pos] % 2) {
      i = 0;
      while(odd[i] != odd[pos]) ++i;
      if(i == pos) ++pos;
    }
  } while (pos < k);
}
