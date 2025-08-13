// Програмиране с езика C++ за И, редовно, първи курс
// Тема 14. Въведение във функции.
//          Параметри от примитивен тип и от тип указател към
//          или псевдоним на примитивна стойност
// Файл progr_14_02.cpp

#include <iostream>
using namespace std;

int countOdd( long long n1, long long n2, long long n3,
              long long n4 )
{
  return abs(n1 % 2) + abs(n2 % 2)
         + (n3 % 2 != 0) + (n4 % 2 != 0);
}

int main( ) {
  system("chcp 1251 > nul");
  int a, b, c, d;
  cout << "Четири цели числа: ";
  cin >> a >> b >> c >> d;

  cout << "Брой нечетни: " << countOdd(a, b, c, d) << endl;

  void viewOdd( long long num1, long long num2, long long num3,
                long long num4 ); // предварителна декларация
  viewOdd(a, b, c, d);
}

void viewOdd( long long n1, long long n2, long long n3,
              long long n4 )
{
  cout << "Измежду " << n1 << ", " << n2 << ", " << n3 << " и "
       << n4;
  int number = countOdd(n1, n2, n3, n4);
  if( 0 == number ) {
    cout << " няма нечетни.\n";
    return;
  }
  cout << " има " << number << " нечетни.\n";
}
