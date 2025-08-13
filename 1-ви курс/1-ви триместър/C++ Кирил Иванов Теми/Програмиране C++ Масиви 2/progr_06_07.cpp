// Програмиране с езика C++
// Задача 6.7. Файл progr_06_07.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  const int Len = 12;
  int ar[Len];
  for (int &e : ar)
    cout << " " << (e = rand() % 11);
  cout << endl;
  double average = 0;
  for (int elm : ar)
    average += elm;
  average /= Len;
  int Last = Len - 1;
  while (ar[Last] > average)
    --Last;
  cout << "Средно аритметично: " << average << endl
       << "Индекс: " << Last << endl;
}
