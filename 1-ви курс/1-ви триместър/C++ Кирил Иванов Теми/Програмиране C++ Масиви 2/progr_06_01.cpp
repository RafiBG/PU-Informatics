// Програмиране с езика C++
// Задача 6.1. Файл progr_06_01.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand((unsigned) time(NULL));
  const int N = 7;
  int p[N];
  for (int i = 0; i < N; ++i)
    p[i] = i + 1;
  for (int pos = N - 1, i, temp; pos > 0; --pos) {
    i = rand() % (1 + pos);
    temp = p[pos];
    p[pos] = p[i];
    p[i] = temp;
  }
  for (int elm : p)
    cout << "  " << elm;
  cout << endl;
}
