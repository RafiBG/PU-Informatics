// Програмиране с езика C++
// Задача 6.8. Файл progr_06_08.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  const int Len = 7;
  int ar[Len];
  for (int &e : ar)
    cout << " " << (e = rand() % 18 - 9);
  cout << endl;
  for (int i = 0, k, num; i < Len; ++i) {
    k = 0;
    while (ar[k] != ar[i])
      ++k;
    if (k < i) continue;
    num = 1;
    for (k = Len - 1; k > i; --k)
      if (ar[k] == ar[i]) ++num;
    cout << "Елемент: " << ar[i] << ". Брой срещания: " << num << endl;
  }
}
