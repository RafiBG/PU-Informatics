// Програмиране с езика C++
// Задача 6.3. Файл progr_06_03.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  const int Len = 16;
  int nums[Len];
  for (int i = 0; i < Len; ++i) {
    nums[i] = rand() % 12 - 5;
    cout << " " << nums[i];
  }
  cout << endl;
  int N, k;
  cout << "Търсено число: ";
  cin >> N;
  do {
    cout << "Брой срещания: ";
    cin >> k;
  } while (k < 1);
  int kNum = 0, i;
  for (i = 0; kNum < k && i < Len; ++i)
    if (nums[i] == N) ++kNum;
  if (kNum == k)
    cout << "Индекс на " << k << "-то срещане: " << i - 1 << endl;
  else
    cout << "Няма " << k << " срещания.\n";
}
