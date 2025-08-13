// Програмиране с езика C++
// Задача 6.4. Файл progr_06_04.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand((unsigned) time(NULL));
  const int Len = 20;
  int ar[Len];
  for (int & elm : ar)
    cout << " " << (elm = rand() % 41 - 10);
  cout << endl;
  for(int i = 0; i < Len; ++i)
    if( ar[i] % 2 ) cout << " " << ar[i];
    else if( i > 0 && ar[i - 1] % 2 ) cout << endl;
  cout << endl;
}
