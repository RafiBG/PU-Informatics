// Програмиране с езика C++
// Задача 6.5. Файл progr_06_05.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));

  const int Len1 = 2, Len2 = 18;
  int ar1[Len1], ar2[Len2];
  for (int i = 0; i < Len1; ++i)
    cout << " " << (ar1[i] = rand() % 7 - 4);
  cout << endl;
  for (int &elm : ar2)
    cout << " " << (elm = rand() % 7 - 4);
  cout << endl;

  cout << "Търсени индекси: ";
  for (int first = 0, i; first <= Len2 - Len1; ++first)
    if (ar2[first] == ar1[0]) {
      i = 1;
      while (i < Len1 && ar1[i] == ar2[first + i])
        ++i;
      if (i == Len1) cout << " " << first;
    }
  cout << endl;

  // за тестване:
  int ar1a[] = { -4, 3, 0, 1 },
      ar2a[] = { -4, 3, 0, 1, -4, -4, 0, -4, 3, 0, 1 };
  const int Len1a = sizeof(ar1a) / sizeof(ar1a[0]), Len2a = sizeof(ar2a)
      / sizeof(ar2a[0]);
  for (int x : ar1a)
    cout << " " << x;
  cout << endl;
  for (int x : ar2a)
    cout << " " << x;
  cout << endl;
  cout << "Търсени индекси: ";
  for (int first = 0, i; first <= Len2a - Len1a; ++first)
    if (ar2a[first] == ar1a[0]) {
      i = 1;
      while (i < Len1a && ar1a[i] == ar2a[first + i])
        ++i;
      if (i == Len1a) cout << " " << first;
    }
  cout << endl;
}
